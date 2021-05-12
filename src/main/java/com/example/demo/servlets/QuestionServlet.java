package com.example.demo.servlets;

import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkFAQ;
import com.example.demo.work.WorkQuestion;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "QServlet", value = "/Q-servlet")
public class QuestionServlet extends HttpServlet {


    String tabl=" ";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("q",tabl);
        req.getRequestDispatcher("Questionbycategory.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/Questionbycategory.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = formatParams(req);
        WorkQuestion workQuestion = new WorkQuestion();
        int i = Integer.parseInt (params);
        workQuestion.setNum(i);
        workQuestion.work();
        tabl=workQuestion.getQ();
        System.out.println(workQuestion.getQ());
        doGet(req, resp);
    }

    private String formatParams(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String param = String.join(" and ", entry.getValue());

                    return param;
                })
                .collect(Collectors.joining(" "));
    }

    @Override
    public void destroy() {
    }

}
