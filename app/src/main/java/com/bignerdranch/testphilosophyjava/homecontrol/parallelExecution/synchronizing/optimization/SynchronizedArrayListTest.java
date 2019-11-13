package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import com.bignerdranch.testphilosophyjava.homecontrol.container.CountingIntegerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedArrayListTest extends ListTest {
    List<Integer> containerInitializer(){
        return Collections.synchronizedList(
                new ArrayList<Integer>(
                        new CountingIntegerList(containerSize)));
        }
        SynchronizedArrayListTest(int nReaders, int nWriters){
        super("Synched ArrayList",nReaders, nWriters);
    }
}
