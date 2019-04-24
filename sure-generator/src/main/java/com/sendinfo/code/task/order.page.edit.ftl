<html>
<head>
<title>${table.comment}-修改</title>
<#noparse>
<@p.jqueryJs />
<@s.url id="url_list" action="list" />
<@s.url id="url_doEdit" action="doEdit" />
<style>
	.formlabel {width: 200px;}
</style>
</#noparse>
<script>
	<${"#"}include "./${table.javaName?lower_case}-edit.js" />
<#noparse>
	jQuery(document).ready(function($) {
		//设置表格样式
		App.getDefaultTableCss();
	});
</#noparse>
</script>
</head>
<body>
	<#noparse><@p.title name="</#noparse>${table.comment}-修改<#noparse>" /></#noparse>
	<div class="work-unit">
		<form id="editInfoForm" action="${"$"}{url_doEdit}" method="post" class="form-inline" style="font-size: 14px;">
			<input type="hidden" name="${table.javaNameL}.id" value="${"$"}{${table.javaNameL}.id}" />
			<div class="form-inline" style="font-size: 14px;">
				<div class="search-sep" style="margin-bottom: 20px;"></div>
				<table id="tableId">
				<#list table.columns as column>
				<#if column.view>
					<tr><td>${column.comment}：</td><td><input type="text" name="${table.javaNameL}.${column.javaName}" value="${"$"}{${table.javaNameL}.${column.javaName}!}"></td></tr>
				</#if>
				</#list>
				</table>
				<hr>
				<div style="padding: 30px 180px;">
					<#noparse>
						<@p.button class="btn-primary" id="btnSave">保存</@p.button>
						<@p.button style="margin-left:30px;" onclick="history.back();">返回</@p.button>
					</#noparse>
				</div>
			</div>
		</form>
	</div>
</body>
</html>