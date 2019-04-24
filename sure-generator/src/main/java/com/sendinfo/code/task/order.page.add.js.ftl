$(document).ready(function() {

	// 增加和编辑
	$('#btnSave').click(function() {
		var $this = $(this);
		$this.button('loading');
		$('#userAddForm').doSubmit({
			validate : {
				rules : {
				<#list table.columns as column>
					<#if column.view>
						'${table.javaNameL}.${column.javaName}' : {
							required : true,
							alphanum : true
						}<#if column_has_next>,</#if>
					</#if>
				</#list>
				}
			},
			dataType : 'json',
			beforeSubmit : function(data, form, options) {
				var flag = form.validate().form();
				if (flag == false) {
					$this.button('reset');
				}
				return flag;
			},
			success : function(res, status, xhr, $form) {
				if (res.success) {
					$.msg.store(res.message);
					location.href = "${"$"}{url_list}";
				} else {
					$this.button('reset');
					$.msg.error(res.message);
				}
			}
		});
	});
});
