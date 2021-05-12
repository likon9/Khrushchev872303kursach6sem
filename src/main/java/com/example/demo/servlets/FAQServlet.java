package com.example.demo.servlets;

import com.example.demo.work.WorkFAQ;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FAQServlet", value = "/FAQ-servlet")
public class FAQServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WorkFAQ workFAQ = new WorkFAQ();
        req.setAttribute("faq",workFAQ.getFaq() );
        req.getRequestDispatcher("FAQ.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/FAQ.jsp").forward(req, resp);

    }



    @Override
    public void destroy() {
    }
}
