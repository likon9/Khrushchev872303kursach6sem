<%@ page import="com.example.demo.p1.Autorisation" %>
<%@ page pageEncoding="cp1251"%>
<!doctype html>
<html>
<head>
    <title>Web-����������</title>
    <link rel="stylesheet" href="Styles/style4.css">
</head>
<body>
<div class="link1">
    <br/>
    <form action="MenuAdmin.jsp" method="post">
        <button>�����</button>
    </form>
</div>
<br/>
<div class="blocktext">
    <p>${q}</p>
    <p>������� id ��� �������</p>
    <form action="QuestionDelete-servlet" method="post">
        <input type="textarea" name="text" pattern="[0-9]{1,10}">
        <br/>
        <br/>

        <button class="qwe">�������</button>
    </form>
</div>
</body>
</html>
