<%@ page import="com.example.demo.p1.Autorisation" %>
<%@ page pageEncoding="cp1251"%>
<!doctype html>
<html>
<head>
    <title>123</title>
    <link rel="stylesheet" href="Styles/style5.css">
</head>
<body>
<div class="blocktext">

<form action="Admin-servlet" method="post">
    <h1>���� �� ����� ��������������</h1>
    <p>${Admin}</p>
    <input type="text" name="login" minlength="8" required pattern="[0-9A-Za-z]{8,24}" ><br/><br/>
    <input  type="password" name="password" minlength="8" required pattern="[0-9A-Za-z]{8,24}" ><br/><br/>
    <button>����</button> <a href="/demo_war_exploded/Main-servlet">�����</a><br/><br/>
</form>
</div>
</body>
</html>