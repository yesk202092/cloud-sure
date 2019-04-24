package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* @类名: 角色信息
* @描述: 实体对象 角色信息
* @作者: yesk
* @日期: 2019-04-24 11:00:13
*/
@Table(name = "SYS_ROLE")
public class SysRole extends BaseEntity
		<Long> {

	private static final long serialVersionUID = 6056479782363787014L;

	// ~~~~实体属性
		//角色名称
			@Column(name = "ROLE_NAME")
		private String roleName;
		//0:系统管理员 1:景区管理员 2:分销商 3:推广员
			@Column(name = "ACC_TYPE")
		private String accType;
		//状态 0:停用 1:启动
            
			@Column(name = "USE_FLAG")
		private String useFlag;
		//备注
			@Column(name = "REMARK")
		private String remark;

	@Override
	public Long getId() {
	return super.getId();
	}

	@Override
	public void setId(Long id) {
	super.setId(id);
	}

		/**
		* 角色名称
		*/
		public String getRoleName() {
		return this.roleName;
		}

		/**
		* 角色名称
		*/
		public void setRoleName(String roleName) {
		this.roleName = roleName;
		}

		/**
		* 0:系统管理员 1:景区管理员 2:分销商 3:推广员
		*/
		public String getAccType() {
		return this.accType;
		}

		/**
		* 0:系统管理员 1:景区管理员 2:分销商 3:推广员
		*/
		public void setAccType(String accType) {
		this.accType = accType;
		}

		/**
		* 状态 0:停用 1:启动
            
		*/
		public String getUseFlag() {
		return this.useFlag;
		}

		/**
		* 状态 0:停用 1:启动
            
		*/
		public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
		}

		/**
		* 备注
		*/
		public String getRemark() {
		return this.remark;
		}

		/**
		* 备注
		*/
		public void setRemark(String remark) {
		this.remark = remark;
		}
	}
