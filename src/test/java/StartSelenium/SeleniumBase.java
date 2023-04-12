package StartSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {
    public WebDriver driver;


    public void setUp(){
        //  SetUPWebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();



      // Username Element
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        //Password Element
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //login Element
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        // Boolean is UsernameDisplayed
        username.isDisplayed();

       // page title
        driver.getTitle();

        // page source
        driver.getPageSource();
        System.out.println(driver.getPageSource());

        //List of WebElement
        List<WebElement> listOfInputElements =driver.findElements(By.xpath("user-name"));
        int count = listOfInputElements.size();
        System.out.println("Count of Input elements: +count");

        // if Element is Visible
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        System.out.println("password URL is" + driver.getCurrentUrl());
















        driver.quit();







    }
/*
     public static void main(String arg[]){
        SeleniumBase testcase = new SeleniumBase();
        testcase.setUp();
        // driver Login scenario







    }

 */



}
