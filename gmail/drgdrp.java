
package gmail;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class drgdrp {

	public static void main(String[] args) {
	
		WebDriver d=launchbr("ff");
		//FirefoxDriver d=new FirefoxDriver();
		d.get("https://jqueryui.com/droppable/");
		Actions action=new Actions(d);
		Tictoeadvance.printlink(d);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.findElement(By.xpath(".//iframe[@class='demo-frame']"));
	WebElement source=d.findElement(By.xpath(".//*[@id='draggable']"));
	WebElement dest=d.findElement(By.xpath(".//*[text()='Drop here']"));	
	action.clickAndHold(source).moveToElement(dest).release().build().perform();
	d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//action.dragAndDrop(source, dest).build().perform();
	d.switchTo().defaultContent();

	}
public static WebDriver launchbr(String f)
{
WebDriver d;
{
if(f.equalsIgnoreCase("ff"))
{
	 d=new FirefoxDriver();
	
}

else{
	
	System.setProperty("webdriver.chrome.driver", "C:/Users/aakashsharma/Desktop/chromedriver.exe");
	 d=	new ChromeDriver();	
	
}
return d;

	}
}
}
