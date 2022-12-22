package pages.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TemplatePage;

public class AboutRentPage extends TemplatePage {

    private By date = new By.ByXPath(".//input[@placeholder='* Когда привезти самокат']"); //дата
    private By termRent = new By.ByClassName("Dropdown-arrow"); //срок аренды
    private By colorBlackPearl = new By.ById("black"); //чекбокс "Чёрный жемчуг"
    private By colorGrayHopelessness = new By.ById("grey"); //чекбокс серый "Серая безысходность"
    private By comment = new By.ByXPath(".//input[@placeholder='Комментарий для курьера']"); //комментарий
    private By buttonOrder = new By.ByXPath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"); //кнопка в модальном окне "Заказать"
    private By buttonYesModal = new By.ByXPath(".//button[text()='Да']"); //кнопка в модальном окне "Да"
    private By orderProcessed = new By.ByXPath(".//div[text()='Заказ оформлен']"); //заголовок "Заказ оформлен"

    public AboutRentPage(WebDriver driver) {
        super(driver);
    }

    private void selectTermRent(String term) { //выбрать срок аренды
        clickOn(termRent);
        driver.findElement(new By.ByXPath(".//div[@class='Dropdown-option' and text()='" + term + "']")).click();
    }

    public void selectColorScooter(String colorScooter) { //выбор цвета самоката
        if (colorScooter.equals("чёрный жемчуг")) {
            clickOn(colorBlackPearl);
        } else {
            clickOn(colorGrayHopelessness);
        }
    }

    public void clickOnOrder() { //кликнуть "Заказать"
        clickOn(buttonOrder);
    } //клик "Заказать"

    public void fillFormAboutRent(String newDate, String term, String colorScooter, String newComment) { //заполнене формы "Об аренде"
        clickOnAndEnter(date, newDate);
        selectTermRent(term);
        selectColorScooter(colorScooter);
        clickOnAndEnter(comment, newComment);

    }

    public void clickOnYesInModal() { //нажать "Да" в модальном окне
        clickOn(buttonYesModal);
    } //клик "Да" в модальном окне

    public boolean isDisplayed() {
        return driver.findElement(orderProcessed).isDisplayed();
    } //проверка видимости заголовка "Заказа оформлен"
}
