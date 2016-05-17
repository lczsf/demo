/**
 * Created by wb-lichao.x on 2016/5/13.
 */
$(document).ready(function () {
    var dekota = {
        url: '',
        init: function () {
            $("#btnList").click(dekota.listUser);
        },
        listUser: function () {
            //var data = {address: {id: 1, content: 5}};
            var age=$("input#age").val().trim();
            var data = {"age":"1","page":{"pageNum": "1", "pageSize": "5"}};
            //data = ;
            $.ajax({
                url: 'queryPage',
                type: 'POST',//注意在传参数时，加：_method:'PATCH'　将对应后台的PATCH请求方法
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(data),
                success: function (data) {
                    var body = $('table#info');
                    data = data.result;
                    if (data != null) {
                        body.append("<thead><tr><th>id</th><th>name</th><th>age</th></tr></thead>");//表格头
                        body.append("<tbody>");//表内容
                        $.each(data, function (index, item) {
                            OutputData(body, item);
                        })
                        body.append("</tbody>");//表内容
                    }
                },
                error: function (msg) {
                    alert(msg);
                }
            });
        }
    };

    window.dekota = (window.dekota) ? window.dekota : dekota;
    $(function () {
        dekota.init();
        dekota.listUser();
    });
});

function OutputData(body, item) {
    var trs = "";
    trs += "<tr>" +
        "<td>" + item.id + "</td>" +
        "<td>" + item.name + "</td>" +
        "<td>" + item.age + "</td>" +
        "</tr>";
    body.append(trs);
};