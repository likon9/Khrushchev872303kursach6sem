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
    <form action="MenuUser.jsp" method="post">
        <button>�����</button>
    </form>
</div>
<p>�������� ���������</p>


<form action="Q-servlet" method="post">
    <div class="blocktext">
<select class="asd" name="age" required size="1">
    <option value="1">������ � ��������� � ������������� ��������</option>
    <option value="2">������ � ������ � ������������� �������������</option>
    <option value="3">������������</option>
    <option value="4">���������� �������������</option>
    <option value="5">������������� ������</option><br/>
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
