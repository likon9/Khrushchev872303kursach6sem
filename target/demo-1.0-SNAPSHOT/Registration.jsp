<%@ page pageEncoding="cp1251"%>
<!doctype html>
<html>
<head>
    <title>Web-приложение</title>
    <link rel="stylesheet" href="Styles/style1.css">
</head>
<body>
<div class="blocktext">
    <form name="form" action="Reg-servlet" method="post">
<h1>Регистрация</h1>
<p>${Main}</p>
    <input type="text" name="login" minlength="8" required pattern="[0-9A-Za-z]{8,24}"><br/><br/>
    <input type="password" name="password" minlength="8" required pattern="[0-9A-Za-z]{8,24}"><br/><br/>
    <button>enter</button> <a href="/demo_war_exploded/Main-servlet">back</a><br/><br/>
</form>
</div>
</body>
</html>