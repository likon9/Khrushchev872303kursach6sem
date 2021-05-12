
<%@ page import="com.example.demo.p1.Autorisation" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>Web-приложение</title>
    <link rel="stylesheet" href="Styles/style1.css">
</head>
<body>
<div class="link1">
    <br/>
<a href="/demo_war_exploded/Admin-servlet">Администрирование</a> <br/>
</div>
<div class="blocktext">
<form name="form" action="Main-servlet" method="post">
    <h1>Вход</h1>
    <p>${Main}</p>
    <input type="text" name="login" minlength="8" required pattern="[0-9A-Za-z]{8,24}" ><br/><br/>
    <input  type="password" name="password" minlength="8" required pattern="[0-9A-Za-z]{8,24}" ><br/><br/>
    <button>enter</button> <a href="/demo_war_exploded/Reg-servlet">Регистрация</a><br/><br/>
</form>
</div>

</body>
</html>