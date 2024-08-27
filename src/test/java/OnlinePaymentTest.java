import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OnlinePaymentTest extends BaseDriverSetUp {
    @Test
    @DisplayName("Проверка заголовка")
    public void checkHeader() {
        HomePage homePage = new HomePage();
        homePage.onlinePaymentHeader();
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    public void checkPayPartnersLogos() {
        HomePage homePage = new HomePage();
        homePage.payPartnersLogos();
    }

    @Test
    @DisplayName("Проверка сылки \"Подробнее о сервисе\"")
    public void checkMoreAboutService() {
        HomePage homePage = new HomePage();
        homePage.moreAboutService();
    }

    @Test
    @DisplayName("Проверка надписей выпадающего меню")
    public void serviceDropdownCheck() {
        HomePage homePage = new HomePage();
        homePage.serviceDropdown();
    }

    @Test
    @DisplayName("Проверка элементов окна оплаты")
    public void payWindowInfoCheck() throws InterruptedException {
        String phone = "297777777";
        String sum = "10";
        HomePage homePage = new HomePage();
        homePage.inputData(phone, sum);
        PayWindowPage payWindowPage = new PayWindowPage();
        Thread.sleep(7_000);
        payWindowPage.payWindowInfo(phone, sum);
    }
}
