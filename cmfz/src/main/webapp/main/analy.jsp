<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>



<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title: {
            text: '进一个月的注册用户分析图',
            subtext: ""
        },
        tooltip: {},
        legend: {
            data: ['用户']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '用户',
            type: 'line',
            data: []
        }]
    };
    myChart.setOption(option);
    $.ajax({
        url:"${pageContext.request.contextPath}/user/queryWeek",
        type: "post",
        dataType: "JSON",
        success:function (data) {
            myChart.setOption({
                xAxis: {
                    data: data.xAxis
                },
                series: [{
                    name: '用户',
                    data: data.count
                }]
            })

        }
    })
</script>


















