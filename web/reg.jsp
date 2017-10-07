<%--
  Created by IntelliJ IDEA.
  User: DvS
  Date: 26.09.2017
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    <%--<script type="text/javascript" src="js/custom-js.js"></script>--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#username").blur(function () {
                $("#msgbox").text('Проверка...').fadeIn("slow");
                var username = $("#username").val();
//Проверить существует ли имя
                $.ajax({
                    type: "POST",
                    url: "FormChecker",
                    data: {username : username},
                    success: function(data) {
                        if(data === "0") //если имя не доступно
                        {
                            $("#msgbox").fadeTo(200,0.1,function() //начнет появляться сообщение
                            {
                                $("#msgbox").html("Логин может содержать только буквы и цифры").fadeTo(900,1);
                            });
                        }
                        else
                        {
                            $("#msgbox").fadeTo(200,0.1,function()
                            {
                                $("#msgbox").html('Логин введён корректно!').fadeTo(900,1);
                            });
                        }
                    }

                });
            });
        });

    </script>
</head>
<body>
<div class="title">Авторизация:</div>
<form method="POST" action="Registration">
    <div class="logText">Логин:</div>
    <input type="text" name="username" id="username" class="login"/>${status}<span id="msgbox" style="display:none"></span>
    <div class="passText">Пароль:</div>
    <input type="password" name="password" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Пароль':this.value;" value="* Пароль" class="password" required />
    <div class="passText">Имя:</div>
    <input type="text" name="firstname" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Пароль':this.value;" value="* Пароль" class="password" required />
    <div class="passText">Фамилия:</div>
    <input type="text" name="secondname" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Пароль':this.value;" value="* Пароль" class="password" required />
    <div class="passText">Возраст:</div>
    <input type="text" name="age" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Пароль':this.value;" value="* Пароль" class="password" required />

    <input type="submit" name="enter" value="Отправить" class="enter">
</form>
</body>
</html>
