package com.example.demo.servlets;

import com.example.demo.work.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet(name = "AddAnswerServlet", value = "/AddAnswer-servlet")
public class AddAnswerServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WorkShowQuestion1 workShowQuestion1 = new WorkShowQuestion1();
        workShowQuestion1.Work();
        req.setAttribute("q",workShowQuestion1.getQwe());
        req.getRequestDispatcher("AddAnswer.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/AddAnswer.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = new Integer(req.getParameter("id"));
        String answer = new String(req.getParameter("answerr").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(answer);
        WorkAddAnswer workAddAnswer= new WorkAddAnswer();
        workAddAnswer.setId(id);
        workAddAnswer.setAnswer(answer);
        workAddAnswer.work();
        doGet(req,resp);
    }

    @Override
    public void destroy() {
    }

}
