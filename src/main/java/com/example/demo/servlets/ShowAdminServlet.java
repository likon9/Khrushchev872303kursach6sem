package com.example.demo.servlets;

import com.example.demo.work.WorkFAQ;
import com.example.demo.work.WorkShowAdmins;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowAdminServlet", value = "/ShowAdmin-servlet")
public class ShowAdminServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WorkShowAdmins workShowAdmins = new WorkShowAdmins();
        req.setAttribute("admins",workShowAdmins.admins );
        req.getRequestDispatcher("ShowAdmin.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/ShowAdmin.jsp").forward(req, resp);

    }



    @Override
    public void destroy() {
    }
}