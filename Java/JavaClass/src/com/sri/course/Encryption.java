package com.sri.course;

import java.util.*;

public class Encryption {
    public static void main(String[] args) {
        Scanner oldScanner = new Scanner(System.in);
        System.out.println("Please enter a sentence or phrase. ");
        String sentence = oldScanner.nextLine();
        sentence = encrypted(sentence);
        System.out.println("1: " + sentence);
        sentence = encrypted(sentence);
        System.out.println("2: " + sentence);
        sentence = encrypted(sentence);
        System.out.println("3: " + sentence);
    }

    public static String encrypted(String input){
        String encrypted = "";
        ArrayList<Character> letters = new ArrayList<>();
        for(char i = 'a'; i <= 'z'; i++) {
            letters.add(i);
        }
        char[] punctuation = "!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~\"".toCharArray();
        for(int i=0;i<input.length();i++){
            if(letters.contains(Character.toLowerCase(input.charAt(i)))){
                int x = (int) (25 * Math.random());
                encrypted = encrypted + letters.get(x);
            }else{
                if(input.charAt(i) != ' '){
                    int x = (int) (35 * Math.random());
                    encrypted = encrypted + punctuation[x];
                }else{
                    encrypted = encrypted + " ";
                }

            }
        }
        return encrypted;
    }//end encrypted method
}
