package com.zy.wechat.inteface.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.zy.wechat.dataVO.FilterVO;
import com.zy.wechat.dataVO.ImageVO;
import com.zy.wechat.dataVO.MpnewsVO;
import com.zy.wechat.dataVO.SendAllVO;
import com.zy.wechat.dataVO.TextVO;
import com.zy.wechat.inteface.WeChat;

public class NewsTest {

	@Test
	public void testSendAll() throws UnsupportedEncodingException {
		String access_token = "uUSJdDUoR2sZ3RKbH27DHAJc48mghMq5pSBnnAcvbnrUNo-Z7APtDcM5rGqHB89BUwbS10pY6C1Oz9yZpy5CIJDIoo_aQMZAgMr7sWuAFrQVgpKTwLrlU617WtiCoo8vGZVaAAANGC";
		SendAllVO data = new SendAllVO();
		FilterVO filter = new FilterVO();
		filter.setIs_to_all(true);
		data.setFilter(filter);
		data.setMsgtype("mpnews");
		MpnewsVO mpnews = new MpnewsVO();
		mpnews.setMedia_id("dm6WEFtWPGr22eyRwFT0p-g2361jJK4u7p3M2SCXjij7GvsGSxhQ4BwbcHKW1flw");
		data.setMpnews(mpnews);
//		data.setTowxname("bazhuadazhangyu");
//		data.setTowxname("wutong936880");
//		data.setSend_ignore_reprint(1);
//		WeChat.preview(access_token, data);
		WeChat.sendall(access_token, data);
	}
}
