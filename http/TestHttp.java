package myTest.http;

import myTest.http.common.Get;
import myTest.http.common.Http;

/**
 * Created By WangLichao On 2016年6月6日.
 */
public class TestHttp {
	public static void main(String[] args) {
		Get get = Http.get("http://baidu.com");
		System.out.println(get.text());
		System.out.println(get.headers());
		System.out.println(get.responseCode());
	}
}
