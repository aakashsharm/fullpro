package gmail;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;

public class tatoc {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d=drgdrp.launchbr("ff");
		d.get("http://10.0.1.86/tatoc/advanced/rest");
		Tictoeadvance.addwait(d,10);
		String s=d.findElement(By.xpath(".//*[@id='session_id']")).getText().substring(12);

	System.out.println(s);
	String token="http://10.0.1.86/tatoc/advanced/rest/service/token/";

token= token + s;
System.out.println(token);
	}

}
