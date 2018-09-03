<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    /*设置时间的日期格式*/
    $.fn.datebox.defaults.formatter = function(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'/'+m+'/'+d;
    }
    $(function () {
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "全部导入",
            handler: function () {
                $("#dd").dialog('open');
                $("#ff").form({
                    url:"${pageContext.request.contextPath}/User/iopImportUser",
                    onSubmit:function () {

                    }
                })
            }
        }, '-', {
            text: "全部导出",
            iconCls: 'icon-edit',
            handler: function () {

            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {


            }
        }, '-', {
            text: "自定义导出",
            iconCls: 'icon-edit',
            handler: function () {

            }
        },{
        }]



        /*列*/
        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/User/quertyAllUser',
            columns: [[
                {field: 'id', title: '编号', width: 100,},
                {field: 'name', title: '姓名', width: 100,},
                {field: 'photoimg', title: '头像路径', width: 100 ,},
                {field: 'dharmaName', title: '法名', width: 100 ,},
                {field: 'sex', title: '性别', width: 100 ,},
                {field: 'province', title: '省份', width: 100 ,},
                {field: 'city', title: '城市', width: 100 ,},
                {field: 'sign', title: '签名', width: 100 ,},
                {field: 'phoneNum', title: '手机号', width: 100 ,},
                {field: 'password', title: '密码', width: 100 ,},
                {field: 'salt', title: '私盐', width: 100 ,},
                {field: 'status', title: '状态', width: 100 ,},
                {field: 'regisDate', title: '注册日期', width: 100 ,},
                {field: 'guru_id', title: '上师', width: 100 ,},
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/'+rowData.photoimg + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.regisDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    })
    $("#bn").click(function () {
        $("#ff").form("submit");
    })

</script>
<table id="dg"></table>
<div id="dd"  align="center"  class="easyui-dialog" title="导入文件" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="ff" method="post">
        <div>&nbsp;</div>
        <div>&nbsp;</div>
        <div>
            <label for="execl">请选择您要导入的文件:</label>
            <div>&nbsp;</div>
            <input class="easyui-filebox" id="execl" name="execl" style="width:300px">
        </div>
        <div>&nbsp;</div>
        <input type="button" id="bn" value="提交">
    </form>


</div>


