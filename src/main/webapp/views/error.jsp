<%--
  Created by IntelliJ IDEA.
  User: mmdxiaoxin
  Date: 2023/11/10
  Time: 14:22
  显示错误信息的页面
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>错误页面</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
        }

        h1 {
            color: #d9534f;
        }

        p {
            margin-bottom: 20px;
        }

        .back-link {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>抱歉，出现了错误！</h1>
    <jsp:useBean id="msg" scope="request" type="java.lang.String"/>
    <p>错误原因：${msg}</p>
    <p><a href="#" class="back-link">返回</a></p>
</div>
</body>
</html>

