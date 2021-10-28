/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 10/27/2021
 * @repository https://github.com/jgomez-formus/TextCounterFx
 */
package sample;

public class WordOcurrence {

    private String ranking = null;
    private String word = null;
    private String wordCount = null;

    public WordOcurrence() {
    }

    public WordOcurrence(String ranking, String word, String wordCount) {
        this.ranking = ranking;
        this.word = word;
        this.wordCount = wordCount;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.word = wordCount;
    }
}
