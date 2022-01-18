package com.lisery.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //路径
        String realPath = "D:\\PROGRAM\\javaWeb\\response\\src\\main\\resources\\1.jpeg";
        System.out.println("download path: " + realPath);
        //文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //设置响应头(格式)
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        //文件输入流到响应resp的输出流
        FileInputStream in = new FileInputStream(realPath);
        byte[] buffer = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        int len = 0;
        while ((len = in.read(buffer)) > 0)
            out.write(buffer, 0, len);

        in.close();
        out.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
