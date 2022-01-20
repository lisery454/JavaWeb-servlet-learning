package com.lisery;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-16");
        resp.setCharacterEncoding("utf-16");

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("lastLoginTime")) {
                    Date date = new Date(Long.parseLong(cookies[i].getValue()));
                    resp.getWriter().println("你之前访问的时间是：");
                    resp.getWriter().println(date.toString());
                }
            }
        } else {
            resp.getWriter().println("这是你第一次访问");
        }
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
