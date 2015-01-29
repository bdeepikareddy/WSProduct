import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class AddPdt {
	  public static void main(String[] args) throws InterruptedException {
		  
		  	FirefoxDriver driver = new FirefoxDriver();
    //Wait for page to load
		  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    //Go to the url
		  	driver.get("http://williams-sonoma.com");
    //Maximize the window
		  	driver.manage().window().maximize();
    //Close Pop up window
		  	driver.findElement(By.id("ad_email_btn-close")).click();
	// Hover on category and click on subcategory
		  	Actions action = new Actions(driver);
		  	WebElement menu = driver.findElement(By.xpath("//html/body/header/nav/ul/li[1]/a"));
		  	Thread.sleep(2000);
		  	WebElement subMenu = driver.findElement(By.xpath("//html/body/header/nav/ul/li[1]/div/div[1]/ul[1]/li[1]/a"));
		  	action.moveToElement(menu).perform();
		  	Thread.sleep(2000);
		  	action.click(subMenu).perform(); 

	// Select product to add cart
		  	driver.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li[1]/div[1]/a[1]/span/img")).click();
    
    //Assert Add to cart Buttons is Present

		  	boolean AddToCartButton = isElementPresent("/html/body/div[2]/div[1]/div[7]/div[2]/div/section/div/div/fieldset[1]/button", driver);
		  	Assert.assertTrue(AddToCartButton, "Add to cart Button not found");
		  	WebElement addtoCartButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[7]/div[2]/div/section/div/div/fieldset[1]/button"));
		  	addtoCartButton.click();
		  	driver.findElement(By.xpath("//a[@id='anchor-btn-checkout']")).click();
   
   //Validates if Product is present in the shopping cart
		  	driver.findElement(By.xpath("//a[contains(.,'All-Clad d5 Stainless-Steel 10-Piece Cookware Set')]"));
		  	driver.quit();

    }
	  
	  public static boolean isElementPresent(String element_xpath,WebDriver dr) throws InterruptedException{
	        Thread.sleep(3000);
	        int count = dr.findElements(By.xpath(element_xpath)).size();
	        System.out.println("Entered boolean method" +count);
	        if(count == 0)
	            return false;
	        else
	            return true; 
	  }
}



     

