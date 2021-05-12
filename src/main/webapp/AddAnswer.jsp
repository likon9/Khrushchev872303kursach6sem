<%@ page import="com.example.demo.p1.Autorisation" %>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <title>Web-приложение</title>
    <link rel="stylesheet" href="Styles/style4.css">
</head>
<body>
<div class="link1">
    <br/>
    <form action="MenuAdmin.jsp" method="post">
        <button>Назад</button>
    </form>
</div>
<br/>
<h>${q}</h><br/>
<p>Введите id вопроса и ответ</p>
<form action="AddAnswer-servlet" method="post">
    <div class="blocktext">

    <input type="text" name="id" pattern="[0-9]{1,10}"  ><br/>
        <br/>

    <textarea id="textarea" name="answerr" minlength="8" required pattern="[0-9A-Za-zА-Яа-я]{8,24}"></textarea><br/>
        <br/>

    <button class="qwe">Ответить</button><br/>

    </div>
</form>


</body>
</html>
