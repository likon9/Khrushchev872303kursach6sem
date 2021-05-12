package com.example.demo.servlets;


import com.example.demo.work.WorkAutorisastion;
import com.example.demo.work.WorkFAQ;
import com.example.demo.work.WorkFAQR;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "FAQRServlet", value = "/FAQR-servlet")
public class FAQRemoveServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WorkFAQ workFAQ = new WorkFAQ();
        req.setAttribute("faq",workFAQ.getFaq() );
        req.getRequestDispatcher("FAQRemove.jsp").forward(req,resp);
        getServletContext().getRequestDispatcher("/FAQRemove.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = formatParams(req);
        WorkFAQR workFAQR = new WorkFAQR();
        workFAQR.setId(Integer.parseInt(params));
        workFAQR.work();
        doGet(req,resp );

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