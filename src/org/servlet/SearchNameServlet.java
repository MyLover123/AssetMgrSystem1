package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.SearchNameService;
import org.service.impl.SearchNameServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/searchName.ajax")
public class SearchNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account=request.getParameter("account");
        SearchNameService ss=new SearchNameServiceImpl();
        String name =ss.getName(account);

        JSONObject data = new JSONObject();
        data.put("name", name);
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
