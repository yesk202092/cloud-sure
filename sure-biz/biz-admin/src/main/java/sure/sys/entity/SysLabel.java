package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* @类名: 产品标签表
* @描述: 实体对象 产品标签表
* @作者: yesk
* @日期: 2019-04-24 11:00:13
*/
@Table(name = "SYS_LABEL")
public class SysLabel extends BaseEntity
		<Long> {

	private static final long serialVersionUID = 4275230096721690778L;

	// ~~~~实体属性
		//??ǩ??
			@Column(name = "NAME")
		private String name;
		//??ǩ????
			@Column(name = "DESCRIPTION")
		private String description;
		//上级标签
			@Column(name = "PARENT_ID")
		private Long parentId;
		//????ҵ̬
			@Column(name = "BUSINESS_TYPE")
		private String businessType;

	@Override
	public Long getId() {
	return super.getId();
	}

	@Override
	public void setId(Long id) {
	super.setId(id);
	}

		/**
		* ??ǩ??
		*/
		public String getName() {
		return this.name;
		}

		/**
		* ??ǩ??
		*/
		public void setName(String name) {
		this.name = name;
		}

		/**
		* ??ǩ????
		*/
		public String getDescription() {
		return this.description;
		}

		/**
		* ??ǩ????
		*/
		public void setDescription(String description) {
		this.description = description;
		}

		/**
		* 上级标签
		*/
		public Long getParentId() {
		return this.parentId;
		}

		/**
		* 上级标签
		*/
		public void setParentId(Long parentId) {
		this.parentId = parentId;
		}

		/**
		* ????ҵ̬
		*/
		public String getBusinessType() {
		return this.businessType;
		}

		/**
		* ????ҵ̬
		*/
		public void setBusinessType(String businessType) {
		this.businessType = businessType;
		}
	}
