package com.example.restful.common;

import java.util.List;

public interface BaseService<T> {
    List<T> selectAll();
    T selectById(int id);
    boolean addItem(T item);
    boolean deleteById(int id);

}
