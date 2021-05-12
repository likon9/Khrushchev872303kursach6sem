package com.example.demo.servlets;

import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkMark;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "MarkServlet", value = "/Mark-servlet")
public class MarkServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Mark.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = formatParams(req);
        WorkMark workMark = new WorkMark();
        workMark.setMark(Integer.parseInt(params));
        workMark.work();
        req.setAttribute("Mark","Отзыв отправлен" );
        req.getRequestDispatcher("/Mark.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/demo_war_exploded/Mark-servlet").forward(req, resp);
    }



    private String formatParams(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String param = String.join(" and ", entry.getValue());

                    return param ;
                })
                .collect(Collectors.joining(" "));
    }

    @Override
    public void destroy() {

    }
}
