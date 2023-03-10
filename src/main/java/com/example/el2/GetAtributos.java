package com.example.el2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetAtributos", value = "/GetAtributos")
public class GetAtributos extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get application scoped attribute
        String applicationScope = (String)request.getServletContext().getAttribute("email");

        // get session scoped attribute
        HttpSession session = request.getSession();
        String sessionScope = (String)session.getAttribute("usuario");

        // get request scoped attribute
        String requestScope = (String)request.getAttribute("producto");

        // print response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<html><body>");
        out.write("<h2>Servlet attributes example: applicationScope, sessionScope and requestScope</h2>");
        out.write("<p>applicationScope: " + applicationScope + "</p>");
        out.write("<p>sessionScope: " + sessionScope + "</p>");
        out.write("<p>requestScope: " + requestScope + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
