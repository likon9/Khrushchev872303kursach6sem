package com.example.demo.servlets;

import com.example.demo.p1.Autorisation;
import com.example.demo.work.WorkAutorisastion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@WebServlet(name = "MainServlet", value = "/Main-servlet")
public class MainServlet extends HttpServlet {




    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Main.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String params = formatParams(req);

        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = params.split(delimeter);


        WorkAutorisastion workAutorisastion = new WorkAutorisastion();

        workAutorisastion.setLogin(subStr[0]);
        workAutorisastion.setPassword(subStr[1]);
        workAutorisastion.enter();
        if(workAutorisastion.t==1)
        {
            getServletContext().getRequestDispatcher("/MenuUser.jsp").forward(req, resp);
        }
        else {

            {
                req.setAttribute("Main","Неверный логин и/или пароль" );
                req.getRequestDispatcher("/Main.jsp").forward(req,resp);
            }
            getServletContext().getRequestDispatcher("/demo_war_exploded/Main-servlet").forward(req, resp);}

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

     void include(HttpServletRequest request, HttpServletResponse response, String jspPath) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}
