package Package_1;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll_tests {
	WebDriver driver;
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void tc1() {
		driver.findElement(By.id("gh-ac")).sendKeys("Shoes");
		driver.findElement(By.id("gh-btn")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0,0);");	
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("gh-ac")).clear();
	}
}
