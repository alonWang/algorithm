package com.github.alonwang.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    public static Integer[] generateRandomIntArray() {
        return generateRandomIntArray(6, 20);
    }

    public static Integer[] generateRandomIntArray(int length, int upperBound) {
        assert length > 0;
        assert upperBound > 0;
        Integer[] arr = new Integer[length];
        for (int j = 0; j < length; j++) {
            arr[j] = ThreadLocalRandom.current().nextInt(upperBound);
        }
        return arr;
    }
}
