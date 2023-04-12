package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumBaseTest {

    public WebDriver driver;



    @Test(testName = "Multiple elements locations")
    public void MultipleElements(){
        // Setting options of browsers How is used.
        ChromeOptions options =  new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(caps);

        // Setup Webdriver Manger
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        // Open Test Application URL
        driver.get("https://automationintesting.online/"); // this is the application e are testing against
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        // we are getting the number of links on the current page adn storing it on the varible
        List<WebElement> multipleLink =  driver.findElements(By.tagName("a"));
        int getMyLinkSize =  multipleLink.size();
        System.out.println("Print number of links on the page we are on"  + "   " + getMyLinkSize);

        // get and list all the images on the application under test
        List<WebElement> images = driver.findElements(By.tagName("img"));
        int countImageNumber = images.size();
        System.out.println("Number og images on my page"  + "  " + countImageNumber);


            /*
                1, find elements using driver  by id, linkText, name, cssLocator, class xpath or relevant locators
                2. Assign them to variable
                3. perform action on the elements e.g send a text or click or enable
                4 you can get values from them
                5. perform assertion on them
                6.second url for testing http://formy-project.herokuapp.com/form
             */
         String value = "run";
        WebElement nameVar =  driver.findElement(By.id("name")); // pattern
        nameVar.clear();
        nameVar.sendKeys(value);
        String currentValueInName = nameVar.getText();
        System.out.println("The value l just entered" +  " "  + currentValueInName);

        //Assert.assertEquals(currentValueInName,value);
        System.out.println("The enetered value" +currentValueInName);

        WebElement emailVar = driver.findElement(By.id("email"));
        emailVar.clear();
        emailVar.sendKeys("sussanobasi86@gmail.com");
        String currentValueInEmail = emailVar.getText();
        System.out.println("The value l just enetered" + "" + currentValueInEmail);

        WebElement phoneVar = driver.findElement(By.id("phone"));
        phoneVar.clear();
        phoneVar.sendKeys("07314427267");
        String currentValueInPhone = emailVar.getText();
        System.out.println("The value l just enetered" + "" + currentValueInEmail);

        WebElement subjectVar = driver.findElement(By.id("subject"));
        subjectVar.clear();
        subjectVar.sendKeys("booking");
        String currentValueInSubject = subjectVar.getText();
        System.out.println("The value l just enetered" + "" + currentValueInEmail);

        WebElement messageVar = driver.findElement(By.id("description"));
        messageVar.clear();
        messageVar.sendKeys("l can't get my booking");
        String currentValueInMessage = subjectVar.getText();
        System.out.println("The value l just enetered" + "" + currentValueInEmail);

        WebElement submitVar = driver.findElement(By.id("submitContact"));
        submitVar.click();












































        driver.quit();
    }







}
