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
<div class="blocktext">
<p>${faq}</p>
<p>Введите id для уаления</p>
<form action="FAQR-servlet" method="post">
    <input type="textarea" name="text" pattern="[0-9]{1,10}">
    <br/>
    <br/>

    <button class="qwe">удалить</button>
</form>
</div>

</body>
</html>