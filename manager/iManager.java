package manager;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public interface iManager<E> {
    void add(E e);
    void delete(String id);
    E findById(String id);
    void update(String id,E e);
    void findIndexById(String id);



    List<E> findAll();
    List<E> findByName(String name);
    void getMaxAvg();
 }
