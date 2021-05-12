package com.example.demo.servlets;

import com.example.demo.work.WorkAsk;
import com.example.demo.work.WorkDeleteUser;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUser-servlet")
public class DeleteUserServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = new String(req.getParameter("login").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        WorkDeleteUser workDeleteUser = new WorkDeleteUser();
        workDeleteUser.setLogin(login);
        workDeleteUser.work();
        getServletContext().getRequestDispatcher("/demo_war_exploded/UserManager-servlet").forward(req, resp);

    }


    @Override
    public void destroy() {

    }
}