package com.example.uuz.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils() {
    }

    /**
     * @param source    要被转换的对象
     * @param clazz     传入** VO.class
     * @param <V>       class泛型
     * @return          返回class的类型对象
     */
    public static <V> V copyBean(Object source, Class<V> clazz) {
        //创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            //实现属性copy
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return result;
    }

    /**
     * @param list  传入的原本list集合
     * @param clazz 传入**VO.class
     * @param <O>   list集合泛型
     * @param <V>   class泛型
     * @return      返回class的类型的对象
     */
    public static <O, V> List<V> copyBeanList(List<O> list, Class<V> clazz) {
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
