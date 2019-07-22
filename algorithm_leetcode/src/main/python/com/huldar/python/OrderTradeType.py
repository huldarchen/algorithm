#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: OrderTradeType.py
@time: 2019/07/02
"""
from  pyspark.sql import SparkSession
import pyspark.sql.functions as F
from pyspark.sql.dataframe import DataFrame as  df

if __name__ == '__main__':
    spark = SparkSession.builder \
        .appName("vender trade_type group by vender user") \
        .enableHiveSupport() \
        .getOrCreate()

    storeInfo = spark.sql("""
        SELECT
           store_id AS storeId,store_test_flag
        FROM
           dim_data.dim_store
        """)

    orderInfo = spark.sql(
        """
        SELECT
         webuser_id AS user_id,vender_id,erp_store_id AS store_id,
         (CASE WHEN parent_id IS NOT NULL THEN parent_id ELSE id END) AS id,
         (
          IF (trade_type IS NOT NULL,trade_type,
          CASE WHEN order_type = 1 AND sale_type != 18 THEN '1'
          WHEN order_type = 1 AND sale_type = 18 THEN '18'
          WHEN order_type = 3 THEN '12'
          END)
          )AS trade_type,
         order_complete_time
        FROM
         dmall_order.wm_order
        WHERE
         (order_status = 64 OR order_status = 1024)
        AND
          erp_store_id != 8888
        AND
          erp_store_id != 432
        AND
         (
         webuser_id < 22500000
        OR
          webuser_id > 22500099
          )
        AND
        (
          trade_type IS NULL
        OR
          trade_type != 22
        )
        AND
         dt >= '20150101'
        AND
         dt < '20190701'
        """
    )
    F.broadcast()
