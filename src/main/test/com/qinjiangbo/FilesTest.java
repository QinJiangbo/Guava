package com.qinjiangbo;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Date: 06/11/2016
 * Author: qinjiangbo@github.io
 */
public class FilesTest {

    public final String FILE_DIR = "/Users/Richard/Documents/R/";

    @Test
    public void testReadLines() throws IOException {
        String fileName = "data.txt";
        File file = new File(FILE_DIR + fileName);
        List<String> lines = Files.readLines(file, Charsets.UTF_8);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Test
    public void testReadFirstLine() throws IOException {
        String fileName = "data.txt";
        File file = new File(FILE_DIR + fileName);
        String line = Files.readFirstLine(file, Charsets.UTF_8);
        System.out.println(line); // I have a dream,
    }

    @Test
    public void testFileToByteArray() throws IOException {
        String fileName = "data.txt";
        File file = new File(FILE_DIR + fileName);
        byte[] bytes = Files.toByteArray(file);
        for (byte bt : bytes) {
            System.out.println(bt + " : " + (char) bt);
        }
    }

    @Test
    public void testFileToString() throws IOException {
        String fileName = "data.txt";
        File file = new File(FILE_DIR + fileName);
        String contents = Files.toString(file, Charsets.UTF_8);
        System.out.println(contents);
    }

    @Test
    public void testNewReader() throws IOException {
        String fileName = "data.txt";
        File file = new File(FILE_DIR + fileName);
        BufferedReader bufferedReader = Files.newReader(file, Charsets.UTF_8);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    @Test
    public void testTouch() throws IOException {
        String fileName = "data.txt";
        File file = new File(FILE_DIR + fileName);
        System.out.println(new Date(file.lastModified()));
        // Sun Nov 06 21:49:19 CST 2016
        Files.touch(file);
        System.out.println(new Date(file.lastModified()));
        // Sun Nov 06 22:14:26 CST 2016
    }

    @Test
    public void testWriteWithByteArray() throws IOException {
        String fileName = "data2.txt";
        File file = new File(FILE_DIR + fileName);
        String lyrics = "I will not make the same mistakes that you did\n" +
                "I will not let myself cause my heart so much misery\n" +
                "I will not break the way you did\n" +
                "You fell so hard\n" +
                "I learned the hard way, to never let it get that far";
        byte[] lyricsArray = lyrics.getBytes();
        Files.write(lyricsArray, file);
    }

    @Test
    public void testWriteWithCharSequence() throws IOException {
        String fileName = "data2.txt";
        File file = new File(FILE_DIR + fileName);
        String lyrics = "I will not make the same mistakes that you did\n" +
                "I will not let myself cause my heart so much misery\n" +
                "I will not break the way you did\n" +
                "You fell so hard\n" +
                "I learned the hard way, to never let it get that far";
        CharSequence charSequence = lyrics.subSequence(0, lyrics.length() - 1);
        Files.write(charSequence, file, Charsets.UTF_8);
    }

    @Test
    public void testNewWriter() throws IOException {
        String fileName = "data2.txt";
        File file = new File(FILE_DIR + fileName);
        String lyrics = "I will not make the same mistakes that you did\n" +
                "I will not let myself cause my heart so much misery\n" +
                "I will not break the way you did\n" +
                "You fell so hard\n" +
                "I learned the hard way, to never let it get that far";
        BufferedWriter bufferedWriter = Files.newWriter(file, Charsets.UTF_8);
        bufferedWriter.write(lyrics);
        bufferedWriter.close();
    }

}
