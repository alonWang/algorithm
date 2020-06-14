package com.github.alonwang.depthfirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alonwang
 * @date 2020/6/12 16:19
 * @detail
 */
public class Q1376 {
    Map<Integer, List<Integer>> header2members;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        header2members = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int member = i;
            header2members.compute(manager[i], (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(member);
                return value;
            });
        }
        return minutes(headID, informTime);
    }

    private int minutes(int headID, int[] informTime) {
        if (!header2members.containsKey(headID)) {
            return 0;
        }

        int subInformTime = 0;
        for (Integer member : header2members.get(headID)) {
            subInformTime = Math.max(subInformTime, minutes(member, informTime));
        }
        return subInformTime + informTime[headID];
    }
}
