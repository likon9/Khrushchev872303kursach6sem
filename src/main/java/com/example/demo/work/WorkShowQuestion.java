package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkShowQuestion {

    private String qwe;

    public void Work() {

        int[] id = new int[1000];
        String[] cat = new String[1000];
        String[] question = new String[1000];
        String[] answer = new String[1000];
        String[] user = new String[1000];

        int i =0;
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM question");
                while(resultSet.next()){

                    id[i] = resultSet.getInt(1);
                    cat[i] = resultSet.getString(2);
                    question[i] = resultSet.getString(3);
                    answer[i] = resultSet.getString(4);
                    user[i] = resultSet.getString(5);
                    i++;
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

        for (int i1=0; i1<i;i1++)
        {
            if(answer[i1]==null){answer[i1]="нет ответа";}
            if(cat[i1].equals("1")){cat[i1]="Помощь в установке и использовании программ";}
            else if(cat[i1].equals("2")){cat[i1]="Помощь в выборе и использовании комплектующих";}
            else if(cat[i1].equals("3")){cat[i1]="Обслуживание";}
            else if(cat[i1].equals("4")){cat[i1]="Обновление комплектующих";}
            else if(cat[i1].equals("5")) {cat[i1]="Сопутсвующие товары";}
        }
        qwe = "<table > <th valign=\"top\" align =\"left\" width=\"20\" height = \"50\">" + "id" +
                " </th> <th valign=\"top\" align =\"left\" width=\"200\" height = \"50\">" + "категория" +
                "</th> <th valign=\"top\" align =\"left\" width=\"300\" height = \"50\">" + "вопрос" +
                " </th> <th valign=\"top\" align =\"left\" width=\"300\" height = \"50\">" + "ответ" +
                " </th> <th valign=\"top\" align =\"left\" width=\"100\" height = \"50\">" + "пользователь" + "</th>  </tr>";

        for(int i1=0;i1<i;i1++) {
            {

                qwe = qwe + " <tr> " +
                        "<td valign=\"top\" align =\"left\" width=\"20\" height = \"50\">" + id[i1] +
                        " </td> <td valign=\"top\" align =\"left\" width=\"200\" height = \"50\">" + cat[i1] +
                        "</td> <td valign=\"top\" align =\"left\" width=\"300\" height = \"50\">" + question[i1] +
                        " </td> <td valign=\"top\" align =\"left\" width=\"300\" height = \"50\">" + answer[i1] +
                        " </td> <td valign=\"top\" align =\"left\" width=\"100\" height = \"50\">" + user[i1] + " </td> </tr>";
            }
        }
        qwe=qwe+" </table>";
        return;
    }

    public String getQwe() {
        return qwe;
    }
}
