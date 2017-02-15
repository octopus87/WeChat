package com.zy.wechat.inteface.test;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.zy.wechat.dataVO.FilterVO;
import com.zy.wechat.dataVO.ImageVO;
import com.zy.wechat.dataVO.SendAllVO;
import com.zy.wechat.dataVO.TextVO;
import com.zy.wechat.inteface.WeChat;

public class WeChatTest {

	@Test
	public void testSendAll() throws UnsupportedEncodingException {
		String asscess_token = "SRHshdIyTrQmbwEOcJgmKmjy1jObInTinYPcUn89yHwZNjbkXWrvQdruYHCMPqLQ6-rpvd_KAdIZY_BRvXPsEDWIgXfdRTlrWuyslslKlkB2LGRl4H7CGal8wjoPBYPsKSYaAIAQYE";
		FilterVO filter = new FilterVO();
		filter.setIs_to_all(true);
		String content = new String(new String("成功".getBytes(),"UTF-8"));
		TextVO text = new TextVO(content);
		SendAllVO data = new SendAllVO();
		data.setTitle("测试");
		data.setMsgtype("image");
//		data.setFilter(filter);
		data.setTowxname("bazhuadazhangyu");
		data.setText(text);
		ImageVO image= new ImageVO("-8-jat2AkEXYu6a1MH00AigefnKqchdGPBgLyAYRHGw");
		data.setImage(image);
		WeChat.preview(asscess_token, data);
//		String rs = WeChat.batchgetMaterial(asscess_token);
//		System.out.println(rs);
	}

}
