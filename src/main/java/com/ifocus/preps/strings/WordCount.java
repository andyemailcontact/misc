package com.ifocus.preps.strings;

class WordCount {
    public static void main(String[] args) {
        String input = " this is a test ";
        String cleanedInput = input.trim();
        int count = 0;
        if(cleanedInput.length() > 0){
            count++;
            char[] inputAsArray = cleanedInput.toCharArray();
            char previous = inputAsArray[0];
            for(char c : inputAsArray) {
                if(Character.isWhitespace(c) && previous != ' '){
                    count++;
                }
                previous = c;
            }
        }
        System.out.println("final count is: " + count);
    }
}
