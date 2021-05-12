package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkShowAdmins {
    public String admins;


    public WorkShowAdmins () {

        int[] id = new int[1000];
        String[] login = new String[1000];



        int i =0;
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM admins");
                while(resultSet.next()){

                    id[i] = resultSet.getInt(1);
                    login[i] = resultSet.getString(2);
                    i++;

                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        admins = "<table >";
        admins = admins + " <tr> " +
                " <th valign=\"top\" align =\"left\" width=\"50\" height = \"50\">" + "id" +
                " </th> <th valign=\"top\" align =\"left\" width=\"200\" height = \"50\">" + "логин" + "  </tr>";
        for(int i1=0;i1<i;i1++) {
            {
                admins = admins + " <tr> " +
                        " <td valign=\"top\" align =\"left\" width=\"50\" height = \"50\">" + id[i1] +
                        " </td> <td valign=\"top\" align =\"left\" width=\"200\" height = \"50\">" + login[i1] + "</td>  </tr>";
            }

        }
        admins=admins+" </table>";
        return;

    }


}
