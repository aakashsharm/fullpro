package gmail;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class drgdrp {

	public static void main(String[] args) {
	
		FirefoxDriver d=new FirefoxDriver();
		d.get("https://jqueryui.com/droppable/");
		Actions action=new Actions(d);	
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//d.findElementByXPath(".//iframe[@class='demo-frame']");
	
		d.switchTo().frame(d.findElementByXPath(".//iframe[@class='demo-frame']"));
		WebElement source=d.findElementByXPath(".//*[@id='draggable']");
		WebElement dest=d.findElementByXPath(".//*[text()='Drop here']");
		
	action.clickAndHold(source).moveToElement(dest).release().build().perform();
	d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//action.dragAndDrop(source, dest).build().perform();
	d.switchTo().defaultContent();
d.findElementByXPath(".//*[@id='sidebar']/aside[2]/ul/li[4]/a").click();
	



	}
}
