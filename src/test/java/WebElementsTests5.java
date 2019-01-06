import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class WebElementsTests5 {
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
    public void checkBoxButtonTest() {
        WebElement pizzaButton = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiButton = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement HamburgerButton = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(pizzaButton.isSelected());
        assertFalse(spaghettiButton.isSelected());
        assertFalse(HamburgerButton.isSelected());

        sleep();

        pizzaButton.click();
        spaghettiButton.click();
        HamburgerButton.click();

        sleep();

        assertTrue(pizzaButton.isSelected());
        assertTrue(spaghettiButton.isSelected());
        assertTrue(HamburgerButton.isSelected());

        sleep();

        pizzaButton.click();
        spaghettiButton.click();
        HamburgerButton.click();

        sleep();

        assertFalse(pizzaButton.isSelected());
        assertFalse(spaghettiButton.isSelected());
        assertFalse(HamburgerButton.isSelected());
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


