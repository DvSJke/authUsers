<%--
  Created by IntelliJ IDEA.
  User: DvS
  Date: 23.09.2017
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
  <head>
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
         <title>AuthPage</title>
         <link rel="stylesheet" type="text/css" href="modal-contact-form.css" />
  </head>
<!--  <body>
      <form action="LoginServlet" method="POST">
          <label>Username: </label>
          <input type="text" name="username" value=""/>
          <br />
          <label>Password: </label>
          <input type="password" name="password" value=""/>
          <br />
          <input type="submit" name="enter"/>
      </form>
        <a href="index.html">LINK HERE!</a>
  </body> -->

  <body>
  <h1 class="">MidgetLab Corporation ®</h1>
  <a class="show-btn" href = "javascript:void(0)" onclick = "document.getElementById('envelope').style.display='block';document.getElementById('fade').style.display='block'">Войти</a>
  <div id="envelope" class="envelope">
      <a class="close-btn" title="Закрыть" href="javascript:void(0)" onclick = "document.getElementById('envelope').style.display='none';document.getElementById('fade').style.display='none'"></a>
      <div class="title">Авторизация:</div>
      <form method="POST" action="LoginServlet">
          <div class="logText">Логин:<span>Логин может состоять только<br />из цифр и латинских букв!</span></div>
          <input type="text" name="username" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Логин':this.value;" value="* Логин" class="login" required />
          <div class="checkText">${status}</div>
          <div class="passText">Пароль:</div>
          <input type="password" name="password" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Пароль':this.value;" value="* Пароль" class="password" required />
          <input type="submit" name="enter" value="Войти" class="enter">
      </form>
  </div>
  <div id="fade" class="black-overlay"></div>
  </body>
</html>
