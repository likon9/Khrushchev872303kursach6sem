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
    <form action="MenuAdmin.jsp" method="post">
        <button>Назад</button>
    </form>
</div>
<br/>
<div class="blocktext">
    <p>${q}</p>
    <p>Введите id для уаления</p>
    <form action="QuestionDelete-servlet" method="post">
        <input type="textarea" name="text" pattern="[0-9]{1,10}">
        <br/>
        <br/>

        <button class="qwe">удалить</button>
    </form>
</div>
</body>
</html>
