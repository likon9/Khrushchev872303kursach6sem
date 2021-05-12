package com.example.demo.servlets;

import com.example.demo.p1.Autorisation;
import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkPA;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PAServlet", value = "/PA-servlet")
public class PersonalAreaServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WorkPA workPA = new WorkPA();
        req.setAttribute("inf",workPA.q );
        req.getRequestDispatcher("PersonalArea.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/PersonalArea.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
    }
}
