package com.zy.wechat.resultVO;

public class SendAllResultVO {
	private String type;
	private String errcode;
	private String errmsg;
	private String msg_id;
	private String msg_data_id;
	
	public SendAllResultVO(String type, String errcode, String errmsg, String msg_id, String msg_data_id) {
		super();
		this.type = type;
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.msg_id = msg_id;
		this.msg_data_id = msg_data_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getMsg_data_id() {
		return msg_data_id;
	}
	public void setMsg_data_id(String msg_data_id) {
		this.msg_data_id = msg_data_id;
	}
	
}
