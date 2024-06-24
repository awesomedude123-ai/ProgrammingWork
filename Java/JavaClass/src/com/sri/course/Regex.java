package com.sri.course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher m = pattern.matcher("a1!");

        System.out.println(m.find());
    }
}
