package BasePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {

	public static WebDriver driver;

	public void open_browser(String objectValue) {
		System.setProperty("webdriver.chrome.driver", Constants.chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void navigate_to_page(String objectValue) {
		driver.get(Constants.baseUrl);
	}

	public void enter_username(String objectValue) throws IOException {
		driver.findElement(By.xpath(ReadObjectRepo.getObjectRepo().getProperty(objectValue)))
				.sendKeys(Constants.username);
	}

	public void enter_password(String objectValue) throws IOException {
		driver.findElement(By.xpath(ReadObjectRepo.getObjectRepo().getProperty(objectValue)))
				.sendKeys(Constants.password);
	}

	public void click_login(String objectValue) throws IOException {
		driver.findElement(By.xpath(ReadObjectRepo.getObjectRepo().getProperty(objectValue))).click();
	}

	public void click_logout(String objectValue) throws InterruptedException, IOException {
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(ReadObjectRepo.getObjectRepo().getProperty(objectValue))).click();
	}

	public void close_browser(String objectValue) {
		driver.close();
	}

}
