package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import com.bignerdranch.testphilosophyjava.homecontrol.container.CountingIntegerList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest extends ListTest {
    List<Integer> containerInitializer(){
        return new CopyOnWriteArrayList<Integer>(
                new CountingIntegerList(containerSize));
    }
    CopyOnWriteArrayListTest(int nReaders, int nWriters){
        super("CopyOnWriteArrayList",nReaders, nWriters);
    }
}
