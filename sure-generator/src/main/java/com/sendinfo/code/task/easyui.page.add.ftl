<div>
	<form method="post" class="form form-horizontal validform" action="${"$"}{ctx.contextPath}/${config.prefix}/${table.javaNameL}/save">
		<#list table.columns as column>
		<#if column.view>
		<div class="row cl">
			<span class="form-label col-xs-4 col-sm-3">${column.comment}：</span>
			<div class="formControls col-xs-8 col-sm-6">
				<input class="input-text" name="${column.javaName}" />
			</div>
			<div class="col-xs-8 col-xs-offset-4 col-sm-3"> </div>
		</div>
		</#if>
		</#list>
		<div class="row cl">
			<div class="col-xs-8 col-sm-6 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				<input class="btn btn-success layer-close" type="button" value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
