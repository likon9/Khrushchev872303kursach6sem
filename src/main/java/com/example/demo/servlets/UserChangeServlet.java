package com.example.demo.servlets;

import com.example.demo.work.WorkDeleteUser;
import com.example.demo.work.WorkUserManager;
import com.example.demo.work.WorkUserUpdate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "UserUpdateServlet", value = "/UserUpdate-servlet")
public class UserChangeServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WorkUserManager workUserManager = new WorkUserManager();
        req.setAttribute("message",workUserManager.getFaq() );
        req.getRequestDispatcher("UserManager.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/UserManager.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login1 = new String(req.getParameter("login1").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String cat = new String(req.getParameter("select").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String newlp = new String(req.getParameter("newlp").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int category = Integer.parseInt(cat);
        WorkUserUpdate workUserUpdate = new WorkUserUpdate();
        workUserUpdate.setLogin(login1);
        workUserUpdate.setCat(category);
        workUserUpdate.setNewlp(newlp);
        workUserUpdate.work();
        doGet(req,resp);

    }

    @Override
    public void destroy() {

    }
}
