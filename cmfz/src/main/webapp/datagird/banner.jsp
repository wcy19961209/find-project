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
            text: "添加",
            handler: function () {
                $("#dd").dialog("open");
                    $("#ff").form({
                        url: "${pageContext.request.contextPath}/banner/Add",
                        onSubmit:function () {
                            var isValid = $(this).form('validate');
                            if(isValid){
                                return true;
                            }else{
                                return false;
                            }
                        },
                        success:function () {
                            $('#dd').dialog('close');
                            $('#dg').edatagrid('reload');
                        }
                    });


                /*
                 * 录入数据
                 *
                 * */
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-help',
            handler: function () {
                $('#dg').edatagrid('destroyRow');
                $('#dg').edatagrid('reload');
                /*
                 * 删除数据
                 *
                 * */
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-help',
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
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        },{
        }]



        /*列*/
        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/findAll',
            updateUrl:  "${pageContext.request.contextPath}/banner/remand",
            destroyUrl: "${pageContext.request.contextPath}/banner/remove",

            columns: [[
                {field: 'id', title: '编号', width: 100,},
                {field: 'title', title: '名称', width: 100,},
                {field: 'status', title: '状态', width: 100 , editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }},
                {field: 'description', title: '描述', width: 100 ,},
                {field: 'createDate', title: '时间', width: 100 },
                {field: 'imgPath', title: '图片路径', width: 100 ,},
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
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/'+rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
    })


  $("#save").click(function () {
      $("#ff").form('submit');
  });


</script>


<table id="dg"></table>
<div id="dd" align="center" class="easyui-dialog"  title="My Dialog" style="width:350px;height:300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,title:'请添加轮番图',closed:true,
			buttons:[{
			<%--	text:'保存',
				handler:function(){
				&lt;%&ndash;
				提交数据
				关闭窗口
				刷新数据
				&ndash;%&gt;
                submit();
                $('#dd').dialog('close');
                 $('#dg').edatagrid('reload');
				}

			},{--%>
				text:'关闭',
				handler:function(){
				<%--关闭窗口--%>
                   $('#dd').dialog('close');
				}
			}] ">


    <form id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">图片名称:</label>
            <input class="easyui-validatebox" id="title" type="text" name="title" data-options="required:true" />
        </div>
        <div>&nbsp</div>
        <div>
            <label for="description">图片描述:</label>
            <input class="easyui-validatebox" id="description" type="text" name="description" data-options="validType:''" />
        </div>
        <div>&nbsp</div>
        <div>
            状态: <select id="cc" class="easyui-combobox" name="status" style="width:150px;">
                 <option value="Fabu">已发布</option>
                 <option  value="weifabu">未发布</option>
            </select>
        </div>
        <div>&nbsp</div>
        <div>  创建日期：<input  id="rq"  type= "text" name="createDate" class= "easyui-datebox" required ="required"/> </div>
        <div>&nbsp</div>
       <div>图片：<input class="easyui-filebox" name="img" style="width:150px"></div>
        <div>&nbsp</div>
        <input type = "button" id = "save" value = "提交" />
    </form>

</div>


