package sure.sys.entity;

import com.sure.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
* @类名: 系统图片库
* @描述: 实体对象 系统图片库
* @作者: yesk
* @日期: 2019-04-24 11:00:13
*/
@Table(name = "SYS_PICTURE_LIB")
public class SysPictureLib extends BaseEntity
		<Long> {

	private static final long serialVersionUID = 4943075705561650080L;

	// ~~~~实体属性
		//??Ʒ????
			@Column(name = "MODEL_CODE")
		private String modelCode;
		//图片来源(wap  pc)
			@Column(name = "SOURCE")
		private String source;
		//图片路径
			@Column(name = "URL")
		private String url;
		//图片标题
			@Column(name = "TITTLE")
		private String tittle;

	@Override
	public Long getId() {
	return super.getId();
	}

	@Override
	public void setId(Long id) {
	super.setId(id);
	}

		/**
		* ??Ʒ????
		*/
		public String getModelCode() {
		return this.modelCode;
		}

		/**
		* ??Ʒ????
		*/
		public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
		}

		/**
		* 图片来源(wap  pc)
		*/
		public String getSource() {
		return this.source;
		}

		/**
		* 图片来源(wap  pc)
		*/
		public void setSource(String source) {
		this.source = source;
		}

		/**
		* 图片路径
		*/
		public String getUrl() {
		return this.url;
		}

		/**
		* 图片路径
		*/
		public void setUrl(String url) {
		this.url = url;
		}

		/**
		* 图片标题
		*/
		public String getTittle() {
		return this.tittle;
		}

		/**
		* 图片标题
		*/
		public void setTittle(String tittle) {
		this.tittle = tittle;
		}
	}
