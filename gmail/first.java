package gmail;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class first extends Tictoeadvance{

	public static void main(String[] args) {
		
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://docs.seleniumhq.org/");
		List<WebElement> links= driver.findElements(By.tagName("a"));
	  	System.out.println(links.size());
	    int sizee=links.size();
	  /*	for(WebElement link : links)
		{
			
	  System.out.println(link.getText());
		}
		*/
	  	
	  	for(int y=0;y<sizee;y++)
	  	{
	  		
	  String s=	links.get(y).getText();
	  System.out.println( s);;
	
	  	};
	replace();
	}
	public static void replace() {
		String str = "I use selenium webdriver. selenium is a tool for web applications automation.";
		String toBeReplaced = "selenium";
		String toReplacedWith = "Firefox";
		String[] astr = str.split(toBeReplaced);
		StringBuffer strb = new StringBuffer();
		for ( int i = 0; i <= astr.length - 1; i++ ) {
		strb = strb.append( astr[i] );
		if (i != astr.length - 1) {
		strb = strb.append(toReplacedWith);
		}
		}
		System.out.println(strb);

		}


}
