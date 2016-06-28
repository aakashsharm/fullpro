package gmail;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

public class tatoc {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver d=new FirefoxDriver();
		d.get("http://10.0.1.86/tatoc/advanced/rest");
		Tictoeadvance.addwait(d);
		String s=d.findElementByXPath(".//*[@id='session_id']").getText().substring(12);
	System.out.println(s);
	String token="http://10.0.1.86/tatoc/advanced/rest/service/token/";

token= token + s;
System.out.println(token);
	}

}
