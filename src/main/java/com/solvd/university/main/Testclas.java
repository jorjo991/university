package com.solvd.university.main;
import  org.apache.commons.lang3.StringUtils;

import java.util.Arrays;



public class Testclas {


    public static void main(String[] args) {
        System.out.println(StringUtils.remove("giorgi",'g'));
        System.out.println(StringUtils.removeStart("abgiogiorgi","gio"));
        System.out.println(Arrays.toString(StringUtils.split("giorgi")));
        System.out.println(Arrays.toString(StringUtils.split("giorgi",'c')));
        System.out.println(StringUtils.indexOf("gio",'i'));
        System.out.println(StringUtils.join(new char[]{'a','b','c'},','));
        System.out.println(StringUtils.getCommonPrefix("abcd","agmd"));
        System.out.println(StringUtils.strip("--modiaba--","--"));


    }
}
