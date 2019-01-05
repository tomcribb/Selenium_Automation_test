import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SecondAutomatedTest {


        private WebDriver driver;
        private String baseUrl;

        @BeforeMethod
        public void beforeTest() {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void mySecondTest() {

       driver.navigate().to("http://www.seleniumhq.org/");
        String pageTitle1 = driver.getTitle();
        assertTrue(pageTitle1.equals("Selenium - Web Browser Automation"));
        System.out.println(pageTitle1);
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
        driver.findElement(By.xpath("//a[contains(text(),'?')]")).click();

    }



    @AfterMethod
    public void tearDown() {
       driver.close();
        driver.quit();

    }
}
/*
1. //img[@src='../images/logo-topbar.gif']
2. By.name("img_cart")
3. //a[contains(text(),'Sign In')]
4. //a[contains(text(),'?')]
5. By.name("keyword")
6. By.name("searchProducts")
        7. //img[@src='../images/sm_fish.gif']
        8. //img[@src='../images/sm_dogs.gif']
        9. //img[@src='../images/sm_reptiles.gif']
        10. //img[@src='../images/sm_cats.gif']
        11. //img[@src='../images/sm_birds.gif']
12. //img[@src='../images/fish_icon.gif']
13.//img[@src='../images/dogs_icon.gif']
14. //img[@src='../images/cats_icon.gif']
15. //img[@src='../images/reptiles_icon.gif']
16. //img[@src='../images/birds_icon.gif']
17. //img[@height='355']
18. //a[contains(text(),'www.mybatis.org')]
*/