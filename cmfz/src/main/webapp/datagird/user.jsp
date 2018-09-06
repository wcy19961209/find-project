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

        $("#btn").click(function (data) {
            var titles = $("#customer_tree").combotree("getText");
            var params = $("#customer_tree").combotree("getValues");
            var a = "";
            $.each(params, function (index, param) {
                if (params.length - 1 == index) {
                    a += param;
                } else {
                    a += param + ",";
                }
            })
            $("#customer_form").form("submit", {
                url: "${pageContext.request.contextPath}/User/customerExport",
                queryParams: {
                    titles: titles,
                    params: a
                }
            })

        })

        var toolbar = [{
            iconCls: 'icon-edit',
            text: "全部导入",
            handler: function () {
                $("#dd").dialog('open');
                $("#ff").form({
                    url:"${pageContext.request.contextPath}/User/iopImportUser",

                })
            }
        }, '-', {
            text: "全部导出",
            iconCls: 'icon-edit',
            handler: function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/User/iopExport",
                    dataType: "post",
                    success:function(data){
                        alert("导出成功");
                    }
                })
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {
                    var index = $("#dg").edatagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }

            }
        }, '-', {
            text: "自定义导出",
            iconCls: 'icon-edit',
            handler: function () {
                $("#customer_dd").dialog("open");
            }
        },'-',{
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        },{
        }]



        /*列*/
        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/User/quertyAllUser',
            updateUrl: '${pageContext.request.contextPath}/User/status?',
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
                {field: 'status', title: '状态', width: 100 ,editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }},
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
    <form id="ff" method="post" enctype="multipart/form-data">
        <div>&nbsp;</div>
        <div>&nbsp;</div>
        <div>
            <label for="execl">请选择您要导入的文件:</label>
            <div>&nbsp;</div>
            <input class="easyui-filebox" id="execl" name="execll" style="width:300px">
        </div>
        <div>&nbsp;</div>
        <input type="button" id="bn" value="提交">
    </form>
</div>

<div id="customer_dd" class="easyui-dialog" title="自定义导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <select id="customer_tree" class="easyui-combotree" style="width:200px;"
            data-options="checkbox:true,multiple:true,onlyLeafCheck:true,required:true,
            data:[{
    'id':'custome',
    'checked':false,
    'text': '请选择',
    'children': [
      {
        'id':'id',
        'text': '编号',
        'checked': true
      },
      { 'id':'photoimg',
        'text': '头像',
        'checked': true
      },
      { 'id':'name',
        'text': '名字',
        'checked': true
      },
      { 'id':'dharmaName',
        'text': '法名',
        'checked': true
      },
      { 'id':'sex',
        'text': '性别',
        'checked': true
      },
      { 'id':'province',
        'text': '省份',
        'checked': true
      },{ 'id':'city',
        'text': '城市',
        'checked': true
      },{ 'id':'sign',
        'text': '签名',
        'checked': true
      },{ 'id':'phoneNum',
        'text': '手机号',
        'checked': true
      },{ 'id':'password',
        'text': '密码',
        'checked': true
      },{ 'id':'salt',
        'text': '私盐',
        'checked': true
      },{ 'id':'status',
        'text': '状态',
        'checked': true
      },{ 'id':'regisDate',
        'text': '注册时间',
        'checked': true
      },{ 'id':'guru_id',
        'text': '上师_id',
        'checked': true
      },
    ]
  }
]"></select>
    <form action="" method="post" id="customer_form">
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a>
    </form>
</div>


