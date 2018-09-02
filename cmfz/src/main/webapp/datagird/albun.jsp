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
            text: "专辑详情",
            handler: function () {
                /*获取选择的节点并返回他*/
                var row= $("#tt1").treegrid('getSelected');
             if(row !=null){
                 if(row.author != null){
                     $("#dd2").dialog("open");
                     /!*读取记录填充到表单中*!/
                     $("#ff2").form('load',row);
                     /!*在uplod包中获取图片*!/
                     $("#corverlmg").prop('src',"${pageContext.request.contextPath}/upload/"+row.corverlmg);
                  }else {
                     alert("请选中专辑");
                 }
            }else{
                 alert("请选中行");
             }

            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-help',
            handler: function () {
                $("#zj").dialog('open');
                $("#ZZ").form({
                    url: "${pageContext.request.contextPath}/Album/dd",
                    onSubmit:function(){
                        var isValid = $(this).form('validate');
                            if(isValid){
                                return true;
                            }else {
                                return false;
                            }
                    },
                    success:function(){
                        $('#zj').dialog('close');
                        $('#tt1').treegrid('reload');
                    }
                });

            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-help',
            handler: function () {
                /*获取父项选中的节点对象*/
                var row =$("#tt1").treegrid('getSelected');
                if(row!=null&&row.corverlmg!=null){
                    $("#ch").dialog('open');
                    $("#chapter").form({
                        /*关系型获取父项的id 拼接请求*/
                        url:"${pageContext.request.contextPath}/Album/chateradd?alubum_id="+row.id,
                        onSubmit:function () {
                            var isValid = $(this).form('validate');
                            if (isValid){
                                return true;
                            }else{
                                return false;
                            }
                    },
                        success:function () {
                            $('#ch').dialog('close');
                            $('#tt1').treegrid('reload');
                        }
                    })
                }else{
                    alert("请选中索要添加的专辑项");
                }
            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-help',
            handler: function () {
               var row= $("#tt1").treegrid('getSelected');
               if(row!=null){
                    if(row.duration!=null){
                        location.href="${pageContext.request.contextPath}/Album/chaptercontroller?name="+row.name+"&audioPath="+row.audioPath;
                    }else{
                        alert("请您正确选择音频文件")
                    }
                }else{
                   alert("请选则您要下载的音频文件");
                }


            }
        }]

        $('#tt1').treegrid({
            url: '${pageContext.request.contextPath}/Album/find',
            method: "post",
            idField: 'id',
            treeField: 'name',
            columns: [[
                {field: 'name', title: '名称', width: 60},
                {field: 'size', title: '大小', width: 60},
                {field: 'audioPath', title: '路径', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],

            fit: true,
            fitColumns:true,
            toolbar:toolbar
            });
        });
    /*专辑*/
    $("#save").click(function(){
        $("#ZZ").form("submit");
    });
    /*章节*/
    $("#bn").click(function () {
        $("#chapter").form("submit");
    })

</script>

<table id="tt1"></table>
<div id="dd2" align="center" class="easyui-dialog" title="请添加专辑" style="width:400px;height:350px;"
     data-options="iconCls:'icon-save',closed:true,resizable:true,modal:true,
     buttons:[{
        text:'关闭',
        handler:function(){
         $('#dd2').dialog('close');
        }
}]">

<form id="ff2" method="post">
        <div>
            <label for="name">专辑名称:</label>
            <input class="easyui-validatebox" id="name" type="text" name="name" data-options="required:true" />
        </div>
    <div>&nbsp</div>
        <div>
            <label for="count">数量:</label>
            <input class="easyui-validatebox" id="count" type="text" name="count" data-options="validType:''" />
        </div>
    <div>&nbsp</div>
     <div>
        <label for="author">作者:</label>
        <input class="easyui-validatebox" id="autho"  type="text" name="author" data-options="validType:''" />
     </div>
    <div>&nbsp</div>


        <div>
            <label for="score">评分:</label>
            <input class="easyui-validatebox" id="score" type="text" name="score" data-options="validType:''" />
        </div>
    <div>&nbsp</div>
    <div><img src="" id="corverlmg" alt="" height="100px" width="100px"></div>
    </form>
</div>

<%--添加专辑窗口--%>
<div id="zj" align="center" class="easyui-dialog" title="添加专辑" style="width:600px;height:400px;  "
     data-options="iconCls:'icon-save',closed:true,resizable:true,modal:true,
     buttons:[{
        text:'关闭',
         handler:function(){
        $('#zj').dialog('close');
    }
        }]">

<form id="ZZ" method="post" enctype="multipart/form-data">
        <div>
            <label for="name">专辑名称:</label>
            <input class="easyui-validatebox" id="zahunji" type="text" name="name" data-options="required:true" />
        </div>
    <div>&nbsp</div>
        <div>
            <label for="count">数量:</label>
            <input class="easyui-validatebox" id="shuling" type="text" name="count" data-options="required:true" />
        </div>
    <div>&nbsp</div>
       <div> 封面：<input class="easyui-filebox" id="img" name="img" style="width:300px" data-options="required:true"></div>
    <div>&nbsp</div>
        <div>
            <label for="score">评分:</label>
            <input class="easyui-validatebox" id="s" type="text" name="score" data-options="required:true" />
        </div>
    <div>&nbsp</div>
        <div>
            <label for="author">作者:</label>
            <input class="easyui-validatebox" id="author" type="text" name="author" data-options="required:true" />
        </div>
    <div>&nbsp</div>
        <div>
            <label for="broadCast">播音:</label>
            <input class="easyui-validatebox" id="broadCast" type="text" name="broadCast" data-options="required:true" />
        </div>
    <div>&nbsp</div>
        <div>
            <label for="brife">内容简介:</label>
            <input class="easyui-validatebox" id="brife" type="text" name="brife" data-options="required:true" />
        </div>
    <div>&nbsp</div>
    <div>  创建日期：<input  id="rq"  type= "text" name="publicDate" class= "easyui-datebox" required ="required" data-options="required:true"/> </div>
    <div>&nbsp</div>
    <div>发布日期：<input  id="fbrq c"  type= "text" name="createDate" class= "easyui-datebox" required ="required" data-options="required:true"/>  </div>
    <div>&nbsp</div>
        <div>
            <label for="status">状态:</label>
            <input class="easyui-validatebox" id="status" type="text" name="status" data-options="required:true" />
        </div>
    <div>&nbsp</div>
    <input type = "button" id = "save" value = "提交" />
    </form>
</div>

<%--添加章节--%>
<div id="ch" align="center" class="easyui-dialog" title="添加章节" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'关闭',
				handler:function(){
                  $('#ch').dialog('close');
				}
			}]">

    <form id="chapter" method="post" enctype="multipart/form-data">
        <div>&nbsp;</div>
        <div>&nbsp;</div>
        <div>
            <label for="name">章节名称:</label>
            <input class="easyui-validatebox" id="names" type="text" name="name" data-options="required:true" />
        </div>
        <div>&nbsp;</div>
        <div>章节文件：<input class="easyui-filebox" name="audioPath" style="width:300px" data-options="required:true"></div>
        <div>&nbsp;</div>
        <div>&nbsp;</div>
        <input type="button" id="bn" value="提交">
    </form>


</div>


