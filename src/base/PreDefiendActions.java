package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PreDefiendActions {
	
	private WebDriver driver;		
	public void start() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.makemytrip.com/");
		}
	
	public void stop() {
		driver.quit();
	}
	
	private WebElement getElement(String path) {
		 return driver.findElement(By.xpath(path));
	}
	
	public void clickAction(String path) {
		getElement(path).click();
		
	}

}
