package Login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class login_m {

	public static void main(String[] args) throws Exception {

		FirefoxDriver d=new	FirefoxDriver();
		homepage(d);
		//mailcount(d);
		//firstpage(d);
		m(d);
	}
	
	public static void homepage(WebDriver d) throws InterruptedException
	{
		d.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1");
		d.findElement(By.xpath("//input[@id='Email']")).sendKeys("perfectworkers4u");
		d.findElement(By.xpath("//input[@id='next']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("akki123456");
		d.findElement(By.xpath("//input[@id='signIn']")).click();
		Thread.sleep(5000);
	}

	public static void mailcount(WebDriver d) throws Exception{
	WebElement w=	d.findElement(By.xpath("//div[@id=':gc']"));
		String s=w.getText();
	String scount=	s.substring(8);
	WebElement middle=	d.findElement(By.xpath(".//*[@id=':gc']/span/b[2]"));
		int maxcount= Integer.parseInt(scount);
		System.out.println("total meesgae"+maxcount);
		int i,count=0,j;
		
		int loop=maxcount/50;
		
		if (maxcount%10==0){
			loop=loop;
		}
		else
		{
			loop=loop+1;
			
		}
		System.out.println(loop);
		int k;
		for(j=1,k=1;j<=loop;j++,k++)
		{
			if(k>4)
				k=4;
			List<WebElement> a=	d.findElements(By.xpath("//div[@role='main']//div[@class='y6']//b"));
			i=a.size();
			
		
			//System.out.println("Current UnRead - "+i);
			count = count+i;
			Thread.sleep(4000);	
			d.findElement(By.xpath("(//span[@class='Di'][1]/div[3])["+k+"]")).click();
			//d.findElement(By.xpath(".//*[@id=':gf']//img[@class='amJ T-I-J3']")).click();
			Thread.sleep(4000);
			//System.out.println("Total UnRead - "+count);	
			
		}
		System.out.println("Total UnRead - "+count);	

	}
	
	public static void m(WebDriver d) throws InterruptedException, AWTException{
		WebElement w=	d.findElement(By.xpath("//div[@id=':gc']"));
		String s=w.getText();
	String scount=	s.substring(8);
		 java.util.Scanner scn=new java.util.Scanner(System.in);
		   System.out.println("Enter KeyWords exactly you want to made as read");
		   String x=scn.nextLine();
		 System.out.println(x); 
	WebElement middle=	d.findElement(By.xpath(".//*[@id=':gc']/span/b[2]"));
		int maxcount= Integer.parseInt(scount);
		System.out.println("total meesgae"+maxcount);
		int i,count=0,j;
	
		int loop=maxcount/50;
		
		if (maxcount%10==0){
			loop=loop;
		}
		else
		{
			loop=loop+1;
			
		}
		System.out.println(loop);
		int k;
		for(j=1,k=1;j<=loop;j++,k++)
		{
		
			if(k>4)
				k=4;

			List<WebElement> a=	d.findElements(By.xpath("//div[@role='main']//tbody//div[contains(text(),'unread')]/following-sibling :: div[1]//span[text()='"+x+"']"));
			i=a.size();
			System.out.println("total  matches - "+i+"on pages"+j);
		if(i==0){
			d.findElement(By.xpath("(//div[@role='button']//span[text()='More'])["+k+"]")).click();
		
		}
			
			Thread.sleep(4000);	
		
	List<WebElement> chkBox=d.findElements(By.xpath("//div[@role='main']//tbody//div[contains(text(),'unread')]/following-sibling :: div[1]//span[text()='"+x+"']//ancestor::tr/td/div[@role='checkbox']"));
		
	for(WebElement ck:chkBox){
		ck.click();
		Thread.sleep(200);
	}
	Thread.sleep(3000);
d.findElement(By.xpath("(//div[@role='button']//span[text()='More'])["+k+"]")).click();
Thread.sleep(3000);
if(i!=0){
	Thread.sleep(500);
	Actions act=new Actions(d);
d.findElement(By.xpath("(//div[@role='menu']//div[@role='menuitem']//div[text()='Mark as read'])["+k+"]"));
act.clickAndHold();
Robot robot = new Robot();  // Robot class throws AWT Exception	
Thread.sleep(2000); // Thread.sleep throws InterruptedException	
robot.keyPress(KeyEvent.VK_DOWN) ;
robot.keyPress(KeyEvent.VK_ENTER);
Thread.sleep(500);

}


	d.findElement(By.xpath("(//span[@class='Di'][1]/div[3])["+k+"]")).click();

			Thread.sleep(4000);
			
			System.out.println("Total UnRead  message on this page which is coverted into read is - "+i);	
			count=count+i;
		}
		System.out.println("Total UnRead - "+count);	
		////div[contains(text(),'unread')]/following-sibling :: div[1]//span[text()='Freelancer.com']
		////table[@id=':2f']//div[contains(text(),'unread')]/following-sibling :: div[1]/span[text()='Freelancer.com']
		////div[@role='main']//tbody//div[contains(text(),'unread')]/following-sibling :: div[1]//span[text()='Freelancer.com']
	}
	public static void delete(WebDriver d)
	{
		 java.util.Scanner scn=new java.util.Scanner(System.in);
		   System.out.println("if want to delete press y  else no");
		   String x=scn.nextLine();
		 System.out.println("you entered"+x); 
		 if(x.equalsIgnoreCase("y"))
		 {
			
			 
		 }
		 else 
		 {
			 System.out.println("either u chose invalid option or you dont want to delete anything ");
			 
		 }
	}
}
	