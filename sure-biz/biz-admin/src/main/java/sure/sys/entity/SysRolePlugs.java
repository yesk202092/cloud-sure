package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* @类名: 角色的具体模块权限表
* @描述: 实体对象 角色的具体模块权限表
* @作者: yesk
* @日期: 2019-04-24 11:00:13
*/
@Table(name = "SYS_ROLE_PLUGS")
public class SysRolePlugs extends BaseEntity
		<Long> {

	private static final long serialVersionUID = 1411522841709626424L;

	// ~~~~实体属性
		//角色ID
			@Column(name = "SYS_ROLE_ID")
		private Long sysRoleId;
		//关联系统功能模块表中的ID
			@Column(name = "SYS_FUNCTIONS_ID")
		private Long sysFunctionsId;
		//????Ȩ?? save,update,delete,view,list,grid
			@Column(name = "SYS_OPT")
		private String sysOpt;

	@Override
	public Long getId() {
	return super.getId();
	}

	@Override
	public void setId(Long id) {
	super.setId(id);
	}

		/**
		* 角色ID
		*/
		public Long getSysRoleId() {
		return this.sysRoleId;
		}

		/**
		* 角色ID
		*/
		public void setSysRoleId(Long sysRoleId) {
		this.sysRoleId = sysRoleId;
		}

		/**
		* 关联系统功能模块表中的ID
		*/
		public Long getSysFunctionsId() {
		return this.sysFunctionsId;
		}

		/**
		* 关联系统功能模块表中的ID
		*/
		public void setSysFunctionsId(Long sysFunctionsId) {
		this.sysFunctionsId = sysFunctionsId;
		}

		/**
		* ????Ȩ?? save,update,delete,view,list,grid
		*/
		public String getSysOpt() {
		return this.sysOpt;
		}

		/**
		* ????Ȩ?? save,update,delete,view,list,grid
		*/
		public void setSysOpt(String sysOpt) {
		this.sysOpt = sysOpt;
		}
	}
