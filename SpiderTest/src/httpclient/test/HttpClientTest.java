package httpclient.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import sun.applet.Main;

/**
 * 
 * @author zhangbin
 * 测试 apache的httpclient类
 * httpclient-4.5.2
 * DefaultHttpClient等常用的类已经不推荐使用了
 * 
    DefaultHttpClient —> CloseableHttpClient
    HttpResponse —> CloseableHttpResponse
 */
public class HttpClientTest {
	
	/**
	 * 测试Get方法
	 */
	public static void testGetMethod(){
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://www.baidu.com");
		try {
			CloseableHttpResponse res = client.execute(get);
//			System.out.println(res.getStatusLine());
			HttpEntity entity  = res.getEntity();
			InputStream ins = entity.getContent();
			byte[] tmp = new byte[1024];
			int count = 0 ;
			while((count = ins.read(tmp))!=-1){
				System.out.print(new String(tmp));
			}
			
			//必须手动消耗掉资源或者取消连接（使用CloseableHttpResponse类的close方法）
			 EntityUtils.consume(entity);
			 //res.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testPostMethod(){
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("https://rl.mail.qq.com/cgi-bin/getinvestigate");
		List<NameValuePair> param = new ArrayList<>();
		param.add(new BasicNameValuePair("sid", "-P-4SVLbjEThJi94"));
		try {
			post.setEntity(new UrlEncodedFormEntity(param));
			post.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			post.addHeader("Accept-Encoding", "gzip, deflate, br");
			post.addHeader("Accept-Language", "en-US,en;q=0.5");
			post.addHeader("Connection", "keep-alive");
			post.addHeader("Content-Type", "application/x-www-form-urlencoded");
			post.addHeader("Cookie", "pgv_pvid=2801732877;pac_uid=1_164109059;ptui_loginuin=164109059;pt2gguin=o0164109059;ptcz=a916754d5778d33ed18ebe1e5387583b85edd01075618ffc1b42ac3701aa6327;o_cookie=164109059;dc_live_played=1;ptisp=ctc;uin=o0164109059;skey=@de8UYZoa0;p_uin=o0164109059;p_skey=8j-5*hzUJwfeSrBIX7M3Pv5AgC0eA1Nmfg-atorScmw_;pt4_token=NiWhs2eStLFiEcprurXrtDp6CvR7KQ6YreXnEdhhCsE_;wimrefreshrun=0&;qm_antisky=164109059&f4b1aabfb14f3803a936307237d8dda31f32c0cee911da9a63d5e972f67ae341"
+"; qm_flag=0; qqmail_alias=164109059@qq.com; sid=164109059&ee647b83b94ddbf55a82c8a04bce1cfc,qOGotNSpoelVKd2ZlU3JCSVg3TTNQdjVBZ0MwZUExTm1mZy1hdG9yU2Ntd18"
+".; qm_username=164109059; new_mail_num=164109059&58; qm_domain=https://mail.qq.com; qm_ptsk=164109059&@de8UYZoa0; CCSHOW=000001; foxacc=164109059&0; ssl_edition=sail.qq.com; edition=mail.qq.com; username=164109059&164109059; webp=0");
			post.addHeader("Host", "rl.mail.qq.com");
			post.addHeader("Referer", "https://rl.mail.qq.com/zh_CN/htmledition/ajax_proxy.html?mail.qq.com&v=130132");
			post.addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0");
		
		
			CloseableHttpResponse res = client.execute(post);
			System.out.println(res.getStatusLine());
			HttpEntity entity  = res.getEntity();
			InputStream ins = entity.getContent();
			byte[] tmp = new byte[1024];
			int count = 0 ;
			while((count = ins.read(tmp))!=-1){
				System.out.print(new String(tmp));
			}
			
			//必须手动消耗掉资源或者取消连接（使用CloseableHttpResponse类的close方法）
			 EntityUtils.consume(entity);
			 //res.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
//		testGetMethod();
		testPostMethod();
	}

}
