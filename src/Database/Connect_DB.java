
package Database;


import java.sql.*;


public class Connect_DB {
    public Connection getConnection(){
        Connection conn = null;
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLPH";
            String username = "sa";
            String pass = "12345678";
           conn =  DriverManager.getConnection(url, username, pass);
           if(conn!=null){
            System.out.println("Ket noi thanh cong");
           }
        }catch(Exception e){
            System.out.println(e.toString());
    }
        return conn;
}
}