/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 12/01/2021
 */

package sample;

import java.sql.*;

public class WordOcurrenceModel {

    public void insertWord(String word) throws SQLException {

        boolean isWordInDb = verifyWord(word);
        System.out.println("Word--> " + word + " isWordInDb--> " +  isWordInDb);
        if (isWordInDb){
            System.out.println("Update word count... " );
            String sql = "UPDATE word_frequency SET occurrences=occurrences+1 WHERE word = ?";
            Connection con = MysqlCon.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, word);
            stmt.executeUpdate();
            con.close();
        } else {
            System.out.println("Inserting words into the table...");
            String sql = "INSERT INTO word_frequency(word, occurrences) values(?, 1)";
            Connection con = MysqlCon.getConnection();
            con.setAutoCommit(false);

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, word);
            stmt.executeUpdate();
            con.commit();
            con.close();
        }


    }

    private boolean verifyWord(String word) throws SQLException {
        String sql = "SELECT * FROM word_frequency WHERE word = ? ";
        Connection con = MysqlCon.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(sql);     // create a prepared statement
        preparedStatement.setString(1, word);

        ResultSet rs = preparedStatement.executeQuery();

        if (!rs.next()) {
            System.out.println("No records found");
            con.close();
            return false;
        } else {
            System.out.println("Records found should increment");
            con.close();
            return true;
        }

    }


    public void createWordsTable() throws SQLException {

        // create table query
        String sql = "CREATE TABLE word_frequency " +
                "(" +
                "id INTEGER AUTO_INCREMENT, " +
                "word VARCHAR(50) NOT NULL, " +
                "occurrences INTEGER NOT NULL, "+
                "PRIMARY KEY (id) " +
                ")  ENGINE=INNODB;";

        Connection con = MysqlCon.getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Table created successfully...");
    }


    public void getResults() throws SQLException {
        String sql = "SELECT * FROM word_frequency ORDER BY occurrences DESC";
        Connection con = MysqlCon.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(sql);     // create a prepared statement

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String word = rs.getString("word");
            int occurrences = rs.getInt("occurrences");

            System.out.println("W--> " + word + " O--> " + occurrences);

        }
        con.close();


    }
}
