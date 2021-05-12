package com.example.demo.work;

import com.example.demo.p1.Autorisation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkAutorisastion extends Autorisation {

    public static String noOfInstances;
    public int t;
    public  String log;

    public void enter()
    {
        int[] id = new int[1000];
        String[] login = new String[1000];
        String[] pass = new String[1000];

        int i =0;
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    id[i] = resultSet.getInt(1);
                    login[i] = resultSet.getString(2);
                    pass[i] = resultSet.getString(3);

                    i++;
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

        for (int i1 = 0; i1 < i; i1++)
        {
            if(getLogin().equals(login[i1]))
            {
                if(getPassword().equals(pass[i1]))
                {
                    t=1;
                    noOfInstances=login[i1];
                }
            }
        }
    }
    }


