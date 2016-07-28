package github;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import gmail.Tictoeadvance;

public class github {

	public static void main(String[] args) throws InterruptedException, IOException {
		   opencmd();
		FirefoxDriver d=new FirefoxDriver();
		d.get("https://github.com/");
		d.findElementByLinkText("Sign in").click();
		Tictoeadvance.addwait(d, 20);
		d.findElementById("login_field").sendKeys("aakashsharm");
		d.findElementById("password").sendKeys("A123456a");;
		d.findElementByName("commit").click();
	//create(d);

		
	}
	public static WebDriver create(WebDriver d)
	{
		d.findElement(By.partialLinkText("New repository")).click();
		d.findElement(By.id("repository_name")).sendKeys("BB");
		d.findElement(By.xpath("//button[@class='btn btn-primary first-in-line']")).click();
	String newrep= d.findElement(By.xpath("//input[@class='form-control js-git-clone-help-field url-field js-zeroclipboard-target']")).getAttribute("value");
	System.out.println(newrep);
	System.out.println(d.getCurrentUrl());
	String source=d.getCurrentUrl()+".git";
	if(source.equalsIgnoreCase(newrep))
	{
		System.out.println("created rep having name"+newrep);
	}
	else
	{
		System.out.println("went wrong");
	}
		return d;
	}
	
	public static void opencmd() throws IOException
	
	{
		Runtime rt = Runtime.getRuntime();
	
		 InputStream input=	rt.exec(new String[]{"cmd.exe","/c","start","C:/Users/aakashsharma/Desktop/automation/github/command.bat/"}).getInputStream();
		 String s="";
		 BufferedInputStream buffer = new BufferedInputStream(input);
	        BufferedReader commandResult = new BufferedReader(new InputStreamReader(buffer));
	        String line = null;
	        try {
	            while ((line = commandResult.readLine()) != null) {
	                 s = line + "\n";
	                 System.out.println(line);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	
	
}
