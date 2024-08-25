import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinePaymentTest {
    private static WebDriver driver;
    private static final By COOKIE_MESSAGE_PATH = By.xpath("//div[@class='cookie__wrapper']");
    private static final By ACCEPT_COOKIES_BUTTON_PATH = By.xpath("//button[@class='btn btn_black cookie__ok']");
    private final By headerActualPath = By.xpath("//section[@class='pay']/div/h2[1]");
    private final By visaLogoPath = By.xpath("//img[contains(@src, 'visa-verified')]");
    private final By verifiedByVisaLogoPath = By.xpath("//img[contains(@src, 'visa-verified')]");
    private final By mastercardLogoPath = By.xpath("//img[contains(@src, 'pay/mastercard.svg')]");
    private final By mastercardSecureCodeLogoPath = By.xpath("//img[contains(@src, 'mastercard-secure')]");
    private final By belCardLogoPath = By.xpath("//div[@class='pay__partners']/ul/li[4]/img");
    private final By moreAboutServiceLinkPath = By.xpath("//a[text()='Подробнее о сервисе']");
    private final By phoneInputPath = By.xpath("//input[@placeholder='Номер телефона']");
    private final By sumInputPath = By.xpath("//input[@id='connection-sum']");
    private final By continueButtonPath = By.xpath("//form[@class='pay-form opened']/button[@class='button button__default ']");
    private final By payWindowPath = By.xpath("//div[@class='bepaid-app']");

    @BeforeAll
    public static void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://mts.by");
        acceptCookiesIfPresent(driver, COOKIE_MESSAGE_PATH, ACCEPT_COOKIES_BUTTON_PATH);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Проверка заголовка")
    public void onlinePaymentHeader() {
        String headerExpected = "Онлайн пополнение\nбез комиссии";
        String headerActual = driver.findElement(headerActualPath).getText();
        Assertions.assertEquals(headerExpected, headerActual, "Текст заголовка не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    public void payPartnersLogos() {
        WebElement visaLogo = driver.findElement(visaLogoPath);
        WebElement verifiedByVisaLogo = driver.findElement(verifiedByVisaLogoPath);
        WebElement mastercardLogo = driver.findElement(mastercardLogoPath);
        WebElement mastercardSecureCodeLogo = driver.findElement(mastercardSecureCodeLogoPath);
        WebElement belCardLogo = driver.findElement(belCardLogoPath);
        Assertions.assertTrue(visaLogo.isDisplayed(), "Логотип \"Visa\" не отображается");
        Assertions.assertTrue(mastercardLogo.isDisplayed(), "Логотип \"MasterCard\" не отображается");
        Assertions.assertTrue(verifiedByVisaLogo.isDisplayed(), "Логотип \"Verified By Visa\" не отображается");
        Assertions.assertTrue(mastercardSecureCodeLogo.isDisplayed(), "Логотип \"MasterCard Secure Code\" не отображается");
        Assertions.assertTrue(belCardLogo.isDisplayed(), "Логотип \"Белкарт\" не отображается");
    }

    @Test
    @DisplayName("Проверка сылки \"Подробнее о сервисе\"")
    public void moreAboutService() {
        WebElement moreAboutServiceLink = driver.findElement(moreAboutServiceLinkPath);
        moreAboutServiceLink.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedMoreAboutServiceUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assertions.assertEquals(expectedMoreAboutServiceUrl, actualUrl, "Ссылка \"Подробнее о сервисе\" редиректит на неверную страницу");
        driver.get("http://mts.by");
    }

    @Test
    @DisplayName("Проверка кнопки \"Продолжить\"")
    public void continueButton() {
        String phoneNumber = "297777777";
        String sum = "10";
        WebElement phoneInput = driver.findElement(phoneInputPath);
        phoneInput.click();
        phoneInput.sendKeys(phoneNumber);
        WebElement sumInput = driver.findElement(sumInputPath);
        sumInput.click();
        sumInput.sendKeys(sum);
        WebElement continueButton = driver.findElement(continueButtonPath);
        continueButton.click();
        WebElement payWindow = driver.findElement(payWindowPath);
        Assertions.assertTrue(payWindow.isDisplayed());
    }

    public static void acceptCookiesIfPresent(WebDriver driver, By message, By acceptButton) {
        try {
            WebElement cookieMessage = driver.findElement(message);
            WebElement acceptCookiesButton = driver.findElement(acceptButton);
            if (cookieMessage.isDisplayed()) {
                acceptCookiesButton.click();
            }
        } catch (NoSuchElementException ignored) {
        }
    }
}
