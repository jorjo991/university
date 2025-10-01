package com.solvd.university.book;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class MobyDick {

    public static void main(String[] args) {

        File moby_dick = new File("C:\\Users\\Admin\\Desktop\\University\\university\\src\\main\\resources\\Moby-Dick.txt");
        File resultFile = new File("C:\\Users\\Admin\\Desktop\\University\\university\\src\\main\\resources\\Result.txt");

        try {
            String content = StringUtils.replacePattern(FileUtils.readFileToString(moby_dick, StandardCharsets.UTF_8), "[^a-zA-Z ]", "");
            String result = StringUtils.join(Arrays.stream(StringUtils.split(content, " ")).distinct().toArray(), ",");
            FileUtils.write(resultFile, result);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
