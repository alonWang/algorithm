package com.github.alonwang.search;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * @author alonwang
 * @date 2020/4/15 19:04
 * @description
 * @detail
 */
public interface Searcher<T> {
    int search(T[] arr, T target);

    public static void main(String[] args) {
        Reflections reflections = new Reflections(Searcher.class.getPackage().getName());
        Set<Class<? extends Searcher>> classes = reflections.getSubTypesOf(Searcher.class);
        classes.forEach(clazz -> {
            if (Modifier.isAbstract(clazz.getModifiers())) {
                return;
            }
            try {
                Constructor<? extends Searcher> constructor = clazz.getConstructor();
                Searcher searcher = constructor.newInstance();
                if (searcher instanceof AbstractBinarySearcher) {
                    ((AbstractBinarySearcher) searcher).validate();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

    }
}
