import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class OnlinePaymentTest extends BaseDriverSetUp {
    @Test
    @Owner("Sergei Ermolovich")
    @DisplayName("Проверка заголовка")
    @Description("Проверяем что текст заголовка окна \"Онлайн пополнение без комиссии\" совпадает с ожидаемым")
    public void checkHeader() {
        HomePage homePage = new HomePage();
        homePage.onlinePaymentHeader();
    }

    @Test
    @Owner("Sergei Ermolovich")
    @DisplayName("Проверка наличия логотипов платежных систем")
    @Description("Проверяем отображение логотипов платежных сиситем в окне \"Онлайн пополнение без комиссии\"")
    public void checkPayPartnersLogos() {
        HomePage homePage = new HomePage();
        homePage.payPartnersLogos();
    }

    @Test
    @Owner("Sergei Ermolovich")
    @DisplayName("Проверка сылки \"Подробнее о сервисе\"")
    @Description("Проверяем что при переходе по ссылке \"Подробнее о сервисе\" фактический URL совпадает с ожидаемым")
    public void checkMoreAboutService() {
        HomePage homePage = new HomePage();
        homePage.moreAboutService();
    }

    @Test
    @Owner("Sergei Ermolovich")
    @DisplayName("Проверка надписей выпадающего меню")
    @Description("Проверяем что названия услуг из выпадающего списка окна \"Онлайн пополнение без комиссии\" совпадают с ожидаемыми")
    public void serviceDropdownCheck() {
        HomePage homePage = new HomePage();
        homePage.serviceDropdown();
    }

    @Test
    @Owner("Sergei Ermolovich")
    @DisplayName("Проверка элементов окна оплаты")
    @Description("В окне \"Онлайн пополнение без комиссии\", вводим телефон, сумму, выбираем услугу \"Услуги связи\", " +
            "нажимаем на кнопку продолжить и сверяем что в появившемся iframe данные совпадают с введенными, совпадают ли названия плейсхолдеров" +
            "с ожидаемыми, а также, отображаются ли логотипы платежных систем")
    public void payWindowInfoCheck() throws InterruptedException {
        String phone = "297777777";
        String sum = "10";
        HomePage homePage = new HomePage();
        homePage.inputData(phone, sum);
        PayWindowPage payWindowPage = new PayWindowPage();
        Thread.sleep(10_000);
        payWindowPage.payWindowInfo(phone, sum);
    }
}
