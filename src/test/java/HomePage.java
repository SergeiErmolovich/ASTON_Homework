import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseSeleniumPage {

    @FindBy(xpath = "//section[@class='pay']/div/h2[1]")
    private WebElement header;

    @FindBy(xpath = "//img[contains(@src, 'visa-verified')]")
    private WebElement visaLogo;

    @FindBy(xpath = "//img[contains(@src, 'visa-verified')]")
    private WebElement verifiedByVisaLogo;

    @FindBy(xpath = "//img[contains(@src, 'pay/mastercard.svg')]")
    private WebElement mastercardLogo;

    @FindBy(xpath = "//img[contains(@src, 'mastercard-secure')]")
    private WebElement mastercardSecureCodeLogo;

    @FindBy(xpath = "//div[@class='pay__partners']/ul/li[4]/img")
    private WebElement belCardLogo;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement moreAboutServiceLink;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//form[@class='pay-form opened']/button[@class='button button__default ']")
    private WebElement continueButton;

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement payWindowIframe;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement sevricePlaceholder;

    @FindBy(xpath = "//p[@class='select__option'][contains(text(), 'Услуги связи')]")
    private WebElement commServices;

    @FindBy(xpath = "//p[@class='select__option'][contains(text(), 'Домашний интернет')]")
    private WebElement homeInternet;

    @FindBy(xpath = "//p[@class='select__option'][contains(text(), 'Рассрочка')]")
    private WebElement splitPayment;

    @FindBy(xpath = "//p[@class='select__option'][contains(text(), 'Задолженность')]")
    private WebElement debt;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void payPartnersLogos() {
        Assertions.assertTrue(visaLogo.isDisplayed(), "Логотип \"Visa\" не отображается");
        Assertions.assertTrue(mastercardLogo.isDisplayed(), "Логотип \"MasterCard\" не отображается");
        Assertions.assertTrue(verifiedByVisaLogo.isDisplayed(), "Логотип \"Verified By Visa\" не отображается");
        Assertions.assertTrue(mastercardSecureCodeLogo.isDisplayed(), "Логотип \"MasterCard Secure Code\" не отображается");
        Assertions.assertTrue(belCardLogo.isDisplayed(), "Логотип \"Белкарт\" не отображается");
    }

    public void onlinePaymentHeader() {
        String headerExpected = "Онлайн пополнение\nбез комиссии";
        Assertions.assertEquals(headerExpected, header.getText(), "Текст заголовка не совпадает с ожидаемым");
    }

    public void moreAboutService() {
        moreAboutServiceLink.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedMoreAboutServiceUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assertions.assertEquals(expectedMoreAboutServiceUrl, actualUrl, "Ссылка \"Подробнее о сервисе\" редиректит на неверную страницу");
        driver.get("http://mts.by");
    }

    public void serviceDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sevricePlaceholder.click();
        wait.until(ExpectedConditions.visibilityOf(homeInternet)).click();
        Assertions.assertEquals("Домашний интернет", sevricePlaceholder.getText(), "Текст опции \"Домашний интернет\" не соответствует ожидаемому");
        sevricePlaceholder.click();
        wait.until(ExpectedConditions.visibilityOf(splitPayment)).click();
        Assertions.assertEquals("Рассрочка", sevricePlaceholder.getText(), "Текст опции \"Рассрочка\" не соответствует ожидаемому");
        sevricePlaceholder.click();
        wait.until(ExpectedConditions.visibilityOf(debt)).click();
        Assertions.assertEquals("Задолженность", sevricePlaceholder.getText(), "Текст опции \"Задолженность\" не соответствует ожидаемому");
        sevricePlaceholder.click();
        wait.until(ExpectedConditions.visibilityOf(commServices)).click();
        Assertions.assertEquals("Услуги связи", sevricePlaceholder.getText(), "Текст опции \"Услуги связи\" не соответствует ожидаемому");
    }

    public void inputData(String phone, String sum) {
        phoneInput.click();
        phoneInput.sendKeys(phone);
        sumInput.click();
        sumInput.sendKeys(sum);
        continueButton.click();
        driver.switchTo().frame(payWindowIframe);
    }

}


