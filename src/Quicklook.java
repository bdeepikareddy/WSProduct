import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Quicklook {
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
       
    //input product in search box
         driver.findElement(By.xpath("//html/body/header/div[5]/form/input[1]")).sendKeys("Fry pan\n");  
         Actions action = new Actions(driver);
    //hover product image to quick look button
         WebElement item = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/a[1]/span/img"));
         Thread.sleep(1000);
         WebElement quicklook = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/a[2]/span"));
         action.moveToElement(item).perform();
         Thread.sleep(2000);
         action.click(quicklook).perform();  
         
      
         
    //Productname comparision between overlay and quicklook page
        String prdname=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/a/span")).getText();
        String qcklookname=driver.findElement(By.xpath("//html/body/div[6]/div/div/div/div[2]/div/h1")).getText();
        
    //Product Name not matched string
    //  String prdname=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/a/span")).getText();
        //Price comparision between overlay and quicklook page
        String prdprice=driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/span/span[2]/span[2]/span[2]")).getText();
        String qcklookprice=driver.findElement(By.xpath("//html/body/div[6]/div/div/div/div[2]/div/div[4]/ul[2]/li[1]/div/section/section/div/div/div/div[2]/span/span[2]/span[2]/span[2]")).getText();
     //   System.out.println("Price is " +prdprice +" "+qcklookprice);
      
        
  
         //Display the output
         if(prdname.equals(qcklookname))
         	{
        	 System.out.println("Product Name matched");
         	}
         else
         {
        	 System.out.println("Product Name not matched");
         }
         
         if(prdprice.equals(qcklookprice))
         {
          System.out.println("Price matched");
         }
    else
    {
          System.out.println("Price not matched");
    }
    driver.quit();
    }
}
