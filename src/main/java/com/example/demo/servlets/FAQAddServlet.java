package com.example.demo.servlets;


import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkFAQAdd;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet(name = "FAQAddServlet", value = "/FAQAdd-servlet")
public class FAQAddServlet extends HttpServlet {




    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/FAQAdd.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String question = new String(req.getParameter("question").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String answer = new String(req.getParameter("answer").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        WorkFAQAdd workFAQAdd = new WorkFAQAdd();
        workFAQAdd.setQuestion(question);
        workFAQAdd.setAnswer(answer);
        workFAQAdd.work();
        req.setAttribute("message","Вопрос добавлен" );
        req.getRequestDispatcher("/FAQAdd.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/demo_war_exploded/FAQAdd-servlet").forward(req, resp);

    }


    @Override
    public void destroy() {

    }
}
