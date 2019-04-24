var Page = {
	datagrid : null,
	init : function() {
		Page.datagrid = $('#datagrid').datagrid({
			url : '${"$"}{url_grid}',
			toolbar : [{
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					App.openDialog({
						title : '新增窗口',
						iconCls : 'icon-add',
						href : '${"$"}{url_add}'
					});
				}
			}, '-', {
				text : '编辑',
				iconCls : 'icon-edit btn-one',
				handler : function() {
					var id = Page.datagrid.datagrid('getSelectedId');
					App.openDialog({
						title : '编辑窗口',
						iconCls : 'icon-edit',
						href : '${"$"}{url_edit}?id=' + id
					});
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove btn-more',
				handler : function() {
					App.confirm("确认框", "确定删除所选条目吗？", function() {
						$.post('${"$"}{url_del}', {
							ids : Page.datagrid.datagrid('getSelectedId')
						}, function(res) {
							App.view(res);
							if (res.success) {
								Page.reload();
							}
						});
					});
				}
			}]
		});
	},
	reload : function() {
		Page.datagrid.datagrid('reload', {
			<#list table.columns as column>
			<#if column.view>
			"${table.javaNameL}.${column.javaName}" : $("#search_${column.javaName}").val()<#if column_has_next>,</#if>
			</#if>
			</#list>
		});
	}
}

jQuery(document).ready(function() {
	Page.init();
});
