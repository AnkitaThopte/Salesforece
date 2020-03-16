package SalesforceSystemTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Supporters {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ankita\\Downloads\\New chrome\\chromedriver(1).exe");

        WebDriver driver =  new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=in");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("bheemk@oxfam.org.au.sprint6dev");
        driver.findElement(By.id("password")).sendKeys("Oxfam@123");
        driver.findElement(By.id("Login")).click();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@data-id='Contact']")).click();


        driver.findElement(By.xpath("//*[@title='Select List View']")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        //Select s =new Select (driver.findElement(By.xpath("//*[@title='Select List View']")));
        driver.findElement(By.xpath("//*[text()='All Contacts']")).click();
        //s.selectByIndex(-1);
         driver.findElement(By.name("Contact-search-input")).sendKeys("David Bear ");
         driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.name("Contact-search-input")).sendKeys(Keys.ENTER);
        //Contact-search-input
        //driver.findElement(By.xpath("//*[@data-recordid='0030l00000T5mOqAAJ'] ")).click();
    }

}
