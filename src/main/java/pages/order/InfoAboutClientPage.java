package pages.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TemplatePage;

public class InfoAboutClientPage extends TemplatePage {

    private By firstNameInput = new By.ByXPath(".//input[@placeholder='* Имя']"); //имя
    private By firstNameErrorMsg = new By.ByXPath(".//div[text()='Введите корректное имя']");//ошибка для поля "Имя"
    private By lastNameInput = new By.ByXPath(".//input[@placeholder='* Фамилия']"); //фамилия
    private By lastNameErrorMsg = new By.ByXPath(".//div[text()='Введите корректную фамилию']");//ошибка для поля "Фамилия"
    private By addressInput = new By.ByXPath(".//input[@placeholder='* Адрес: куда привезти заказ']"); //адрес
    private By addressErrorMsg = new By.ByXPath(".//div[text()='Введите корректный адрес']");//ошибка для поля "Адрес"
    private By metroInput = new By.ByXPath(".//input[@placeholder='* Станция метро']"); //метро
    private By metroErrorMsg = new By.ByXPath(".//div[text()='Выберите станцию']");//ошибка для поля "Метро"
    private By phoneInput = new By.ByXPath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //телефон
    private By phoneErrorMsg = new By.ByXPath(".//div[text()='Введите корректный номер']");//ошибка для поля "Телефон"
    private By nextButton = new By.ByClassName("Button_Middle__1CSJM"); //кнопка "Далее"

    public InfoAboutClientPage(WebDriver driver) {
        super(driver);
    }

    public void selectMetroStation(String stationsName) { //выбор станции метро
        clickOnAndEnter(metroInput, stationsName);
        driver.findElement(By.xpath(".//button/div[text()='" + stationsName + "']")).click();
    }

    public void clickOnNext() { //клик "Далее"
        clickOn(nextButton);
    }

    public void fillFormClient(String firstName, String lastName, String address, String stationsName, String phone) {  //заполнение формы
        clickOnAndEnter(firstNameInput, firstName);
        clickOnAndEnter(lastNameInput, lastName);
        clickOnAndEnter(addressInput, address);
        selectMetroStation(stationsName);
        clickOnAndEnter(phoneInput, phone);
    }

    public String getTextFirstNameError() { //получить текст ошибки поля "Имя"
        return getTextElement(firstNameErrorMsg);
    }

    public String getTextLastNameError() { //получить текст ошибки поля "Фамилия"
        return getTextElement(lastNameErrorMsg);
    }

    public String getTextAddressError() { //получить текст ошибки поля "Адрес"
        return getTextElement(addressErrorMsg);
    }

    public String getTextMetroError() { //получить текст ошибки поля "Станция метро"
        return getTextElement(metroErrorMsg);
    }

    public String getTextPhoneError() { //получить текст ошибки поля "Телефона"
        return getTextElement(phoneErrorMsg);
    }

    private String getTextElement(By locator) { //получить текст элемента
        return driver.findElement(locator).getText();
    }
}
