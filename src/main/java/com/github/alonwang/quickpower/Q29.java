package com.github.alonwang.quickpower;

/**
 * 时间复杂度 O(logn)
 */
class Q29 {

    public int divide(int dividend, int divisor) {
        //两个int相除只有这种情况会溢出
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        return divide0(dividend, divisor);

    }

    public int divide0(long dividend, long divisor) {
        int sign = 1;
        //统一转化为正数
        if (dividend < 0) {
            dividend = -dividend;
            sign = -sign;
        }
        if (divisor < 0) {
            divisor = -divisor;
            sign = -sign;
        }
        //除数为1/-1就特殊处理不要用快速幂了
        if (divisor == 1) {
            return sign == 1 ? (int) dividend : (int) -dividend;
        }
        //快速幂
        int ans = 0;
        long pow = divisor;
        while (divisor <= dividend) {
            int count = 1;
            while (dividend >= (pow << 1)) {
                count = count << 1;
                pow = pow << 1;
            }
            dividend -= pow;
            pow = divisor;
            ans += count;
        }
        return sign == 1 ? ans : -ans;
    }
}