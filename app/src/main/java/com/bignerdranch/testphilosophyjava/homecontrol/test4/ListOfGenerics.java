package com.bignerdranch.testphilosophyjava.homecontrol.test4;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();
    public void add(T item){array.add(item);}
    public T get(int index){return array.get(index);}
}
