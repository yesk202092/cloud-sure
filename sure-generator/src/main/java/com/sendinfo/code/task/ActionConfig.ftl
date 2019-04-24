
	<!-- ${table.javaName} -->
	<package name="/${config.catalog}_${(table.javaName)?lower_case}" namespace="/${config.catalog}/${(table.javaName)?lower_case}" extends="sendinfo-default">
		<action name="*" method="{1}" class="${table.javaNameL}Action">
			<result>/WEB-INF/ftl/${config.catalog}/${(table.javaName)?lower_case}-{1}.ftl</result>
		</action>
	</package>