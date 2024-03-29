package com.bignerdranch.testphilosophyjava.homecontrol.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.bignerdranch.testphilosophyjava.homecontrol.print.Print.print;


public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc =
                new FileOutputStream("C:\\Geekbrains\\7.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        fc =
                new RandomAccessFile("C:\\Geekbrains\\7.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("Some more ".getBytes()));
        fc.close();
        fc = new FileInputStream("C:\\Geekbrains\\7.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            print((char)buff.get());

    }
}
