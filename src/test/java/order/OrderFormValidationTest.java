package order;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.order.InfoAboutClientPage;

import java.util.concurrent.TimeUnit;

public class OrderFormValidationTest {
    private WebDriver driver;

    @Test
    public void clientFormErrorMsgTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");

        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.acceptCookieIfVisible();
        objectHomePage.clickOnOrderHead();

        InfoAboutClientPage objectInfoAboutClientPage = new InfoAboutClientPage(driver);
        objectInfoAboutClientPage.clickOnNext();

        Assert.assertEquals("Ошибка неверно введенного имени некорректна", objectInfoAboutClientPage.getTextFirstNameError(), "Введите корректное имя");
        Assert.assertEquals("Ошибка неверно введенной фамилии некорректна", objectInfoAboutClientPage.getTextLastNameError(), "Введите корректную фамилию");
        // Тут баг, тест падает. Не отображается ошибка валидации у поля адрес
        Assert.assertEquals("Ошибка неверно введенного адреса некорректна", objectInfoAboutClientPage.getTextAddressError(), "Введите корректный адрес");
        Assert.assertEquals("Ошибка неверно введенного метро некорректна", objectInfoAboutClientPage.getTextMetroError(), "Выберите станцию");
        Assert.assertEquals("Ошибка неверно введенного номера телефона некорректна", objectInfoAboutClientPage.getTextPhoneError(), "Введите корректный номер");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
