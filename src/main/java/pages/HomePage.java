package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends TemplatePage {

    private By answer = new By.ByClassName("accordion__panel"); //ответ на вопрос
    private By orderHeaderButton = new By.ByXPath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']"); //кнопка "Заказать" в заголовке
    private By orderLandingButton = new By.ByXPath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"); //кнопка "Заказать" ниже на стронице
    private By footerCookie = new By.ByClassName("App_CookieConsent__1yUIN"); //футер с куками
    private By acceptCookieButton = new By.ByClassName("App_CookieButton__3cvqF"); //кнопка принять куки
    private By statusOrder = new By.ByClassName("Header_Link__1TAG7"); //кнопка "Статус заказа"
    private By goButton = new By.ByXPath(".//button[text()='Go!']"); //кнопка "Go"
    private By orderNumberInput = new By.ByXPath(".//input[@placeholder='Введите номер заказа']"); //поле ввода номера заказа
    private By logoYandexButton = new By.ByXPath(".//img[@alt='Yandex']"); //лого "Яндекс"
    private By logoScooterButton = new By.ByClassName("Header_LogoScooter__3lsAR"); //лого "Самокат"

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By locatorQuestion(String question) { //опредиление локатора вопроса
        return new By.ByXPath(".//div[@class='accordion__button' and text()='" + question + "']");
    }

    public void selectQuestion(String question) { //прокрутить и выбрать вопрос
        By locator = locatorQuestion(question);
        scrollToElement(locator);
        clickOn(locator);
    }

    public String answerGetText() { // получить отображаемый ответ + взять его текст
        return driver.findElements(answer).stream()
                .filter(answer -> answer.isDisplayed())
                .findFirst().get().getText();
    }

    public void clickOnOrderHead() { //кнопка "Заказать" из заголовка
        clickOn(orderHeaderButton);
    }

    public void clickOnOrderLanding() { //кнопка "Заказать" из лейдинга
        scrollToElement(orderLandingButton);
        clickOn(orderLandingButton);
    }

    public void acceptCookieIfVisible() { // прянять куки, если появился футер
        if (driver.findElement(footerCookie).isDisplayed()) {
            clickOn(acceptCookieButton);
        }
    }

    public void goToPageStatus(String numberStatus) { //переход на страницу статуса
        clickOn(statusOrder);
        clickOnAndEnter(orderNumberInput, numberStatus);
        clickOn(goButton);
    }

    public void clickOnLogoScooter() { //клик по лого "Самокат"
        clickOn(logoScooterButton);
    }

    public void clickOnLogoYandex() { //клик по лого "Яндекс"
        clickOn(logoYandexButton);
    }
}