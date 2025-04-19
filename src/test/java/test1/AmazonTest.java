package test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public final class AmazonTest {
	
	@Test
	public void Test1() {
		
		System.out.println("userName is :"+ "Dahrma");
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		List<String> arrList=new ArrayList<>();
		
		org.openqa.selenium.WebDriver driver=new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('countries').scrollIntoView();");
		
		int counter=0;
		
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));
		for(int i=2;i<list.size();i++) {
			counter++;
			try {
			WebElement ele=driver.findElement(By.xpath("(//table[@id='countries']/tbody/tr)["+i+"]/td[2]/strong"));
			js.executeScript("window.scrollBy(0,100)");
			arrList.add(ele.getText().trim());
			}
			catch(NoSuchElementException e) {
				WebElement ele=driver.findElement(By.xpath("(//table[@id='countries']/tbody/tr)["+i+"]/td[2]"));
				js.executeScript("window.scrollBy(0,100)");
				arrList.add(ele.getText().trim());
			}
			if(list.size()==counter) {
				break;
			}
		}
		
		System.out.println(arrList);
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void actionsTest() throws InterruptedException {
		
		org.openqa.selenium.WebDriver driver=new ChromeDriver();
		driver.get("https://www.browserstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions=new Actions(driver);
		WebElement ProductElement= driver.findElement(By.xpath("//button[contains(normalize-space(text()),'Products')]"));
		actions.moveToElement(ProductElement).perform();;
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Automate']")));
		ele.click();
		boolean flag=driver.findElement(By.xpath("//a[contains(text(),' Get Started Free ')]")).isDisplayed();
		if (flag==true) {
			System.out.println("Page navigated to Automate succesfully");
		}
		driver.quit();
		
		
		
				
		
		
	}

}
