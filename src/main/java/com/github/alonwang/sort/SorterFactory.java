package com.github.alonwang.sort;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class SorterFactory {
    private static Map<SorterType, Sorter> sorters = new ConcurrentHashMap<>(SorterType.values().length);

    public static Sorter get(SorterType type) {
        Function<SorterType, Sorter> mapper = t -> {
            switch (t) {
                case Bubble:
                    return new BubbleSorter();
                case Select:
                    return new SelectSorter();
                case Insert:
                    return new InsertSorter();
                case Merge:
                    return new MergeSorter();
                case Quick:
                    return new QuickSorter();
                case Shell:
                    return new ShellSorter();
                default:
                    throw new IllegalArgumentException(type + " have no related Sorter");
            }
        };
        return sorters.computeIfAbsent(type, mapper);

    }
}
