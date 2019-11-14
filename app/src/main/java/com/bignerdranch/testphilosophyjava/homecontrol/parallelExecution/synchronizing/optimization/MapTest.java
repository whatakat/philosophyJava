package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import java.util.Map;

public abstract class MapTest extends Tester<Map<Integer, Integer>> {
    MapTest(String testId, int nReaders, int nWriters){
        super(testId, nReaders, nWriters);
    }
    class Reader extends TestTask{
        long result = 0;
        void test(){
            for (long i = 0; i <testCycles ; i++)
                for (int index = 0; index <containerSize ; index++)
                    result +=testContainer.get(index);
        }
        void putResults(){
            readResult+=result;
            readTime+=duration;
        }
    }
    class Writer extends TestTask{
        void test(){
            for (long i = 0; i <testCycles ; i++)
                for (int index = 0; index <containerSize ; index++)
                    testContainer.put(index, writeData[index]);
        }
        void putResults(){
            writeTime+=duration;
        }
    }
    void startReadersAndWriters(){
        for (int i = 0; i <nReaders ; i++)
            exec.execute(new Reader());
        for (int i = 0; i < nWriters; i++)
            exec.execute(new Writer());
    }
}
