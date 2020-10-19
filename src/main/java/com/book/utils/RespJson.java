package com.book.utils;



import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RespJson {
    public static void RespJson(HttpServletResponse response,Object obj) {
        if (obj != null) {
            String jsonString = JSONObject.toJSONString(obj);
            try {
                response.getWriter().println(jsonString);
            } catch (IOException e) {
                try {
                    response.getWriter().println("接收数据失败");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
        }
        System.out.println("数据格式存在问题");
    }
}
