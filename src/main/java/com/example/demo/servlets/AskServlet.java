package com.example.demo.servlets;

import com.example.demo.work.WorkAsk;
import com.example.demo.work.WorkAutorisastion;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet(name = "Ask-Servlet", value = "/Ask-servlet")
public class AskServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Ask.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login1 = new String(req.getParameter("age").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String login = new String(req.getParameter("textarea").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        WorkAsk workAsk = new WorkAsk();
        workAsk.setCat(Integer.parseInt(login1));
        workAsk.setQuestion(login);
        workAsk.work();
        req.setAttribute("message","Вопрос задан, вы можете посмотреть его в личном кабинете" );
        req.getRequestDispatcher("/Ask.jsp").forward(req,resp);

    getServletContext().getRequestDispatcher("/demo_war_exploded/Ask-servlet").forward(req, resp);
    }


    @Override
    public void destroy() {

    }
}
