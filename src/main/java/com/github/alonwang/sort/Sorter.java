package com.github.alonwang.sort;

import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;

public interface Sorter<T> {
    void sort(T[] arr);

    SorterType type();


    void benchmark();


    public static void main(String[] args) {
        Reflections reflections = new Reflections(Sorter.class.getPackage().getName());
        Set<Class<? extends Sorter>> sorters = reflections.getSubTypesOf(Sorter.class);
        sorters.forEach(sorterClazz -> {
            if (Modifier.isAbstract(sorterClazz.getModifiers())) {
                return;
            }
            try {
                //TODO refactor with Constructor
                Sorter sorter = sorterClazz.newInstance();
                sorter.benchmark();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
