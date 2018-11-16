package com.example.josh.week4test_schools.Part2;

public class Main {

    public static void main(String[] args) {

        String input = "chicken soup";

        String[] inputArray = splitString(input);

        for (String word: inputArray) {
            int consStop = findCons(word);
            word = word.substring(consStop) + word.substring(0,consStop) + "ay";
            System.out.println(word);
        }
    }

    public static int findCons(String input){

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == 'a' || current == 'e' || current == 'i'
                    || current == 'o' || current == 'u'){
                return i;
            }
        }

        return 0;
    }
    public static String mergeString(String[] inputArray){
        String output = "";
        for(String word: inputArray)
            output.concat(word + "");

        return output;
    }

    public static String[] splitString(String input){
        return input.split(" ");
    }
}
