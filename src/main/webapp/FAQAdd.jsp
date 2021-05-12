
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
<p>Добавьте часто задаваемый вопросс</p>
<p>${message}</p>
<div class="blocktext">
<form action="FAQAdd-servlet" method="post">
    <p>Вопрос:</p><textarea type="textarea" name="question" minlength="8" required pattern="[0-9A-Za-zА-Яа-я]{8,24}" ></textarea><br/>
        <p>Ответ:</p> <textarea  type="textarea" name="answer" minlength="8" required pattern="[0-9A-Za-zА-Яа-я]{8,24}"></textarea><br/>
    <button class="qwe">Добавить</button>
</form>
</div>
</body>
</html>