package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.ReturnAssetService;
import org.service.impl.ReturnAssetServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/doReturn.ajax")
public class ReturnAssetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("assetId");
        int code = -1;

        ReturnAssetService rs = new ReturnAssetServiceImpl();
        boolean flag = rs.doReturn(Integer.parseInt(id));
        if (flag) {
            code = 0;
        } else {
            code = -2;
        }

        JSONObject data = new JSONObject();
        data.put("code", code);
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
