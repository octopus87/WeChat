package com.zy.wechat.dataVO;

/**
 * 图文消息VO
 * @author octopus
 *
 */
public class ArticleVO {
	private String thumb_media_id;						//图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
	private String author;							//图文消息的作者
	private String title;							//图文消息的标题
	private String content_source_url;				//在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加 #wechat_redirect 后缀。
	private String content;							//图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用
	private String digest;							//图文消息的描述
	private int show_cover_pic;						//是否显示封面，1为显示，0为不显示
	
	public ArticleVO() {
		super();
	}

	
	public ArticleVO(String thumb_media_id, String author, String title, String content_source_url, String content, String digest, int show_cover_pic) {
		super();
		this.thumb_media_id = thumb_media_id;
		this.author = author;
		this.title = title;
		this.content_source_url = content_source_url;
		this.content = content;
		this.digest = digest;
		this.show_cover_pic = show_cover_pic;
	}


	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_source_url() {
		return content_source_url;
	}
	public void setContent_source_url(String content_source_url) {
		this.content_source_url = content_source_url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}

	public int getShow_cover_pic() {
		return show_cover_pic;
	}

	public void setShow_cover_pic(int show_cover_pic) {
		this.show_cover_pic = show_cover_pic;
	}
	
}
