<%--
  Created by IntelliJ IDEA.
  User: mmdxiaoxin
  Date: 2023/11/15
  Time: 14:21
  用于添加图书信息的页面
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加图书</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 20px;
        }

        form {
            max-width: 600px;
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

        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/book-ctrl?action=save" method="post">
    <h2>添加图书</h2>
    <label for="bookName">书名：</label>
    <input type="text" id="bookName" name="bookName" required>

    <label for="author">作者：</label>
    <input type="text" id="author" name="author" required>

    <label for="press">出版社：</label>
    <input type="text" id="press" name="press" required>

    <label for="pressDate">出版日期：</label>
    <input type="date" id="pressDate" name="pressDate" required>

    <label for="price">价格：</label>
    <input type="number" id="price" name="price" required>


    <button type="submit">添加图书</button>
</form>
</body>
</html>
