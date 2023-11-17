<%--
  Created by IntelliJ IDEA.
  User: mmdxiaoxin
  Date: 2023/11/10
  Time: 14:22
  显示图书列表的页面
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书信息详细列表</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #495057;
            margin: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #ffe8cc;
            font-size: 24px; /* 放大字体 */
            text-align: center; /* 居中文本 */
        }

        tr:nth-child(even) {
            background-color: #DDA0DD;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th colspan="8">图书信息详细列表</th>
    </tr>
    <tr>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>出版日期</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <jsp:useBean id="result" scope="request" type="java.util.List"/>
    <c:forEach items="${result}" var="book" varStatus="stat">
        <tr ${stat.index%2==0 ? 'class="even"' : ''}>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>
                <fmt:formatDate value="${book.pressDate}" pattern="yyyy-MM-dd" />
            </td>
            <td>${book.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/book-ctrl?action=edit&id=${book.id}">修改</a>
                <a href="${pageContext.request.contextPath}/book-ctrl?action=delete&id=${book.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8">
            <a href="${pageContext.request.contextPath}/book-ctrl?action=add">添加图书</a>
        </td>
    </tr>
</table>
</body>
</html>
