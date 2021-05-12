<%@ page import="com.example.demo.p1.Autorisation" %>
<%@ page pageEncoding="cp1251"%>
<!doctype html>
<html>
<head>
    <title>Web-приложение</title>
    <link rel="stylesheet" href="Styles/style4.css">
</head>
<body>
<div class="link1">
    <br/>
    <form action="MenuUser.jsp" method="post">
        <button>Назад</button>
    </form>
</div>

<p>Введите новый пароль</p>
<p>${message}</p>
<form action="NewPass-servlet" method="post">
    <div class="blocktext">
    <input type="password" name="password" minlength="8" required pattern="[0-9A-Za-z]{8,24}"><br/><br/>
    </div>
    <button class="qwe">enter</button>
</form>
</body>
</html>