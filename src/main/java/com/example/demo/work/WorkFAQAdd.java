package com.example.demo.work;

import java.sql.*;

public class WorkFAQAdd {

    private String question;
    private String answer;

    public void work()
    {

        int i =0;
        try{
            String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1111";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM faq");
                while(resultSet.next()){

                    i = resultSet.getInt(1);

                }
            }

        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

        System.out.println(question+answer);
            try{
                String url = "jdbc:mysql://localhost/kursach?serverTimezone=Europe/Moscow&useSSL=false";
                String username = "root";
                String password = "1111";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

                try (Connection conn = DriverManager.getConnection(url, username, password)){

                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `faq`(idFAQ,question, answer) VALUE (?,?,?)");
                    pstmt.setInt(1, 1+i );
                    pstmt.setString(2, question);
                    pstmt.setString(3, answer);
                    pstmt.executeUpdate();

                }
            }
            catch(Exception ex){
                System.out.println("Connection failed...");

                System.out.println(ex);
            }

        }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

