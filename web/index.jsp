
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我是标题</title>
    <script src="resources/js/jquery-1.11.1.min.js"></script>
    <script>

        getSysNowTime();

        function dateFormatLong(longTypeDate){
            var dateType = "";
            var date = new Date();
            date.setTime(longTypeDate);
            dateType += date.getFullYear();   //年
            dateType += "-" + formatZero((date.getMonth() + 1 )); //月
            dateType += "-" + formatZero(date.getDate());   //日
            dateType += " " ;   //空格
            dateType += formatZero(date.getHours()) ;   //时
            dateType += ":" + formatZero(date.getMinutes());   //分
            dateType += ":" + formatZero(date.getSeconds());   //秒
            return dateType;
        }
        function formatZero(fvalue) {
            if (fvalue >= 0 && fvalue <= 9) {
                fvalue = "0" + fvalue;
            }
            return fvalue;
        }

        function getSysNowTime() {
          $.ajax({
              type: "GET",
              async: false,
              dataType: "jsonp",
              url: "http://192.168.1.163:8888/sysNowTime",
              jsonp: 'callback',
              jsonpCallback: "sysNowTime",//要和 本类中的 返回callback 一样
              contentType: "application/json;charset=utf-8;",
              success: function(data) {
                  console.log("从系统中获取的格式化时间为： " + data.nowTime);
                  var longTime = data.longTime;
                  console.log("从系统中获取的long时间为： " + longTime);
                  var time2 = dateFormatLong(longTime );
                  console.log("js转化的时间为： " + time2);
                  var currentDateLong = new Date(time2.replace(new RegExp("-","gm"),"/")).getTime()
                  console.log("js转化的long时间为： " + currentDateLong);
                  var time3 = dateFormatLong(longTime + 3600000);
                  console.log("js 加上 一个小时的时间为： " + time3);
              },
              error: function(data) {
                  console.log(data);
              }
          });
      }
    </script>

  </head>
  <body>

  内容 啊 内容

  </body>
</html>
