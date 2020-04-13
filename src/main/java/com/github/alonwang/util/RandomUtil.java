package com.github.alonwang.util;

import java.util.ArrayList;
import java.util.List;
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

    public static List<Integer[]> batchGenerateRandomIntArray(int num, int length, int upperBound) {
        List<Integer[]> lists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lists.add(generateRandomIntArray(length, upperBound));
        }
        return lists;
    }
}
