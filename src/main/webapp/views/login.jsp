<%--
  Created by IntelliJ IDEA.
  User: mmdxiaoxin
  Date: 2023/11/10
  Time: 14:22
  登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        #loginbut {
            text-align: center;
        }

        #loginbut input {
            margin-right: 10px;
        }

        #message {
            display: block;
            margin-top: 10px;
            color: #d9534f;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/user-ctrl?action=login" method="post">
    <h2>用户登录</h2>
    <label for="username">登录名:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">登录密码:</label>
    <input type="password" id="password" name="password" required>

    <div id="loginbut">
        <input type="submit" value="登录">
        <input type="reset" value="取消">
    </div>
    <span id="message">${message}</span>
</form>
</body>
</html>


