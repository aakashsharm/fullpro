package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class cnowv7 {

	public static void main(String[] args) throws InterruptedException {
		FirefoxDriver d=new FirefoxDriver();
		d.get("https://s-c-login.cengage.com/cb/");
		d.findElementById("emailId").sendKeys("cnow_inst_019@swlearning.com");
		d.findElementById("password").sendKeys("A123456");
		d.findElementByXPath("//input[@value='Sign In']").click();
		String winHandleBefore = d.getWindowHandle();
		System.out.println(winHandleBefore);
		d.findElementByLinkText("CengageNOW for Warren/Reeve/Duchac’s Accounting").click();
		 for (String Child_Window : d.getWindowHandles())  
	     {  
	     d.switchTo().window(Child_Window); 
	     Thread.sleep(20000);
	 	System.out.println(Child_Window);
	     }
		 d.findElementByXPath(".//*[@id='box-quick-links']/div/ul/li[1]/a").click();;
	String a=	d.getTitle();
		
		System.out.println(a);
		 //WebElement drpdo=d.findElementByXPath(".//span[@id='courseSelectorActive']");
		// Actions act= new Actions(d);
		// act.click(drpdo).build().perform();
		 
		//d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//WebElement link= d.findElementByXPath("//a[starts-with(text(),'28 oct course3')]");
		//act.click(link).build().perform();
		//System.out.println("yupp :)");
		//d.findElementByXPath(".//*[@id='createCourseNextStepButton']").click();
		//d.findElementByXPath(".//*[@id='overview_main']/div").sendKeys("NEWAssignment");
		
		
	
		
		
	 
	}

}
