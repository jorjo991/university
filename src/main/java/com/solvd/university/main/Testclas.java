package com.solvd.university.main;

import com.solvd.university.administraion.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class Testclas {

    private static final Logger LOGGER = LogManager.getLogger(Testclas.class.getName());

    public static void main(String[] args) {
        LOGGER.info(StringUtils.remove("giorgi", 'g'));
        LOGGER.info(StringUtils.removeStart("abgiogiorgi", "gio"));
        LOGGER.info(Arrays.toString(StringUtils.split("giorgi")));
        LOGGER.info(Arrays.toString(StringUtils.split("giorgi", 'c')));
        LOGGER.info(StringUtils.indexOf("gio", 'i'));
        LOGGER.info(StringUtils.join(new char[]{'a', 'b', 'c'}, ','));
        LOGGER.info(StringUtils.getCommonPrefix("abcd", "agmd"));
        LOGGER.info(StringUtils.strip("--modiaba--", "--"));

    }
}
