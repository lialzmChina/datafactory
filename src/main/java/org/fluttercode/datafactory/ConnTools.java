package org.fluttercode.datafactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by lialzm on 2017/3/9.
 */
public class ConnTools {

    public static Connection makeConnection() {

        Properties prop = new Properties();
        String dirverClassName = null;
        String url=null;
        String user=null;
        String password=null;
        try {
            prop.load(ConnTools.class.getClassLoader().getResourceAsStream("resources.properties"));
            dirverClassName = prop.getProperty("connection.dirver_class_name");
            url = prop.getProperty("connection.url");
            user = prop.getProperty("connection.username");
            password = prop.getProperty("connection.password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            Class.forName(dirverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
