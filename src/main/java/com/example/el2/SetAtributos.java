package com.example.el2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SetAtributos", value = "/SetAtributos")
public class SetAtributos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// set application scoped attribute
        request.getServletContext().setAttribute("email", "email@gmail.com");

        // set session scoped attribute
        HttpSession session = request.getSession();
        session.setAttribute("usuario", "supervisor");

        // set request scoped attribute
        request.setAttribute("producto", "Portatil Dell");


        // Recibimos el parametro de accion, para ver que solicito el cliente.
        String action = request.getParameter("action");
        if ("reenviar".equals(action)) {
            RequestDispatcher rd;
            // Reenviamos la respuesta a la vista Menu.jsp
            rd = request.getRequestDispatcher("/menu.jsp");
            rd.forward(request, response);
        }else{
            // send redirect to other servlet
            request.getRequestDispatcher("GetAtributos").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
