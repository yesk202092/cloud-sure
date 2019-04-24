package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* @类名: 系统参数表
* @描述: 实体对象 系统参数表
* @作者: yesk
* @日期: 2019-04-24 11:00:13
*/
@Table(name = "SYS_PARAM")
public class SysParam extends BaseEntity
		<Long> {

	private static final long serialVersionUID = 3579405653414496318L;

	// ~~~~实体属性
		//参数编号
			@Column(name = "PARAM_CODE")
		private String paramCode;
		//参数名称
			@Column(name = "PARAM_NAME")
		private String paramName;
		//选项
			@Column(name = "PARAM_OPTION")
		private String paramOption;
		//备注
			@Column(name = "REMARK")
		private String remark;
		//排序
			@Column(name = "SORT_NO")
		private Long sortNo;

	@Override
	public Long getId() {
	return super.getId();
	}

	@Override
	public void setId(Long id) {
	super.setId(id);
	}

		/**
		* 参数编号
		*/
		public String getParamCode() {
		return this.paramCode;
		}

		/**
		* 参数编号
		*/
		public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
		}

		/**
		* 参数名称
		*/
		public String getParamName() {
		return this.paramName;
		}

		/**
		* 参数名称
		*/
		public void setParamName(String paramName) {
		this.paramName = paramName;
		}

		/**
		* 选项
		*/
		public String getParamOption() {
		return this.paramOption;
		}

		/**
		* 选项
		*/
		public void setParamOption(String paramOption) {
		this.paramOption = paramOption;
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

		/**
		* 排序
		*/
		public Long getSortNo() {
		return this.sortNo;
		}

		/**
		* 排序
		*/
		public void setSortNo(Long sortNo) {
		this.sortNo = sortNo;
		}
	}
