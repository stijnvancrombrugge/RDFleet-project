<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SVCAX33
  Date: 28/10/2015
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <form name="form" th:th:action="@{/login}" method="POST">
        <table>
            <tr>
                <td>User:</td>
                <td><input type="text" name="username" value=""/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <input id="remember_me" name="remember-me" type="checkbox"/>
                <label for="remember_me" style="display: inline">Remember me</label>
            </tr>
            <tr>
                <td colspan="2">
                    <input name="submit" type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
