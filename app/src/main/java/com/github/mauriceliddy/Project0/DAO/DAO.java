package com.github.mauriceliddy.Project0.DAO;
import java.util.List;


public interface DAO<E> {
    void insert(E e);
    List<E> getAll();
    void update(E e);
    void delete(E e);
    void clearTable();
    
}
