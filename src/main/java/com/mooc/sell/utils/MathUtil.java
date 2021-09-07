package com.mooc.sell.utils;

/**
 * @version 1.0
 * @author: liupurui
 * @create: 2021−09-02-22:01
 * @className: com.mooc.sell.utils.MathUtil
 * @description: TODO
 */
public class MathUtil {

    private static final double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(double d1, double d2) {
        double result = Math.abs(d1 - d2);
        return result < MONEY_RANGE;
    }
}