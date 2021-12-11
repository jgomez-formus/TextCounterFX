/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 11/03/2021
 */
package sample;

import java.util.HashMap;

public class WordFrequencies {
    HashMap<String, Integer> wordCountHolder = new HashMap<String, Integer>();


    public boolean insertWord(String word) {
        // System.out.println("original string--> " + String.valueOf(word));
        word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        // System.out.println("clear string--> " + String.valueOf(word));
        if (wordCountHolder.containsKey(word)) {
            wordCountHolder.put(word, wordCountHolder.get(word) + 1);
        } else {
            wordCountHolder.put(word, 1);
        }

        return true;

    }






}
