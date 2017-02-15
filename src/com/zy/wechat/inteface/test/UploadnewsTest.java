package com.zy.wechat.inteface.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;

import com.zy.wechat.dataVO.ArticleVO;
import com.zy.wechat.dataVO.ArticleVOs;
import com.zy.wechat.inteface.WeChat;


public class UploadnewsTest {
	@Test
	public void testUploadnews() throws UnsupportedEncodingException {
		String asscess_token = "uUSJdDUoR2sZ3RKbH27DHAJc48mghMq5pSBnnAcvbnrUNo-Z7APtDcM5rGqHB89BUwbS10pY6C1Oz9yZpy5CIJDIoo_aQMZAgMr7sWuAFrQVgpKTwLrlU617WtiCoo8vGZVaAAANGC";
		ArticleVO artVO = new ArticleVO();
		artVO.setThumb_media_id("NstFyEjU__15zp07PG-YYkTdBC4eu1zuNj1e8WuMyQouo-fEKV6pkKLIj5QtTbct");
		artVO.setAuthor("张豫");
		artVO.setTitle("测试文章");
		artVO.setContent("文章内容");
		artVO.setContent_source_url("www.bzyclub.com");
		artVO.setDigest("内容描述");
		artVO.setShow_cover_pic(1);
		ArticleVOs artVOs = new ArticleVOs();
		List<ArticleVO> artVOList = new ArrayList();
		artVOList.add(artVO);
		artVOs.setArticles(artVOList);
		WeChat.uploadnews(asscess_token, artVOs);
	}
}
