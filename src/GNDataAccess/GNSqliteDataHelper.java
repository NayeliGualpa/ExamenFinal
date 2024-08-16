package GNDataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GNSqliteDataHelper {
   private static String  DBPathConnection ="jdbc:sqlite:DataBase//GNEcuaFauna2K24A.sqlite";
   private static Connection conn= null;
//    protected SqliteDataHelper(){}
   
   protected static synchronized Connection openConnection() throws Exception {
    try {
        if(conn == null)
            conn = DriverManager.getConnection(DBPathConnection);
    } catch (SQLException e) {
        throw e;  //new Exeption (e, "SqliteDateHelper" , "Fallo la conneccion a la base de datos")
    }
    return conn;
   }


   protected static void closeConnection() throws Exception {
    try {
        if(conn != null)
            conn.close();
    } catch (Exception e) {
        throw e;  //new Exeption (e, "SqliteDateHelper" , "Fallo la conneccion a la base de datos")
    }
   }
}






