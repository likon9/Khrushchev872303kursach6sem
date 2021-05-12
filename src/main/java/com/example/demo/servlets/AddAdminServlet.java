package com.example.demo.servlets;

import com.example.demo.work.WorkAddAdmin;
import com.example.demo.work.WorkAutorizationAdmin;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet(name = "AddAdminServlet", value = "/AddAdmin-servlet")
public class AddAdminServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/AddAdmin.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = formatParams(req);
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = params.split(delimeter);

        WorkAddAdmin workAddAdmin =new WorkAddAdmin();
        workAddAdmin.setLogin(subStr[0]);
        workAddAdmin.setPassword(subStr[1]);
        workAddAdmin.enter();
        if(workAddAdmin.t==1)
        {
            req.setAttribute("message","Данный логин уже используется" );
            req.getRequestDispatcher("/AddAdmin.jsp").forward(req,resp);
            getServletContext().getRequestDispatcher("/Registration.jsp").forward(req, resp);
        }
        else {

            req.setAttribute("message","Новый администратор успешно создан" );
            req.getRequestDispatcher("/AddAdmin.jsp").forward(req,resp);
            getServletContext().getRequestDispatcher("/demo_war_exploded/Main-servlet").forward(req, resp);
        }

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