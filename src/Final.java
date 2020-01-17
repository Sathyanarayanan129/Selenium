
import java.awt.List;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Final{
	
	 public static void takepicture(WebDriver driver,String filename) throws IOException {
		   TakesScreenshot ts = (TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source,new File("D://screenshots//"+filename+".png"));
	   }
	 public static void takepicture(WebElement driver,String filename) throws IOException {
		   TakesScreenshot ts = (TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source,new File("D://screenshots//"+filename+".png"));
	   }

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebDriver w = new ChromeDriver();
		w.get(driver.findElement(By.xpath("(//*[@class='s-image'])[4]")).getAttribute("src"));
		//driver.findElement(By.xpath("(//*[@class='s-image'])[4]")).click();
		
		//String s = driver.getCurrentUrl();
		//w.get(s);
		Actions action1 = new Actions(w);
		Thread.sleep(3000);
		takepicture(w,"img1");
		Thread.sleep(3000);
		driver.close();
		w.close();
	}

}