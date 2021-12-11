/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 11/03/2021
 */
package sample;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestWordFrequencies {
    WordFrequencies frequency = new WordFrequencies();

    @Test
    public void testInsertWord(){
        boolean isInserted = frequency.insertWord("testWord");
        assertEquals(true, isInserted);

    }
}
