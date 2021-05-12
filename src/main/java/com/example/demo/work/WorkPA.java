package com.example.demo.work;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkPA{
    public String q;

    public WorkPA() {
        WorkAutorisastion workAutorisastion = new WorkAutorisastion();
        String[] cat = new String[1000];
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


                    if(use.equals(workAutorisastion.noOfInstances))
                    {
                        cat[i]=String.valueOf(categ);
                        question[i]=que;
                        answer[i]=ans;
                       i++;
                    }

                }
            }
        }  catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
        for (int i1=0; i1<i;i1++)
        {
            if(answer[i1]==null){answer[i1]="нет ответа";}
            if(cat[i1].equals("1")){cat[i1]="Помощь в эксплуатации";}
            else if(cat[i1].equals("2")){cat[i1]="Гарантийный ремонт";}
            else if(cat[i1].equals("3")){cat[i1]="Обслуживание";}
            else if(cat[i1].equals("4")){cat[i1]="Обновление";}
            else if(cat[i1].equals("5")) {cat[i1]="Сопутсвующие товары";}
        }
        if(i==0)
        {
            q="<p> Логин : "+workAutorisastion.noOfInstances+"</p></br><p>Вы еще не задали ни одного вопроса</p>";
        }
        else {

            q = "<p> Логин : " + workAutorisastion.noOfInstances + "</p>  <table > <tr> " +
                    " <th valign=\"top\" align =\"left\" width=\"100\" height = \"50\"> " + "Категория" +
                    "</th> <th valign=\"top\" align =\"left\" width=\"200\" height = \"50\">" + "Вопрос" +
                    " </th> <th valign=\"top\" align =\"left\" width=\"300\" height = \"50\">" + "Ответ" + "</th>  </tr>";
            for (int i1 = 0; i1 < i; i1++) {
                {
                    q = q + " <tr> " +
                            " <td valign=\"top\" align =\"left\" width=\"100\" height = \"50\">" + cat[i1] +
                            "</td> <td valign=\"top\" align =\"left\" width=\"200\" height =\"50\">" + question[i1] +
                            "</td> <td valign=\"top\" align =\"left\" width=\"300\" height = \"50\">" + answer[i1] + "</td> </tr>";
                }
            }
            q = q + " </table>";
        }
    }
}
