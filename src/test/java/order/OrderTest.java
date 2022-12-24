package order;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.order.AboutRentPage;
import pages.order.InfoAboutClientPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String stationsName;
    private final String phoneNumber;
    private final String date;
    private final String term;
    private final String colorScooter;
    private final String comment;

    private WebDriver driver;

    public OrderTest(String firstName, String lastName, String address, String stationsName, String phoneNumber, String date, String term, String colorScooter, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.stationsName = stationsName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.term = term;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Имя: {0}, фамилия: {1}, адрес: {2}, метро: {3}, телефон: {4}, когда: {5}, на сколько: {6}, цвет: {7}, коментарий: {8}")
    public static Object[][] getInformation() {
        return new Object[][]{
                {"Антон", "Сломов", "Смоленская, 9", "Первомайская", "890012312323", "01.01.2023", "сутки", "чёрный жемчуг", "жду в 19:00"},
                {"Елена", "Викантова", "Папова, 67", "Беляево", "890012312329", "31.12.2022", "семеро суток", "серая безысходность", "позвоните передоставкой"},
        };
    }


    @Test
    public void createOrderHeaderChromeTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.acceptCookieIfVisible();
        objectHomePage.clickOnOrderHead();

        InfoAboutClientPage objectInfoAboutClientPage = new InfoAboutClientPage(driver);
        objectInfoAboutClientPage.fillFormClient(firstName, lastName, address, stationsName, phoneNumber);
        objectInfoAboutClientPage.clickOnNext();

        AboutRentPage objectAboutRentPage = new AboutRentPage(driver);
        objectAboutRentPage.fillFormAboutRent(date, term, colorScooter, comment);
        objectAboutRentPage.clickOnOrder();
        objectAboutRentPage.clickOnYesInModal();

        assertTrue("Окно с сообщением об успешном создании заказе не появилось", objectAboutRentPage.isDisplayed());
    }

    @Test
    public void createOrderLandingFirefoxTest() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.acceptCookieIfVisible();
        objectHomePage.clickOnOrderLanding();

        InfoAboutClientPage objectInfoAboutClientPage = new InfoAboutClientPage(driver);
        objectInfoAboutClientPage.fillFormClient(firstName, lastName, address, stationsName, phoneNumber);
        objectInfoAboutClientPage.clickOnNext();

        AboutRentPage objectAboutRentPage = new AboutRentPage(driver);
        objectAboutRentPage.fillFormAboutRent(date, term, colorScooter, comment);
        objectAboutRentPage.clickOnOrder();
        objectAboutRentPage.clickOnYesInModal();

        Assert.assertTrue("Окно с сообщением об успешном создании заказе не появилось", objectAboutRentPage.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
