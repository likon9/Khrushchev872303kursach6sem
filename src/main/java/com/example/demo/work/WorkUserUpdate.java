package com.example.demo.work;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class WorkUserUpdate {

    private String login;
    private int cat;
    private String newlp;

    public void work()
   {
     int num=0;
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String log= resultSet.getString(2);
                    if(log.equals(login))
                    {
                        num=id;
                    }

                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        System.out.println(num);

        if(cat==1)
        {
            try{
                String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "1111";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    Statement statement = conn.createStatement();

                    PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET login = ? WHERE idUsers = ?");
                    pstmt.setString(1, newlp);
                    pstmt.setInt(2, num);
                    pstmt.executeUpdate();

                }
            }   catch(Exception ex){
                System.out.println("Connection failed...");

                System.out.println(ex);
            }

        }
        else {
            try{
                String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "1111";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    Statement statement = conn.createStatement();

                    PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET password = ? WHERE idUsers = ?");

                    pstmt.setString(1, newlp);
                    pstmt.setInt(2, num);
                    pstmt.executeUpdate();

                }
            }   catch(Exception ex){
                System.out.println("Connection failed...");

                System.out.println(ex);
            }
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getNewlp() {
        return newlp;
    }

    public void setNewlp(String newlp) {
        this.newlp = newlp;
    }
}
