package test1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonStepDef {
	WebDriver driver;


	@Given("Login to amazon website {string}")
	public void login_to_amazon_website(String url) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}
	@When("Scroll down to bottom of the page")
	public void scroll_down_to_bottom_of_the_page() throws InterruptedException   {
		
		Thread.sleep(5000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("(document.getElementsByClassName('navFooterColHead'))[0].scrollIntoView();");
		
		
	    
	}
	@Then("Mandatory links should exists")
	public void mandatory_links_should_exists(io.cucumber.datatable.DataTable dataTable) {
		
		List<WebElement> ele=driver.findElements(By.xpath("//div[text()='Get to Know Us']/following-sibling::ul/li/a"));
		List<String> linkNames=new ArrayList<>();
		for(int i=0;i<ele.size();i++) {
			linkNames.add(ele.get(i).getText().trim());
		}
		System.out.println(linkNames);
	 int counter=0;
		List<Map<String, String>> links = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> link:links) {
			
			System.out.println(link.get("Links"));
			Assert.assertEquals(link.get("Links"), linkNames.get(counter));
			counter++;
			
		}
		
		driver.quit();
		
		
	}




}
