package home;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LogoTest {
    private WebDriver driver;

    @Test
    public void logoScooterTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String baseUrl = "https://qa-scooter.praktikum-services.ru/";
        driver.get(baseUrl);

        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.clickOnLogoScooter();

        Assert.assertEquals("Ты попал не на главную страницу", baseUrl, driver.getCurrentUrl());

        objectHomePage.clickOnOrderHead();
        objectHomePage.clickOnLogoScooter();

        Assert.assertEquals("Ты попал не наглавную страницу", baseUrl, driver.getCurrentUrl());

        objectHomePage.goToPageStatus("12344");
        objectHomePage.clickOnLogoScooter();

        Assert.assertEquals("Ты попал не наглавную страницу", baseUrl, driver.getCurrentUrl());
    }

    @Test
    public void logoYandexTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.clickOnLogoYandex();

        List tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(tabs.get(1)));

        String actual = driver.getCurrentUrl();
        String expected = "https://dzen.ru/?yredirect=true";

        Assert.assertEquals("Ты попал не наглавную страницу", expected, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
