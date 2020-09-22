package org.servlet;

import com.alibaba.fastjson.JSONObject;
import org.service.AddAssetService;
import org.service.impl.AddAssetServiceImpl;
import org.utils.JsonUtils;
import org.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addAsset.ajax")
public class AddAssetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId=request.getParameter("productId");
        String productName=request.getParameter("productName");
        String productModel=request.getParameter("productModel");
        String unit=request.getParameter("unit");
        String num=request.getParameter("num");
        String price=request.getParameter("price");
        String datetime=request.getParameter("datetime");

        int code = 0;
        if (!StringUtils.isAllNotEmpty(productId, productName,productModel,unit,num,price,datetime)) {
            code = -1;
        } else {
            AddAssetService as = new AddAssetServiceImpl();
            boolean flag = as.doAdd(productId, productName,productModel,unit,Integer.parseInt(num),Double.parseDouble(price),datetime);
            if (flag) {
                code = 0;
            } else {
                code = -2;
            }
        }
        JSONObject data = new JSONObject();
        data.put("code", code);
        JsonUtils.outJson(data, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
