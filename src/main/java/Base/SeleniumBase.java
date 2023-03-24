package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumBase {
    public WebDriver driver;


    public void setUp(){
        //  SetUPWebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.themoviedb.org/");
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.quit();







    }

    public static void main(String arg[]){
        SeleniumBase testcase = new SeleniumBase();
        testcase.setUp();
    }



}
