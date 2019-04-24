	
	<bean name="/${config.catalog}/${table.javaNameL}" class="org.springframework.remoting.caucho.HessianServiceExporter">
		<property name="service" ref="${table.javaNameL}Interface" />
		<property name="serviceInterface" value="${config.ifacepkg}.${table.javaName}Interface" />
	</bean>
	
	<bean id="${table.javaNameL}Interface" class="org.springframework.remoting.caucho.HessianProxyFactoryBean">
		<property name="serviceUrl" value="${"$"}{${config.catalog}.hessian.url}/${config.catalog}/${table.javaNameL}" />
		<property name="serviceInterface" value="${config.ifacepkg}.${table.javaName}Interface" />
	</bean>
	
	