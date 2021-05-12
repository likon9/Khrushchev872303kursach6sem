<%@ page import="com.example.demo.p1.Autorisation" %>
<%@ page pageEncoding="cp1251"%>
<!doctype html>
<html>
<head>
    <title>Web-приложение</title>
    <link rel="stylesheet" href="Styles/style7.css">
</head>
<body>
<div class="link1">
    <br/>
    <form action="Main.jsp" method="post">
        <button>Назад</button>
    </form>
</div>
<div class="form1">
<div class="blocktext">
    <a  href="/demo_war_exploded/FAQAaD-servlet">1)Список часто задаваемых вопроссов</a><br/><br/>
    <a href="/demo_war_exploded/FAQAdd-servlet">2)Добавить часто задаваемый вопрос</a><br/><br/>
    <a href="/demo_war_exploded/FAQR-servlet">3)Удалить часто задаваемый вопрос</a><br/><br/>
    <a href="/demo_war_exploded/QuestionDelete-servlet">4)Посмотреть и удалить вопрос</a><br/><br/>
    <a href="/demo_war_exploded/AddAnswer-servlet">5)Добавить ответ на вопрос вопрос</a><br/><br/>
    <a href="/demo_war_exploded/AddAdmin-servlet">6)Добавить администратора</a><br/><br/>
    <a href="/demo_war_exploded/ShowAdmin-servlet">7)Просмотреть список администраторов</a><br/><br/>
    <a href="/demo_war_exploded/UserManager-servlet">8)Управление пользолвательми</a><br/><br/>
</div>
</div>
</body>
</html>