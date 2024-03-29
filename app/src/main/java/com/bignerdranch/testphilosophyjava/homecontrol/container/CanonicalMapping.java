package com.bignerdranch.testphilosophyjava.homecontrol.container;

import java.util.WeakHashMap;

public class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;
        if (args.length>0)
            size = new Integer(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map =
                new WeakHashMap<Key, Value>();
        for (int i = 0; i <size ; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i%3==0)
                keys[i]=k;
            map.put(k,v);
        }
        System.gc();
    }
}
