package com.zy.wechat.inteface.test;

import java.io.File;

import org.junit.Test;

import com.zy.wechat.inteface.WeChat;


public class UploadImgTest {
	@Test
	public void testUploadImgTest() {
		File file = new File("E:\\新建文件夹\\Pictures\\摩托\\18715886929784340.jpg");
		String asscess_token = "uUSJdDUoR2sZ3RKbH27DHAJc48mghMq5pSBnnAcvbnrUNo-Z7APtDcM5rGqHB89BUwbS10pY6C1Oz9yZpy5CIJDIoo_aQMZAgMr7sWuAFrQVgpKTwLrlU617WtiCoo8vGZVaAAANGC";
		String rs = WeChat.addMaterial(asscess_token, file,"thumb");
		System.out.println(rs);
	}
}
