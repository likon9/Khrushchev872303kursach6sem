package com.example.demo.servlets;

import com.example.demo.work.WorkDeleteQuestion;
import com.example.demo.work.WorkQuestion;
import com.example.demo.work.WorkShowQuestion;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet(name = "QuestionDeleteServlet", value = "/QuestionDelete-servlet")
public class QuestionDeleteServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WorkShowQuestion workShowQuestion = new WorkShowQuestion();
        workShowQuestion.Work();
        req.setAttribute("q",workShowQuestion.getQwe());
        req.getRequestDispatcher("QuestionDelete.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/QuestionDelete.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = new Integer(req.getParameter("id"));
        WorkDeleteQuestion workDeleteQuestion = new WorkDeleteQuestion();
        workDeleteQuestion.setId(id);
        workDeleteQuestion.work();
        doGet(req,resp);
    }

    @Override
    public void destroy() {
    }

}
