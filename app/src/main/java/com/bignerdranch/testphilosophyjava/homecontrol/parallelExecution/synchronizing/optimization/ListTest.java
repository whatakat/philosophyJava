package com.bignerdranch.testphilosophyjava.homecontrol.parallelExecution.synchronizing.optimization;

import java.util.List;

public class ListTest extends Tester<List<Integer>> {
    @Override
    List<Integer> containerInitializer() {
        return null;
    }

    ListTest(String testId, int nReaders, int nWriters){
        super(testId, nReaders, nWriters);
    }
    class Reader extends TestTask{
        long result = 0;
        void test(){
            for (long i = 0; i < testCycles; i++)
                for (int index = 0; index<containerSize; index++)
                    result +=testContainer.get(index);
        }
        void putResults(){
            readResult +=result;
            readTime +=duration;
        }
    }
    class Writter extends TestTask{
        void test(){
            for(long i = 0; i<testCycles; i++)
                for (int index = 0; index < containerSize; index++)
                    testContainer.set(index, writeData[index]);
        }
        void putResults(){
            writeTime+=duration;
        }
    }
    void startReadersAndWriters(){
        for (int i = 0; i < nReaders; i++)
            exec.execute(new Reader());
        for (int i = 0; i < nWriters; i++)
            exec.execute(new Writter());
    }

}
