<%@ page import="com.example.demo.p1.Autorisation" %>

<%@ page pageEncoding="cp1251"%>
<!doctype html>
<html>
<head>
    <title>123</title>
    <META http-equiv="content-type" content="text/html; charset=windows-1251">
    <link rel="stylesheet" href="Styles/style4.css">
</head>
<body>
<div class="link1">
    <br/>
    <form action="MenuUser.jsp" method="post">
        <button>Назад</button>
    </form>
    </div>
<p>Оцените</p>
<p>${Mark}</p>
<form action="Mark-servlet" method="post">
    <div class="blocktext">
    <select name="age" required size="1">
        <option value="5">5</option>
        <option value="4">4</option>
        <option value="3">3</option>
        <option value="2">2</option>
        <option value="1">1</option><br/>
    </select>
    </div>
  <br/> <button class="qwe">отправить</button></br>
</form>
<h1>${q}</h1>
</body>
</html>
