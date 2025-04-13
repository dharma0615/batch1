package test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class FacebookTest {

	@Test
	public void Test1() {

		System.out.println("userName is :" + "Dahrma");

	}

	@Test
	public void loginTest() throws InterruptedException {

		List<String> arrList = new ArrayList<>();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");

		org.openqa.selenium.WebDriver driver = new ChromeDriver(options);
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('countries').scrollIntoView();");

		int counter = 0;

		List<WebElement> list = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));
		for (int i = 2; i < list.size(); i++) {
			counter++;
			try {
				WebElement ele = driver
						.findElement(By.xpath("(//table[@id='countries']/tbody/tr)[" + i + "]/td[2]/strong"));
				js.executeScript("window.scrollBy(0,100)");
				arrList.add(ele.getText().trim());
			} catch (NoSuchElementException e) {
				WebElement ele = driver.findElement(By.xpath("(//table[@id='countries']/tbody/tr)[" + i + "]/td[2]"));
				js.executeScript("window.scrollBy(0,100)");
				arrList.add(ele.getText().trim());
			}
			if (list.size() == counter) {
				break;
			}
		}

		System.out.println(arrList);
		Thread.sleep(5000);
		driver.quit();

	}

}
