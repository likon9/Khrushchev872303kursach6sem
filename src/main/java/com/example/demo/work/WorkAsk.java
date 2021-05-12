package com.example.demo.work;

import java.sql.*;

public class WorkAsk extends WorkAutorisastion{
    protected int cat;
    protected String question;

    public void work()
    {
        int[] id = new int[1000];
        String[] q = new String[1000];
        String[] a = new String[1000];

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
                    System.out.println(id[i]);
                    i++;
                }
            }

        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

       int newid = id[i-1]+1;
        System.out.println(newid);



            try{
                String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "1111";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `question`(idquestion,category,question,user) VALUE (?,?,?,?)");
                    pstmt.setInt(1, newid );
                    pstmt.setInt(2, cat);
                    pstmt.setString(3, question);
                    pstmt.setString(4, noOfInstances);
                    pstmt.executeUpdate();

                }
            }
            catch(Exception ex){
                System.out.println("Connection failed...");

                System.out.println(ex);
            }



    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
