<html>
<head>
<title>${table.comment}</title>
<#noparse>
<@p.jqueryJs />
<@s.url id="url_grid" action="grid" />
<@s.url id="url_add" action="add" />
<@s.url id="url_edit" action="edit" />
<@s.url id="url_doDel" action="doDel" />
</#noparse>
<script>
	<${"#"}include "./${table.javaName?lower_case}-list.js" />
</script>
</head>
<body>
	<#noparse><@p.title name="</#noparse>${table.comment}<#noparse>" /></#noparse>
	<div class="form-inline psearch">
		<div>
			<#list table.columns as column>
				<#if column.view>
				<label class="pslabel">${column.comment}：</label>
				<input type="text" id="search_${column.javaName}" style="width: 120px;" />
				</#if>
			</#list>
			
			<button type="button" style="margin-left:20px;" class="btn btn-small" id="btnSearch" title="点击查询结果">查询</button>
		</div>
	</div>
	<div id="datagrid"></div>
</body>
</html>