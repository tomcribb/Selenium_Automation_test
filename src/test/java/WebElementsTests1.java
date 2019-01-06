import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class WebElementsTests1 {
    private WebDriver driver;
    private String baseUrl = "http://przyklady.javastart.pl/test/full_form.html";

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

        @Test
        public void checkIfElementsOnPageTest(){

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

            System.out.println("Is username displayed: " + userName.isDisplayed());
            System.out.println("Is username enabled: " + userName.isEnabled());

            System.out.println("Is password displayed: " + password.isDisplayed());
            System.out.println("Is password enabled: " + password.isEnabled());

            System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
            System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

            assertTrue(userName.isDisplayed());
            assertTrue(password.isDisplayed());
            assertTrue(emailLabel.isDisplayed());

            assertTrue(userName.isEnabled());
            assertFalse(password.isEnabled());

        }
    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }


    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}


