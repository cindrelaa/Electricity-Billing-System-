package electricity.billing.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*;


public class database {
    Connection connection;
    Statement statement;
    database()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill_system","root","Cindrelaa_2005");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
