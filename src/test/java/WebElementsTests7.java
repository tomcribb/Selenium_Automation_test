import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class WebElementsTests7 {
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
    public void selectingOptionsFromDropDownTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        sleep();
        countryDropDown.selectByIndex(1);
        sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");
        sleep();
        countryDropDown.selectByValue("de_DE");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");
        sleep();
        countryDropDown.selectByVisibleText("UK");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");
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


