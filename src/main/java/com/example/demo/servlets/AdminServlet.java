package com.example.demo.servlets;

import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkAutorizationAdmin;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet(name = "AdminServlet", value = "/Admin-servlet")
public class AdminServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Admin.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = formatParams(req);
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = params.split(delimeter);

        WorkAutorizationAdmin workAutorizationAdmin = new WorkAutorizationAdmin();


        workAutorizationAdmin.setLogin(subStr[0]);
        workAutorizationAdmin.setPassword(subStr[1]);
        workAutorizationAdmin.enter();
        if(workAutorizationAdmin.t==1)
        {
            getServletContext().getRequestDispatcher("/MenuAdmin.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("Admin","Неверный логин и/или пароль" );
            req.getRequestDispatcher("/Admin.jsp").forward(req,resp);
            getServletContext().getRequestDispatcher("/Admin.jsp").forward(req, resp);}

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