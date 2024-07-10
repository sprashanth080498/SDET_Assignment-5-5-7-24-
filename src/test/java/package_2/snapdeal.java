package package_2;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {
	WebDriver driver;
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();	
	}
	@Test
	public void tc1() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementByID("#inputValEnter").value='books';");
	}
}
