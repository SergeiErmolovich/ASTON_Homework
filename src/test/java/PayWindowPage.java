import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayWindowPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class='pay-description__cost']/span[1]")
    private WebElement costDescription;

    @FindBy(css = "button.colored")
    private WebElement costDescriptionButton;

    @FindBy(xpath = "//div[@class='pay-description__text']/span[1]")
    private WebElement phoneDescription;

    @FindBy(xpath = "//label[@class='ng-tns-c46-1 ng-star-inserted']")
    private WebElement cardNumberPlaceholder;

    @FindBy(xpath = "//label[@class='ng-tns-c46-4 ng-star-inserted']")
    private WebElement cardExpirationPlaceholder;

    @FindBy(xpath = "//label[@class='ng-tns-c46-5 ng-star-inserted']")
    private WebElement cvcPlaceholder;

    @FindBy(xpath = "//label[@class='ng-tns-c46-3 ng-star-inserted']")
    private WebElement namePlaceholder;

    @FindBy(xpath = "//button[@aria-label='Google Pay']")
    private WebElement googlePayButton;

    @FindBy(xpath = "//button[@aria-label='Yandex Pay']")
    private WebElement yandexPayButton;

    @FindBy(xpath = "//img[contains(@src, 'visa-system')]")
    private WebElement visaLogo;

    @FindBy(xpath = "//img[contains(@src, 'mastercard-system')]")
    private WebElement mastercardLogo;

    @FindBy(xpath = "//img[contains(@src, 'belkart-system')]")
    private WebElement belCardLogo;

    @FindBy(xpath = "//img[contains(@src, 'maestro')]")
    private WebElement maestroLogo;


    @FindBy(xpath = "//img[contains(@src, 'mir-system')]")
    private WebElement mirSystemLogo;

    @FindBy(css = "svg-icon.header__close-icon")
    private WebElement closeIcon;

    public void payWindowInfo(String phone, String sum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assertions.assertEquals("Оплата: Услуги связи Номер:375" + phone, phoneDescription.getText(), "Описание введенного номера не соответствует ожидаемому");
        Assertions.assertEquals(sum + ".00 BYN", costDescription.getText(), "Описание введенной суммы не соответствует ожидаемому");
        Assertions.assertEquals("Оплатить " + sum + ".00 BYN", costDescriptionButton.getText(), "Описание введенной суммы на кнопке не соответствует ожидаемому");
        Assertions.assertEquals("Номер карты", cardNumberPlaceholder.getText(), "Текст плейсхолдера \"Номер карты\" не соответствует ожидаемому");
        Assertions.assertEquals("Срок действия", cardExpirationPlaceholder.getText(), "Текст плейсхолдера \"Срок действия\" не соответствует ожидаемому");
        Assertions.assertEquals("CVC", cvcPlaceholder.getText(), "Текст плейсхолдера \"CVC\" не соответствует ожидаемому");
        Assertions.assertEquals("Имя держателя (как на карте)", namePlaceholder.getText(), "Текст плейсхолдера \"Имя держателя\" не соответствует ожидаемому");
        Assertions.assertTrue(googlePayButton.isDisplayed(), "Кнопка GooglePay не отображается");
        Assertions.assertTrue(yandexPayButton.isDisplayed(), "Кнопка YandexPay не отображается");
        Assertions.assertTrue(visaLogo.isDisplayed(), "Логотип \"Visa\" не отображается");
        Assertions.assertTrue(mastercardLogo.isDisplayed(), "Логотип \"MasterCard\" не отображается");
        Assertions.assertTrue(belCardLogo.isDisplayed(), "Логотип \"Белкарт\" не отображается");
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOf(maestroLogo)).isDisplayed(), "Логотип \"Maestro\" не отображается");
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOf(mirSystemLogo)).isDisplayed(), "Логотип \"МИР\" не отображается");
        closeIcon.click();
        driver.switchTo().defaultContent();
    }

    public PayWindowPage() {
        PageFactory.initElements(driver, this);
    }
}
