package dataAccess;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DBConnect {
    public static final String DISK_DB_URL_PREFIX = "jdbc:sqlite:";
    private String dbUrl;
    private Connection connection;
    public DBConnect(String name){
        dbUrl = DISK_DB_URL_PREFIX + name;
        System.out.println("Connection url set.");
        openDBFile(name);
        createDBTables();
    }

    public Connection getConnection(){
        try{
            connection = DriverManager.getConnection(dbUrl);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void createDBTables(){
        String tableQuery1;
        try(Connection connection = DriverManager.getConnection(dbUrl);
            final Statement stmt = connection.createStatement()
            ){
            tableQuery1 = "CREATE TABLE quotes ("
                    +   " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    +   " text TEXT UNIQUE,"
                    +   " name TEXT UNIQUE)";
            stmt.executeUpdate(tableQuery1);
            System.out.println("Table created successfully");
        }
        catch (SQLException e){
            System.out.println("Tables already exist");
        }
    }


    private void openDBFile(String name){
        try{
        boolean dbFile = new File(name).createNewFile();
        if( !dbFile) {
            dbUrl = DISK_DB_URL_PREFIX + name;
            System.out.printf("Database file: \"%s\" already exists.\n", name);
        }
        else{
            System.out.printf("Database file: \"%s\" not found.\n", name);
            System.out.printf("Database file \"%s\" created.\n", name);
        }
        }catch (IOException e){
            e.getMessage();
        }
    }

}
