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
<p>������ �������������</p>
<p>${message}</p>
<div class="blocktext">
<form action="UserManager-servlet" method="post">
    <input id="login" name="login"><br/><br/>
    <button class="qwe">�������</button><br/><br/>
</form>
<form action="UserUpdate-servlet" method="post">
    <input id="login1" name="login1">
    <select name="select" required size="1">
        <option value="1">�����</option>
        <option value="2">������</option>
    </select>
    <input type="text" name="newlp"><br/><br/>
    <button class="qwe">��������</button><br/>
</form>
</div>
</body>
</html>