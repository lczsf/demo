/**
 * Created by wb-lichao.x on 2016/5/27.
 */
$(document).ready(function () {
    var dekota = {
        init: function () {
            $("a#loginOn").click(dekota.loginOn);
        },
        loginOn: function () {
            $.post("loginOn", {name: $("input#name").val(), password: $("input#password").val()},
                function (data) {
                    alert(data);
                    $("body#all").html(data);
                });
        }
    }
    window.dekota = (window.dekota) ? window.dekota : dekota;
    $(function () {
        dekota.init();
    });
});