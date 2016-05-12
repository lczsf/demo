/**
 * Created by wb-lichao.x on 2016/5/11.
 */
$(document).ready(function () {
    var dekota = {

        url: '',

        init: function () {
            dekota.url = '<%=basePath%>';
            //$.UIkit.notify("页面初始化完成", {status:'info',timeout:500});
            // $("#btnGet").click(dekota.getPerson);
            // $("#btnAdd").click(dekota.addPerson);
            // $("#btnDel").click(dekota.delPerson);
            // $("#btnUpdate").click(dekota.updatePerson);
            $("#btnList").click(dekota.listPerson);
        },
        getPerson: function () {
            $.ajax({
                url: dekota.url + 'person/101/',
                type: 'GET',
                dataType: 'json'
            }).done(function (data, status, xhr) {
                $.UIkit.notify("获取人员信息成功", {status: 'success', timeout: 1000});
            }).fail(function (xhr, status, error) {
                $.UIkit.notify("请求失败！", {status: 'danger', timeout: 2000});
            });
        },
        addPerson: function () {
            $.ajax({
                url: dekota.url + 'person',
                type: 'POST',
                dataType: 'json',
                data: {id: 1, name: '张三', sex: '男', age: 23}
            }).done(function (data, status, xhr) {
                $.UIkit.notify(data.msg, {status: 'success', timeout: 1000});
            }).fail(function (xhr, status, error) {
                $.UIkit.notify("请求失败！", {status: 'danger', timeout: 2000});
            });
        },
        delPerson: function () {
            $.ajax({
                url: dekota.url + 'person/109',
                type: 'DELETE',
                dataType: 'json'
            }).done(function (data, status, xhr) {
                $.UIkit.notify(data.msg, {status: 'success', timeout: 1000});
            }).fail(function (xhr, status, error) {
                $.UIkit.notify("请求失败！", {status: 'danger', timeout: 2000});
            });
        },
        updatePerson: function () {
            $.ajax({
                url: dekota.url + 'person',
                type: 'POST',//注意在传参数时，加：_method:'PUT'　将对应后台的PUT请求方法
                dataType: 'json',
                data: {_method: 'PUT', id: 221, name: '王五', sex: '男', age: 23}
            }).done(function (data, status, xhr) {
                $.UIkit.notify(data.msg, {status: 'success', timeout: 1000});
            }).fail(function (xhr, status, error) {
                $.UIkit.notify("请求失败！", {status: 'danger', timeout: 2000});
            });
        },
        listPerson: function () {

            $.ajax({
                url: 'address/list',
                type: 'POST',//注意在传参数时，加：_method:'PATCH'　将对应后台的PATCH请求方法
                dataType: 'json',
                data: {_method: 'PATCH', content: '张三'},
                success: function (data) {
                    var body = $('table#info');
                    if (data != null) {
                        body.append("<caption>caption_info</caption>");//表格标题
                        body.append("<thead><tr><th>id</th><th>content</th></tr></thead>");//表格头
                        body.append("<tbody>");//表内容
                        $.each(data, function (index, item) {
                            OutputData(body, item);
                        })
                        body.append("</tbody>");//表内容
                        body.append("<tfoot><tr><td>table_foot</td></tr></tfoot>");//表尾部
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
    });
});

function OutputData(body, item) {
    var trs = "";
    trs += "<tr><td>" + item.address.id + "</td><td>" + item.address.content + "</td></tr>";
    body.append(trs);
};