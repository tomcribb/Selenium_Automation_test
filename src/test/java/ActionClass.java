import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ActionClass {
    private WebDriver driver;
    private String baseUrl = "http://przyklady.javastart.pl/test/hover_mouse.html";

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void actionClassTest(){
        WebElement smileyIcon = driver.findElement(By.id("smiley"));
        sleep();
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));
        Actions action = new Actions(driver);
        action.moveToElement(smileyIcon).moveToElement(smileyIcon2).build().perform();

    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}
    @AfterTest
    public void afterMethod(){
        driver.close();
        driver.quit();
    }

}
