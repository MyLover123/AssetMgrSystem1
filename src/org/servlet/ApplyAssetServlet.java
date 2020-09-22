package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.ApplyAssetService;
import org.service.impl.ApplyAssetServiceImpl;
import org.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/doApply.ajax")
public class ApplyAssetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String assetId = request.getParameter("assetId");
        String account = request.getParameter("account");
        int code = -1;

        ApplyAssetService as = new ApplyAssetServiceImpl();
        boolean apply = as.doApply(Integer.parseInt(assetId),account);
        if (apply) {
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
