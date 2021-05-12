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
<p>Выберите категорию</p>


<form action="Q-servlet" method="post">
    <div class="blocktext">
<select class="asd" name="age" required size="1">
    <option value="1">Помощь в установке и использовании программ</option>
    <option value="2">Помощь в выборе и использовании комплектующих</option>
    <option value="3">Обслуживание</option>
    <option value="4">Обновление комплектующих</option>
    <option value="5">Сопутствующие товары</option><br/>
</select>
        <br/>
        <br/> <button class="qwe">enter</button> </a>
</div>


</form>

<br/>
<br/>
<h>${q}</h>
</body>
</html>
