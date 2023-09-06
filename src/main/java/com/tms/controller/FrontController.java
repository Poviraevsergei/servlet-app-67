package com.tms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/*")
public class FrontController extends HttpServlet {
    private final PersonController pc = new PersonController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspPage = dispatcher(req, resp, "GET");
        if(!jspPage.equals("/")){
            getServletContext().getRequestDispatcher(jspPage).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jspPage = dispatcher(req, resp, "POST");
        getServletContext().getRequestDispatcher(jspPage).forward(req, resp);
    }

    private String dispatcher(HttpServletRequest request, HttpServletResponse resp, String httpMethod) {
        String httpPath = request.getRequestURI();

        if ("GET".equals(httpMethod)) {
            return switch (httpPath) {
                case "/user" -> pc.getAll(request);
                case "/user-by-id" -> pc.getById(request);
                default -> "/";
            };
        }

        if ("POST".equals(httpMethod)) {
            return switch (httpPath) {
                case "/front/delete-user" -> pc.deleteUser(request);
                case "/front/update-user" -> pc.updateUser(request);
                case "/front/create-user" -> pc.createUser(request);
                default -> "/index.jsp";
            };
        }
        return "/index.jsp";
    }
}
