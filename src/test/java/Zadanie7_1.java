import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Zadanie7_1 {
    private WebDriver driver;
    private String baseUrl = "http://theinternet.przyklady.javastart.pl/checkboxes";

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
public void checkboxesTest() {
    WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
    WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]"));
    assertFalse(checkbox1.isSelected());
    assertTrue(checkbox2.isSelected());
    sleep();
    checkbox1.click();
    checkbox2.click();
    sleep();

    assertFalse(checkbox2.isSelected());
    assertTrue(checkbox1.isSelected());
}

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
@AfterTest
        public void afterMethod(){
            driver.close();
            driver.quit();
        }
    }

