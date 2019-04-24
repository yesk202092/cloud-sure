$(document).ready(function() {
	var Page = $('#datagrid').grid({
		url : '${"$"}{url_grid}',
		params : {},
		onParams : function() {
			return {
				<#list table.columns as column>
					<#if column.view>
						"${table.javaNameL}.${column.javaName}" : $("#search_${column.javaName}").val()<#if column_has_next>,</#if>
					</#if>
				</#list>
			};
		},
		serial : true,
		checkbox : true,
		limit : 15,
		structure : [
		<#list table.columns as column>
		<#if column.view>
		{
			field : "${column.javaName}",
			name : "${column.comment}",
			width : '100px'
		}<#if column_has_next>,</#if>
		</#if>
		</#list>
		],
		buttons : [{
			text : '新增',
			onclick : function() {
				window.location.href = '${"$"}{url_add}';
			}
		},{
			text : '删除',
			onclick : function() {
				var ids = $('#datagrid').grid('getSelectedIds');
				
				if (ids == null || ids == ''){
					$.msg.error('请选择至少一项 ! ');
					return;
				}
				
				if (confirm("你确认要删除选中的记录?")) {
					var params = {
						ids : ids
					};
					params = $.param(params, true);
					
					$.post('${"$"}{url_doDel}', params, function(res) {
						if (res.success) {
							$('#datagrid').grid('reload');
							$.msg.info(res.message);
						} else {
							$.msg.error(res.message);
						}
					}, "json");
				};
			}
		}]
	});
});

//搜索
$("#btnSearch").click(function() {
	$('#datagrid').grid('reload');
});

// 修改操作
function edit(id) {
	window.location.href = '${"$"}{url_edit}?id=' + id;
}
