package com.zzy.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UtilController {

    @RequestMapping(value = "/sysNowTime")
    public void sysNowTime(HttpServletResponse response, HttpServletRequest request){
        String nowTime = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        nowTime = sdf.format(date);
        //request.setAttribute("result",NowTime);
        JSONObject json = new JSONObject();
        json.put("nowTime", nowTime);
        json.put("longTime",System.currentTimeMillis());
        try {
            response.getWriter().print("sysNowTime("+json.toString()+")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *

     int num = 1;
     JSONObject json = new JSONObject();
     json.put("num", num);
     try {
     rps.getWriter().print("successCallbackEmpWorksNum("+json.toString()+")");
     } catch (IOException e) {
     e.printStackTrace();
     }




     ajax 调用 示例：
     $.ajax({
     type: "GET",
     async: false,
     dataType: "jsonp",
     url: "http://192.168.1.163:8080/jflow-web/empWorksNum",
     jsonp: 'callback',
     jsonpCallback: "successCallback",//要和 本类中的 返回callback 一样
     contentType: "application/json;charset=utf-8;",
     success: function(data) {
     console.log(data);
     },
     error: function(data) {
     console.log(data);
     }
     });

     */
}
