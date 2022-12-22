package order;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.OrderStatusPage;

import java.util.concurrent.TimeUnit;

public class CheckStatusTest {
    private WebDriver driver;

    @Test
    public void checkStatusErrorTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.goToPageStatus("1233");

        OrderStatusPage objectOrderStatusPage = new OrderStatusPage(driver);

        Assert.assertTrue("Картинка с отсутствием заказа не отображается", objectOrderStatusPage.notFoundImageIsVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
