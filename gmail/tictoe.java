package gmail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class tictoe {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		FirefoxDriver d=new FirefoxDriver();
		d.get("http://10.0.1.86/tatoc/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElementByLinkText("Basic Course").click();
		d.findElementByXPath("//div[@class='greenbox']").click();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.switchTo().frame("main");
		int i=0;
	String e=d.findElementByXPath("//div[@id='answer']").getAttribute("class");
	System.out.println(e);
	d.switchTo().frame("child");
	String match=d.findElementByXPath("//div[text()='Box 2']").getAttribute("class");
	d.switchTo().parentFrame();
	while(!e.equalsIgnoreCase(match))
	{
		d.findElementByXPath("//a[text()='Repaint Box 2']").click();
		d.switchTo().frame("child");
		 match=d.findElementByXPath("//div[text()='Box 2']").getAttribute("class");
		 d.switchTo().parentFrame();
	
	}
	
	d.findElementByXPath("//a[text()='Proceed']").click();	
	
 WebElement source=d.findElementByXPath("//div[@id='dragbox']");
 WebElement dest=d.findElementByXPath("//div[@id='dropbox']");
 
Actions act=new Actions(d);
act.dragAndDrop(source, dest).build().perform();
System.out.println("ended");
d.findElementByXPath("//a[text()='Proceed']").click();
d.switchTo().parentFrame();
String pop=d.getWindowHandle();
d.findElementByXPath("//a[text()='Launch Popup Window']").click();
for(String a:d.getWindowHandles()){
	d.switchTo().window(a);	
}
d.manage().timeouts();
d.findElementByXPath(".//*[@id='name']").sendKeys("sadsdf");
d.findElementByXPath(".//*[@id='submit']").click();
d.switchTo().window(pop);	
System.out.println("pop done command get back");
d.findElementByXPath("//a[text()='Proceed']").click();
//token value
d.findElementByXPath("//a[text()='Generate Token']").click();

String getattri=d.findElementByXPath(".//*[@id='token']").getText();
getattri=getattri.substring(7);
System.out.println(getattri);
Cookie token = new Cookie("Token", getattri);
d.manage().addCookie(token);
d.findElementByXPath("//a[text()='Proceed']").click();
Tictoeadvance.takescreen(d);



	}

}
