package com.zy.wechat.commons;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 
 * @author octopus 20170209
 * 
 */
public class HttpUtil {
	private static final String DEF_CHARSET = "UTF-8";
	private static final int DEF_CONN_TIMEOUT = 6000;
	private static final int DEF_READ_TIMEOUT = 6000;
	private static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static Proxy proxy = null;

	static {
		SocketAddress sa = new InetSocketAddress("proxy01.cnooc", 8080);
		proxy = new Proxy(Type.HTTP, sa);
	}

	public static String net(String strUrl, Map<String, String> params, String method, String charset) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		DataOutputStream out = null;
		URL url = null;
		try {
			StringBuffer sb = new StringBuffer();
			if (method.equals(METHOD_GET)) {
				strUrl = strUrl + "?" + URLEncode(params, charset);
			}
			url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection(proxy);
			conn.setRequestProperty("Proxy-Authorization", "Basic ZXhfemhhbmd5dTpaWTA5MTIyNUNGRnl5");
			conn.setRequestMethod(method);
			if (method.equals(METHOD_POST)) {
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			if (params != null && method.equals(METHOD_POST)) {
				out = new DataOutputStream(conn.getOutputStream());
				out.writeBytes(URLEncode(params, charset));
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHARSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	public static String post(String strUrl, String access_token, String paramsJson, String charset) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		DataOutputStream out = null;
		URL url = null;
		try {
			StringBuffer sb = new StringBuffer();
			strUrl = strUrl + "?access_token=" + access_token;
			url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection(proxy);
			conn.setRequestProperty("Proxy-Authorization", "Basic ZXhfemhhbmd5dTpaWTA5MTIyNUNGRnl5");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("User-agent", userAgent);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			conn.connect();
			out = new DataOutputStream(conn.getOutputStream());
			if(paramsJson!=null){
				System.out.println(paramsJson);
				out.write(paramsJson.getBytes());
			}
			InputStream is = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, DEF_CHARSET));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sb.append(strRead);
			}
			rs = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rs;
	}

	public static String uploadFile(String strUrl, String access_token, File file, String charset) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		DataOutputStream out = null;
		URL url = null;
		String boundary = "-----zzzzzzzzzzzzzyyyyyyyyyyyyyyyyyyyyhelloworlddsaf321341rfdasfa-----"; // 我是分割线
		String endStr = "\r\n";
		String twoHyphen = "--";
		try {
			StringBuffer sb = new StringBuffer();
			strUrl = strUrl + "?access_token=" + access_token;
			url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection(proxy);
			//允许input、Output,不使用Cache
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("User-agent", userAgent);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			conn.setRequestProperty("Proxy-Authorization", "Basic ZXhfemhhbmd5dTpaWTA5MTIyNUNGRnl5");
			
			conn.connect();
			out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(twoHyphen + boundary + endStr);
			out.writeBytes("Content-Disposition: form-data; name=\"" + file.getName() + "\"; filename=\"" + encode(file.getAbsolutePath()) + "\""+endStr);
			out.writeBytes(endStr);
			out.write(getBytes(file));
			out.writeBytes(endStr);
			out.writeBytes(twoHyphen+boundary+twoHyphen+endStr);
			out.close();
			
			if(200 == conn.getResponseCode()){
				InputStream is = conn.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is, DEF_CHARSET));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sb.append(strRead);
				}
				rs = sb.toString();
				return rs;
			}else{
				return "error";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return "error";
	}
	
	public static String uploadFile(String strUrl, String access_token, File file,String type, String charset) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		String rs = null;
		DataOutputStream out = null;
		URL url = null;
		String boundary = "-----zzzzzzzzzzzzzyyyyyyyyyyyyyyyyyyyyhelloworlddsaf321341rfdasfa-----"; // 我是分割线
		String endStr = "\r\n";
		String twoHyphen = "--";
		try {
			StringBuffer sb = new StringBuffer();
			strUrl = strUrl + "?access_token=" + access_token+"&type="+type;
			url = new URL(strUrl);
			conn = (HttpURLConnection) url.openConnection(proxy);
			
			//允许input、Output,不使用Cache
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("User-agent", userAgent);
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			conn.setRequestProperty("Proxy-Authorization", "Basic ZXhfemhhbmd5dTpaWTA5MTIyNUNGRnl5");
			
			conn.connect();
			out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(twoHyphen + boundary + endStr);
			out.writeBytes("Content-Disposition: form-data; name=\"media\"; filename=\"" + encode(file.getAbsolutePath()) + "\""+endStr);
			out.writeBytes(endStr);
			out.write(getBytes(file));
			out.writeBytes(endStr);
			out.writeBytes(twoHyphen+boundary+twoHyphen+endStr);
			out.close();
			
			if(200 == conn.getResponseCode()){
				InputStream is = conn.getInputStream();
				reader = new BufferedReader(new InputStreamReader(is, DEF_CHARSET));
				String strRead = null;
				while ((strRead = reader.readLine()) != null) {
					sb.append(strRead);
				}
				rs = sb.toString();
				return rs;
			}else{
				return "error";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return "error";
	}
	

	public static String URLEncode(Map<String, String> data, String charset) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> i : data.entrySet()) {
			if (charset == null || charset.length() == 0) {
				sb.append(i.getKey()).append("=").append(i.getValue()).append("&");
			} else {
				try {
					sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue(), charset)).append("&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static String encode(String value) throws Exception {
		return URLEncoder.encode(value, "UTF-8");
	}

	public static byte[] getBytes(File f) throws IOException{
		FileInputStream fis = new FileInputStream(f);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int n ; 
		while((n=fis.read(b))!=-1){
			out.write(b,0,n);
		}
		fis.close();
		return out.toByteArray();
	}
}
