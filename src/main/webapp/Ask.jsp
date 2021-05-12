<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
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
<p>Задайте вопрос</p>
<p>${message}</p>
<form action="Ask-servlet" method="post">
    <div class="blocktext">
    <select class="asd" name="age" required size="1">
        <p>qwrew</p>
        <option value="1">Помощь в установке и использовании программ</option>
        <option value="2">Помощь в выборе и использовании комплектующих</option>
        <option value="3">Обслуживание</option>
        <option value="4">Обновление комплектующих</option>
        <option value="5">Сопутствующие товары</option><br/>
    </select>
        <br/><br/> <textarea id="textarea" name="textarea" minlength="8" required pattern="[0-9A-Za-zА-Яа-я]{8,24}"></textarea>
    </div>
    <button class="qwe">Отправить</button>
</form>
</body>
</html>