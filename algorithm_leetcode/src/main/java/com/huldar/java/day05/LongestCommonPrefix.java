package com.huldar.java.day05;

/**
 * LCP-最长公共前缀
 * 有多种解法
 *
 * @author huldar
 * @date 2019/6/15 15:48
 */
public class LongestCommonPrefix {
    /**
     * 方法一:暴力解
     * <p>
     * 使用到的公式是LCP(S1​…Sn​)=LCP(LCP(LCP(S1​,S2​),S3​),…Sn​)
     * 第一次把第一个字符串作为最长公共前缀,然后从第2个字符串开始遍历字符串数组,在其中对比公共字符串
     * 当遍历到第 ii 个字符串的时候，找到最长公共前缀.
     * 是一个空串的时候，算法就结束
     * <image alt="水平扫描" src="https://www.github.com/huldarchen/nodeimage/raw/master/img/2019615/1560584806872.png"/>
     * 时间复杂度,是O(N)
     *
     * @param strs 要找的最长前缀字符串数组
     * @return 最长公共字符串
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 方法二:暴力破解优化版
     * 取字符串数组中最短的字符串作为最长公共字符串,默认第一个字符为最短的
     * 时间复杂度,是O(N),N为所有字符串中所有的字符之和
     * 最坏情况下，输入数据为 n 个长度为 m 的相同字符串，算法会进行 S = m*n 次比较。可以看到最坏情况下，本算法的效率与算法一相同，
     * 但是最好的情况下，算法只需要进行 n*minLen 次比较，其中 minLen 是数组中最短字符串的长度。
     *
     * @param strs 要找的最长前缀字符串数组
     * @return 最长公共字符串
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return firstStr;
    }

    /**
     * 解法三:分治算法
     * 这个算法的思路来自于LCP操作的结合律。我们可以发现：
     * LCP(S1...Sn)=LCP(LCP(S1...Sk),LCP(S{k+1}...Sn))LCP(S1​…Sn​)=LCP(LCP(S1​…Sk​),LCP(Sk+1​…Sn​))，
     * 其中LCP(S1...Sn)LCP(S1​…Sn​)是字符串[S1...Sn][S1​…Sn​]的最长公共前缀，1<k<n。
     * <image alt="水平扫描" src="https://www.github.com/huldarchen/node_image/raw/master/img/2019615/1560587165786.png"/>
     * 算法总结:
     * 最坏情况下,我们有n个长度为m的相同字符串。
     * 时间复杂度：O(S),S是所有字符串中字符数量的总和，S=m*n。
     * 时间复杂度的递推式为 T(n)=2·T(n\2)+O(m)， 化简后可知其就是 O(S)。
     * 最好情况下，算法会进行 minLen·n次比较，其中 minLen 是数组中最短字符串的长度。
     * <p>
     * 空间复杂度:O(m⋅log(n))
     * 内存开支主要是递归过程中使用的栈空间所消耗的。一共会进行log(n)次递归，每次需要m的空间存储返回结果，所以空间复杂度为O(m⋅log(n))。
     *
     * @param strs 要找的最长前缀字符串数组
     * @return 最长公共字符串
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //采用分治思想
        return longestCommonPrefixMap(strs, 0, strs.length - 1);
    }

    /**
     * 解法四:二分查找法
     * 这个想法是应用二分查找法找到所有字符串的公共前缀的最大长度L。
     * 算法的查找区间是(0…minLen)，其中minLen是输入数据中最短的字符串的长度，同时也是答案的最长可能长度。
     * 每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。算法进行的过程中一共会出现两种可能情况：
     * 1.S[1...mid] 不是所有串的公共前缀。 这表明对于所有的 j > i S[1..j] 也不是公共前缀，于是我们就可以丢弃后半个查找区间。
     * 2.S[1...mid]是所有串的公共前缀。这表示对于所有的i<j S[1..i]都是可行的公共前缀，因为我们要找最长的公共前缀，所以我们可以把前半个查找区间丢弃
     * <image alt="水平扫描" src="https://www.github.com/huldarchen/node_image/raw/master/img/2019615/1560591562859.png"/>
     *
     * @param strs 要找的最长前缀字符串数组
     * @return 最长公共字符串
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        int low = 1;
        int high = min;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    private static String longestCommonPrefixMap(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String lcpLeft = longestCommonPrefixMap(strs, 1, mid);
            String lcpRight = longestCommonPrefixMap(strs, mid + 1, right);
            return commonprefis(lcpLeft, lcpRight);
        }
    }

    /**
     * 对最终的结果字符串取最短的值
     *
     * @param lcpLeft  分治左侧得到的结果字符串
     * @param lcpRight 分治右侧得到的结果字符串
     * @return 最终的最长公共前缀
     */
    private static String commonprefis(String lcpLeft, String lcpRight) {
        int min = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < min; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, min);
    }


}
