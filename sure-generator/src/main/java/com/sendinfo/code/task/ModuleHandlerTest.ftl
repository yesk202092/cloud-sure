package ${config.ifacepkg}.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sendinfo.base.hessian.UserKeyHessianProxyFactory;
import com.sendinfo.base.model.Page;
import com.sendinfo.client.UserHolder;
import com.sendinfo.internal.base.OperationType;
import com.sendinfo.internal.base.${config.interface};
import ${config.ifacepkg}.${config.response};
import ${config.ifacepkg}.${table.javaName}Request;

public class ${table.javaName}ModuleHandlerTest {
	
	${config.interface} p = null;

	@Before
	public void setUp() throws Exception {

		UserHolder.setUserKey("admin-SENDINFO");
		String url = "${config.hessianUrl}";
		UserKeyHessianProxyFactory factory = new UserKeyHessianProxyFactory();
		p = (${config.interface}) factory.create(${config.interface}.class, url);

	}
	
	@Test
	public void testAdd() {
		${table.javaName}Request request = new ${table.javaName}Request();
		request.setOperation(OperationType.ADD);
		
		${config.response} response = p.execute(request);
		System.out.println("==========" + response.getStatus() + "==========");
		System.out.println("==========主键为==" + response.getId() + "==========");
		System.out.println("==========" + response.getErrorMessage()+ "==========");
	}

	@Test
	public void testDelete() {
		${table.javaName}Request request = new ${table.javaName}Request();
		List<Long> ids = new ArrayList<Long>();
		request.setIds(ids);
		request.setOperation(OperationType.DELETE);
		
		${config.response} response = p.execute(request);
		System.out.println("==========" + response.getStatus() + "==========");
		System.out.println("==========主键为==" + response.getId() + "==========");
		System.out.println("==========" + response.getErrorMessage()+ "==========");
	}

	@Test
	public void testUpdate() {
		${table.javaName}Request request = new ${table.javaName}Request();
		request.setId(3l);
		request.setOperation(OperationType.UPDATE);
		
		${config.response} response = p.execute(request);
		System.out.println("==========" + response.getStatus() + "==========");
		System.out.println("==========主键为==" + response.getId() + "==========");
		System.out.println("==========" + response.getErrorMessage()+ "==========");
	}

	@Test
	public void testFind() {
		${table.javaName}Request request = new ${table.javaName}Request();
		request.setPage(new Page());
		request.setOperation(OperationType.FIND);
		
		${config.response} response = p.execute(request);
		if(response.get${table.javaName}Page() != null){
			for(${table.javaName}Request res : response.get${table.javaName}Page().getItems()){
				System.out.println("==========分页数据==" + res.getId()+ "==========");
			}
		}
		if(response.get${table.javaName}List() != null){
			for(${table.javaName}Request res : response.get${table.javaName}List()){
				System.out.println("==========列表数据==" + res.getId() + "==========");
			}
		}
		System.out.println("==========" + response.getErrorMessage()+ "==========");
	}
}