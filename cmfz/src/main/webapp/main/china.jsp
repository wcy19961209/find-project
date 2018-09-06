<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_china" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px">

</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_china'));
    var values;
    function randomData() {
        return Math.round(Math.random() * 1000);
    }
    option = {
        title: {
            text: '持名法州APP用户分布图',
            subtext: '2018年6月 最新数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        // 说明
        legend: {
            orient: 'vertical',
            left: 'left',
            selectedMode:true,
            data: ['山西', '北京']
        },
        visualMap: {
            min: 0,
            max: 5,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        // 工具箱
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {show: true,readOnly: false},
                restore: {},
                mark : {show: true},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '全国用户分布',
                type: 'map',
                mapType: 'china',
                roam: false,
                mapLocation: {
                    x: 'left'
                },
                selectedMode : 'multiple',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                }
            }
        ]
    };
    myChart.setOption(option);
    $.ajax({
        url:"${pageContext.request.contextPath}/user/queryMap",
        dataType: "JSON",
        success:function (data) {
            myChart.setOption({
                series: [{
                    data:data
                }]

            })

        }


    })
</script>























