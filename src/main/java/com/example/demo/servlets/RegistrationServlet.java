package com.example.demo.servlets;

import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkRegistration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "RegServlet", value = "/Reg-servlet")
public class RegistrationServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Registration.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = formatParams(req);
        String[] subStr;
        String delimeter = " "; // Разделитель
        subStr = params.split(delimeter);
        WorkRegistration workRegistration = new WorkRegistration();
        workRegistration.setLogin(subStr[0]);
        workRegistration.setPassword(subStr[1]);
        workRegistration.enter();
        if(workRegistration.t==1)
        {
            req.setAttribute("Main","!Данный логин уже используется!" );
            req.getRequestDispatcher("/Registration.jsp").forward(req,resp);
            getServletContext().getRequestDispatcher("/Registration.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("Main","!Пользователь успешно создан!<br/>Воспользуйтесь данными длоя входа<br/>" );
            req.getRequestDispatcher("/Main.jsp").forward(req,resp);
            getServletContext().getRequestDispatcher("/Main.jsp").forward(req, resp);}

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
