package leung;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

public class GetFans {

	private String userName=" ";
	private String password=" ";
	private  String loginUrl = "https://mp.weixin.qq.com/cgi-bin/login";
	private  Map<String,String>cookies;
	private  String token;
	
	public GetFans(String u,String p){
		this.userName=u;
		this.password=p;
	}
	public void setU(String u){
		this.userName=u;
	}
	public void setP(String p){
		this.password=p;
	}
	
	public String  login() throws IOException{
		
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("lang", "zh_CN");
		param.put("f", "json");
		param.put("imgcode", "");
		param.put("username", this.userName);
		param.put("pwd", DigestUtils.md5Hex(this.password.getBytes()));
		//System.out.println(DigestUtils.md5Hex(this.password.getBytes())); 这段用来看看密码有没有进行md5加密
		
		Connection conn = Jsoup.connect(loginUrl);
		conn.header("Accept", "*/*");
		conn.header("Accept-Encoding", "gzip, deflate");
		conn.header("Accept-Language", "zh-CN,zh;q=0.8");
		conn.header("Connection", "Keep-Alive");
		conn.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		conn.header("Host", "mp.weixin.qq.com");
		conn.header("Referer", "https://mp.weixin.qq.com/");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
		conn.header("X-Requested-With","XMLHttpRequest");
		Response response = conn.ignoreContentType(true).method(Method.POST).data(param).execute();
		cookies=response.cookies();
		//System.out.println(response.body());//检测返回的Json
		String responsestr=response.body();
		try{
		String t1=responsestr.split("token=")[1];
		token=t1.split("\"")[0];
		//System.out.println(token); 检测token值
		}catch (Exception e){
			String re=this.userName+"  获取token值失败\n";
			return re; 
		}
		
		String CatchUrl=loginUrl+"cgi-bin/home?t=home/index&lang=zh_CN&token="+token;
		Document doc = Jsoup.connect(CatchUrl).cookies(cookies).get();
		
		//获取账号名
		Elements IDname=doc.getElementsByClass("nickname");
		String IDnameStr=IDname.get(0).text().toString();
		//获取粉丝数
		Elements numbers=doc.getElementsByClass("number");
		String num=numbers.get(2).text().toString();
		return IDnameStr+"\t\t"+num+"\n";
		
	}
	}
