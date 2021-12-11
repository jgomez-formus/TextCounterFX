/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 12/01/2021
 */
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlCon {

    static Connection getConnection(){

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/word_ocurrences?useSSL=false","root","Lady2020");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }


}
