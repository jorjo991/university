package com.solvd.university.book;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class MobyDick {

    public static void main(String[] args) {

        File mobyDickFile = new File("src\\main\\resources\\MobyDick.txt");
        File resultFile = new File("src\\main\\resources\\Result.text");

        try {
            String content = StringUtils.replacePattern(FileUtils.readFileToString(mobyDickFile, StandardCharsets.UTF_8), "[^a-zA-Z ]", "");
            String result = StringUtils.join(Arrays.stream(StringUtils.split(content, " ")).distinct().toArray(), ",");
            FileUtils.write(resultFile, result);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
