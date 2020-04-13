package com.github.alonwang.sort;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Set;

public interface Sorter<T> {
    void sort(T[] arr);

    SorterType type();


    void benchmark();


    public static void main(String[] args) throws Exception {
        Reflections reflections = new Reflections(Sorter.class.getPackage().getName());
        Set<Class<? extends Sorter>> sorters = reflections.getSubTypesOf(Sorter.class);
        for (Class<? extends Sorter> sorterClazz : sorters) {
            if (Modifier.isAbstract(sorterClazz.getModifiers())) {
                continue;
            }
            Constructor<? extends Sorter> constructor = sorterClazz.getConstructor();
            Sorter sorter = constructor.newInstance();
            sorter.benchmark();
        }

    }
}
