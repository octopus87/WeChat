package com.zy.wechat.dataVO;

public class SendAllVO {
	private String touser;
	private String towxname;
	private FilterVO filter;				//用于设定图文消息的接收者
	private MpnewsVO mpnews;				//用于设定即将发送的图文消息
	private TextVO text;
	private ImageVO image;					//用于群发的消息的media_id
	private String msgtype;					//群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，音乐为music，图片为image，视频为video，卡券为wxcard
	private String title;					//消息的标题
	private String description;				//消息的描述
	private String thumb_media_id;			//视频缩略图的媒体ID
	private int send_ignore_reprint;		//1为继续群发（转载），0为停止群发。该参数默认为0
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTowxname() {
		return towxname;
	}
	public void setTowxname(String towxname) {
		this.towxname = towxname;
	}
	public FilterVO getFilter() {
		return filter;
	}
	public void setFilter(FilterVO filter) {
		this.filter = filter;
	}
	public MpnewsVO getMpnews() {
		return mpnews;
	}
	public void setMpnews(MpnewsVO mpnews) {
		this.mpnews = mpnews;
	}
	public TextVO getText() {
		return text;
	}
	public void setText(TextVO text) {
		this.text = text;
	}
	public ImageVO getImage() {
		return image;
	}
	public void setImage(ImageVO image) {
		this.image = image;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumb_media_id() {
		return thumb_media_id;
	}
	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}
	public int getSend_ignore_reprint() {
		return send_ignore_reprint;
	}
	public void setSend_ignore_reprint(int send_ignore_reprint) {
		this.send_ignore_reprint = send_ignore_reprint;
	}
}
