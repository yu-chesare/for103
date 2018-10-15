import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InitialClass {

    public static WebDriver driver;

    @BeforeMethod
    public void start(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.103.by/");
    }

    @AfterMethod
    public void finish(){
        driver.quit();
    }

    @Test
    public void getSearchContent(){
        driver.findElement(By.xpath("//div[@class='Search__inputWrapper']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'Search--inModal')]//div[contains(@class,'Search__inputWrapper')]/input")).sendKeys("парацетамол\n");
        Assert.assertTrue(driver.findElement(By.className("SearchResults")).findElements(By.className("SearchResults__item--rubric")).size()>0, "Contents found");
        for (WebElement s: driver.findElements(By.className("SearchResults__item--rubric"))){
            System.out.println(s.getText());
        }
    }


//    public static void main(String[] args) {
//        driver.get("https://www.103.by/");
//        driver.findElement(By.xpath("//div[@class='Search__inputWrapper']")).click();
//        driver.findElement(By.xpath("//div[contains(@class,'Search--inModal')]//div[contains(@class,'Search__inputWrapper')]/input")).sendKeys("парацетамол\n");
////        driver.findElement(By.xpath("//*[text()='Искать в аптеках']")).click();
//
//        driver.findElement(By.className("SearchResults")).findElements(By.className("SearchResults__item--rubric")).size();
//    }

}
