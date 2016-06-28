package gmail;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tictoeadvance {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		FirefoxDriver d=new FirefoxDriver();
		d.get("http://10.0.1.86/tatoc/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.findElementByLinkText("Advanced Course").click();

	Actions act=new Actions(d);
	act.moveToElement(d.findElementByXPath("//div[@class='menutop m2']")).click().build().perform();
	d.findElementByXPath("//span[contains(text(),'Go Next')]").click();
	try{  
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection con= DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01");  
	      Statement stmt= con.createStatement();  
	      String symbol = d.findElementById("symboldisplay").getText();
		   ResultSet rs= stmt.executeQuery("select name, passkey from identity i,credentials c where i.symbol='"+symbol+"' AND i.id=c.id");  
	      while(rs.next()) { 
	    	  System.out.println(rs.getString(1)+"  "+rs.getString(2));  
	          String user= rs.getString(1);
	          d.findElement(By.id("name")).sendKeys(user);
	          String passkey= rs.getString(2);
	          d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	          d.findElement(By.id("passkey")).sendKeys(passkey);
	          d.findElement(By.id("submit")).click();
	    
	          break;
	      }
	      //JavascriptExecutor js = (JavascriptExecutor) d;
	      
	      //js .executeScript("document.getElementById(\"ooyalaplayer\").play()");
	}
	catch (Exception e)
	{
		System.out.println("finnly called"+e);
	}
	
	
	      }
	
	public static  void takescreen(FirefoxDriver f) throws IOException
	{
		 File src =f.getScreenshotAs(OutputType.FILE);
			FileUtils fu=new FileUtils();
			File dest= new File("C:/Users/aakashsharma/Desktop/march/image7"+ ".png");
			fu.moveFile(src, dest);
		
	}
	public static void addwait(FirefoxDriver d) throws InterruptedException
	{
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
	}
	
	
	

