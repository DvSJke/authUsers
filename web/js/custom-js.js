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
