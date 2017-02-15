package com.zy.wechat.resultVO;

public class UploadMediaResultVO {
	private String type;						//媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息（news）
	private String media_id;					//媒体文件/图文消息上传后获取的唯一标识
	private String created_id;					//媒体文件上传时间
	
	public UploadMediaResultVO() {
		super();
	}
	
	public UploadMediaResultVO(String type, String media_id, String created_id) {
		super();
		this.type = type;
		this.media_id = media_id;
		this.created_id = created_id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getCreated_id() {
		return created_id;
	}
	public void setCreated_id(String created_id) {
		this.created_id = created_id;
	}
}
