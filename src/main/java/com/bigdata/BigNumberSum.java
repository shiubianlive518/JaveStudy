package com.bigdata;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 超范围类型数据运算
 * @author marvinteng
 */
public class BigNumberSum {
    
    /**
     * 大整形求和
     * https://mp.weixin.qq.com/s/Quw4olmTYEE4qLCupld91A
     * @param bigNumberA
     * @param bigNumberB
     * @return
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        // 1.把2个大整形数用数组逆序存储
        char[] charsA = new StringBuffer(bigNumberA).reverse().toString().toCharArray();
        char[] charsB = new StringBuffer(bigNumberB).reverse().toString().toCharArray();
        
        // 2.构建result数组，数组长度等于较大整数位数+1
        int maxLength = charsA.length > charsB.length ? charsA.length : charsB.length;
        int[] result = new int[maxLength + 1];
        
        // 3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            if (i < charsA.length) {
                temp += charsA[i] - '0';//减'0'是为了把char类型的数字字符转成对应的整型
            }
            if (i < charsB.length) {
                temp += charsB[i] - '0';
            }
            // 判断是否进位
            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        
        // 4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }
            if (flag) {
                flag = false;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== bigNumberSum   ===> " + bigNumberSum("426709752318", "95481253129"));
        
        BigInteger bigInteger = new BigInteger("426709752318");
        System.out.println("=== BigInteger add ===> " + bigInteger.add(new BigInteger("95481253129")));
        
        BigDecimal bigDecimal = new BigDecimal("426709752318");
        System.out.println("=== BigDecimal add ===> " + bigDecimal.add(new BigDecimal("95481253129")));
    }

}
