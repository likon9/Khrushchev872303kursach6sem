package com.example.demo.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkQuestion {

    protected int num;
    protected String q;

    public WorkQuestion() {

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public void work()
    {

        int[] cat = new int[1000];
        String[] question = new String[1000];
        String[] answer = new String[1000];
        String[] user = new String[1000];
        int i=0;

        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM question");
                while(resultSet.next()){

                    int id= resultSet.getInt(1);
                    int categ  = resultSet.getInt(2);
                    String que = resultSet.getString(3);
                    String ans = resultSet.getString(4);
                    String use = resultSet.getString(5);
                    if(categ==num)
                    {
                        question[i]=que;
                        if (ans==null)
                        {answer[i]="нет ответа(";}else
                        { answer[i]=ans;}
                        user[i]= use;
                        i++;
                    }
                }
            }
        }  catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

        System.out.println("i="+i);
        q = "<table > <tr> " +
                "<th valign=\"top\" align =\"left\" width=\"300\" height =\"50\">"+"Вопрос" +
                "</th> <th valign=\"top\" align =\"left\" width=\"500\" height = \"50\">" + "Ответ" +
                " </th> <th valign=\"top\" align =\"left\" width=\"100\" height = \"50\">" + "Пользователь" + "<th> </tr>";
        for(int i1=0;i1<i;i1++) {
            {
                q = q + " <tr> " +
                        "<td valign=\"top\" align =\"left\" width=\"300\" height =\"50\">"+question[i1] +
                        "</td> <td valign=\"top\" align =\"left\" width=\"500\" height = \"50\">" + answer[i1] +
                        " </td> <td valign=\"top\" align =\"left\" width=\"100\" height = \"50\">" + user[i1] + "</td> </tr>";
            }

        }
        q=q+" </table>";
        System.out.println(q);

    }



}
