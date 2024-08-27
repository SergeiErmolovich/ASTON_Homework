import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseDriverSetUp {
    protected static WebDriver driver;
    private static final By COOKIE_MESSAGE_PATH = By.xpath("//div[@class='cookie__wrapper']");
    private static final By ACCEPT_COOKIES_BUTTON_PATH = By.xpath("//button[@class='btn btn_black cookie__ok']");

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        BaseSeleniumPage.setDriver(driver);
        driver.get("http://mts.by");
        acceptCookiesIfPresent(driver, COOKIE_MESSAGE_PATH, ACCEPT_COOKIES_BUTTON_PATH);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
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
