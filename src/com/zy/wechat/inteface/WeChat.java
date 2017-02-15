package com.zy.wechat.inteface;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.zy.wechat.commons.HttpUtil;
import com.zy.wechat.dataVO.AccessTokenVO;
import com.zy.wechat.dataVO.ArticleVO;
import com.zy.wechat.dataVO.ArticleVOs;
import com.zy.wechat.dataVO.SendAllVO;
import com.zy.wechat.resultVO.SendAllResultVO;
import com.zy.wechat.resultVO.UploadMediaResultVO;

/**
 * 
 * @author octopus
 * 
 */
public class WeChat {
//	private static String APPID = "wxd02661583f3593d2";
//	private static String APPSECET = "117fb6354186dbf009b9417e1cc72543";
//	
//	/**测试账号**/
//	private static String APPID = "wx2ed0286cb64095f8";
//	private static String APPSECET = "f48568c1960d8f66ff10f0866d9eb174";
	
	/**测试账号**/
	private static String APPID = "wxadcc76ecae4a8c53";
	private static String APPSECET = "2f04a0c201f2498ce8273310a8799d90";
	
	private static String BASEURL = "https://api.weixin.qq.com/cgi-bin";

	static {

	}

	/**
	 * 获取Token
	 * @return
	 */
	public static AccessTokenVO token() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", APPID);
		params.put("secret", APPSECET);
		String rs = HttpUtil.net(BASEURL + "/token", params, HttpUtil.METHOD_GET, "UTF-8");
		if (rs != null) {
			try {
				JSONObject object = new JSONObject(rs);
				return new AccessTokenVO(object.getString("access_token"),object.getLong("expires_in"),System.currentTimeMillis());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 接口调用次数清零
	 * @param access_token
	 * @return
	 */
	public static String clearQuota(String access_token){
		String rs = HttpUtil.post(BASEURL+"/clear_quota", access_token, null, "UTF-8");
		return rs;
	}
	
	/**
	 * 群发接口
	 * @param access_token
	 * @param data
	 * @return
	 */
	public static SendAllResultVO sendall(String access_token,SendAllVO data){
		JSONObject object = new JSONObject(data);
		System.out.println(object);
		String rs = HttpUtil.post(BASEURL+"/message/mass/sendall",access_token, object.toString(), "UTF-8");
		System.out.println(rs);
		return null;
	}
	
	/**
	 * 群发消息预览
	 * @param access_token
	 * @param data
	 * @return
	 */
	public static SendAllResultVO preview(String access_token,SendAllVO data){
		JSONObject object = new JSONObject(data);
		System.out.println(object);
		String rs = HttpUtil.post(BASEURL+"/message/mass/preview",access_token, object.toString(), "UTF-8");
		System.out.println(rs);
		return null;
	}
	
	/**
	 * 上传图文素材
	 * @param access_token
	 * @param articles
	 * @return
	 */
	public static UploadMediaResultVO uploadnews(String access_token,ArticleVOs articles){
		JSONObject data = new JSONObject(articles);
		String rs = HttpUtil.post(BASEURL+"/media/uploadnews",access_token, data.toString(), "UTF-8");
		System.out.println(rs);
		return null;
	}
	
	/**
	 * 上传图片返回URL
	 * @param access_token
	 * @param file
	 * @return
	 */
	public static String uploadImg(String access_token, File file){
		return HttpUtil.uploadFile(BASEURL+"/media/uploadimg", access_token, file, "UTF-8");
	}

	/**
	 * 新增临时素材
	 * @param access_token
	 * @return
	 */
	public static String upload(String access_token, File file,String type){
		return HttpUtil.uploadFile(BASEURL+"/media/upload", access_token, file,type, "UTF-8");
	}
	
	/**
	 * 新增永久素材
	 * @param access_token
	 * @param file
	 * @param type
	 * @return
	 */
	public static String addMaterial(String access_token, File file,String type){
		return HttpUtil.uploadFile(BASEURL+"/material/add_material", access_token, file,type, "UTF-8");
	}
	
	/**
	 * 批量获取永久素材
	 * @param access_token
	 * @return
	 */
	public static String batchgetMaterial(String access_token){
		String rs = HttpUtil.post(BASEURL+"/material/batchget_material",access_token,null, "UTF-8");
		System.out.println(rs);
		return rs;
	}
}
