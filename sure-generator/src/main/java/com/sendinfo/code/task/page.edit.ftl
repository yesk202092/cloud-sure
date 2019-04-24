<html>
<head>
<title>表演中心</title>
<script src="http://cdn.zhiyoubao.com/jquery/jquery.form.js"></script>
<script src="http://cdn.zhiyoubao.com/jquery/jquery.validate.js"></script>
<script src="http://cdn.zhiyoubao.com/jquery/jquery.validate.methods.js"></script>
<script type="text/javascript">
	<${config.include} "./${table.javaName?lower_case}-edit.js">
</script>
</head>
</head>
<body>

<form id="form" method="post" class="form-inline" style="font-size: 14px;">
		<input type="hidden" name="${table.javaNameL}.id" value="${"$"}{${table.javaNameL}.id}" />
		<#list table.columns as column>
		<#if column.view>
			<label class="search-item"><span style="margin-left:27px;">${column.comment}：</span>
			<input type="text" id="${column.javaName}" name="${table.javaNameL}.${column.javaName}" required="true" /></label>
			<div class="search-sep"></div>
		</#if>
		</#list>
		<div style="padding: 10px 150px 20px;">
			<a class="btn" id="back">返回</a> 
			<a class="btn btn-primary" id="btnSave">保存</a> 
		</div>	
</form>
</body>
</html>