import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._

/**
  *
  * TODO
  */
case class Result(dataId: String, apple: String, banana: String, pear: String)

object FixLastOrderGroupByTradeType {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("fix data")
      .config("hive.exec.dynamic.partition", value = true) // 支持 Hive 动态分区
      .config("hive.exec.dynamic.partition.mode", "nonstrict") // 非严格模式
      .enableHiveSupport()
      .getOrCreate()
    import spark.implicits._

    val storeInfo = broadcastStoreInfo(spark)
    val orderInfo = getOrderInfo(spark, "20150101", "20190701")
      .filter($"trade_type".isNotNull)
      .join(storeInfo, $"storeId" === $"store_id", "left_outer")
      .filter($"store_test_flag" =!= 2)
      .select($"user_id", $"vender_id", $"store_id", $"id", $"trade_type", $"order_complete_time")
      .withColumn("vender_last", row_number().over(Window.partitionBy($"vender_id", $"user_id", $"trade_type").orderBy($"order_complete_time".desc_nulls_last)))
      .withColumn("store_last", row_number().over(Window.partitionBy($"store_id", $"user_id", $"trade_type").orderBy($"order_complete_time".desc_nulls_last)))
      .filter($"vender_last" === 1 or $"store_last" === 1)


//    orderInfo
//      .filter($"vender_last" === 1)
//      .select(concat_ws("_", $"vender_id", $"user_id") as "data_id", array($"trade_type", concat_ws("_", $"id", $"order_complete_time")) as "kv")
//      .groupBy($"data_id")
//      .agg(collect_list($"kv") as "kvs")
//      .map(row => {
//        val kvs = row.getAs[String]("kvs")
//      }).show()
//
//    val sc = spark.sparkContext
//    val a = sc.parallelize(Array((Array("1", "fruit"), "apple,banana,pear,jwb"), (Array("2", "animal"), "pig,cat,dog,tiger")))
//    val b = a.flatMapValues(_.split(",")).map(ele => {
//      val num = ele._1(0)
//      val name = ele._1(1)
//      val cate = ele._2
//      (num, name, cate)
//    })
//    case class Grouped(num: String, kvs: Seq[Map[String, String]])
//    val bdf = b.toDF("num", "name", "cate")


//    bdf.select($"num", map($"cate", $"name") as "kv")
//      .groupBy($"num")
//      .agg(collect_list($"kv") as "kvs")
//      .as[Grouped]
//      .map(g => {
//        val id = g.num
//        val kvsList = g.kvs
//        val map = kvsList.fold(Map()) { (x, y) => x ++ y }
//        val apple = map.getOrElse("apple",null)
//        val banana = map.getOrElse("banana",null)
//        val pear = map.getOrElse("pear",null)
//        Result(id,apple,banana,pear)
//      })


    spark.stop()

  }

  def getOrderInfo(spark: SparkSession, startDt: String, endDt: String): DataFrame = {
    val execuSql =
      s"""
         |SELECT
         | webuser_id AS user_id,vender_id,erp_store_id AS store_id,
         | (CASE WHEN parent_id IS NOT NULL THEN parent_id ELSE id END) AS id,
         | (
         |  IF (trade_type IS NOT NULL,trade_type,
         |  CASE WHEN order_type = 1 AND sale_type != 18 THEN '1'
         |  WHEN order_type = 1 AND sale_type = 18 THEN '18'
         |  WHEN order_type = 3 THEN '12'
         |  END)
         |  )AS trade_type,
         | order_price,
         | (ware_total_price-promotion_price) AS gmv,
         | order_complete_time,
         | dt
         |FROM
         | dmall_order.wm_order
         |WHERE
         | (order_status = 64 OR order_status = 1024)
         |AND
         |  erp_store_id != 8888
         |AND
         |  erp_store_id != 432
         |AND
         | (
         | webuser_id < 22500000
         |OR
         |  webuser_id > 22500099
         |  )
         |AND
         |(
         |  trade_type IS NULL
         |OR
         |  trade_type != 22
         |)
         |AND
         | dt >= '$startDt'
         |AND
         | dt < '$endDt'
      """.stripMargin
    spark.sql(execuSql)
  }

  /**
    * 广播商家门店基本信息表
    *
    * @param spark [[SparkSession]] spark的入口
    * @return 结果表
    */
  def broadcastStoreInfo(spark: SparkSession): Dataset[Row] = {
    val exeueSql =
      """
        |SELECT
        |   store_id AS storeId,store_test_flag
        |FROM
        |   dim_data.dim_store
      """.stripMargin
    val venderStoreDF = spark.sql(exeueSql)
    venderStoreDF.cache()
    broadcast(venderStoreDF)
  }
}
