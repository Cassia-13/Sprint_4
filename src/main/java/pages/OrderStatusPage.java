package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderStatusPage extends TemplatePage {

    private By notFoundImage = new By.ByXPath(".//img[@alt='Not found']"); //изибращение ошибки

    public OrderStatusPage(WebDriver driver) {
        super(driver);
    }

    public boolean notFoundImageIsVisible() { //проверка отображения изображения
        return new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundImage)).isDisplayed();
    }
}
