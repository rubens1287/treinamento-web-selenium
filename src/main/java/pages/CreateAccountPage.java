package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.data.DataYaml;
import support.driver.DriverManager;
import support.report.Report;

public class CreateAccountPage extends DriverManager {

    private By rdbGeneroMr = By.id("id_gender1");
    private By txtCustomerFirstname = By.id("customer_firstname");
    private By txtCustomerLastname = By.id("customer_lastname");
    private By txtPass = By.id("passwd");
    private By cbbDays = By.id("days");
    private By cbbMonths = By.id("months");
    private By cbbYears = By.id("years");
    private By txtEndaddress1 = By.id("address1");
    private By txtEndcity = By.id("city");
    private By cbbEndid_state = By.id("id_state");
    private By txtEndpostcode = By.id("postcode");
    private By cbbEndid_country = By.id("id_country");
    private By txtPhoneMobile = By.id("phone_mobile");
    private By txtAlias = By.id("alias");
    private By btnRegister = By.id("submitAccount");

    private WebDriverWait wait;
    private Faker faker;

    public CreateAccountPage() {
        wait = new WebDriverWait(getDriver(), configuration.timeout());
        faker =  new Faker();
    }

    public void fillPersonalInformation(){
        wait.until(ExpectedConditions.elementToBeClickable(rdbGeneroMr)).click();
        getDriver().findElement(txtCustomerFirstname).sendKeys(faker.name().firstName());
        getDriver().findElement(txtCustomerLastname).sendKeys(faker.name().lastName());
        getDriver().findElement(txtPass).sendKeys(DataYaml.getMapYamlValues("Usuarios","usuario").get("pass"));
        new Select(getDriver().findElement(cbbDays)).selectByIndex(25);
        new Select(getDriver().findElement(cbbMonths)).selectByVisibleText("December\u00a0");
        new Select(getDriver().findElement(cbbYears)).selectByValue("1986");
        Report.takeScreenShot();
    }

    public void fillAddressInfo(){
        getDriver().findElement(txtEndaddress1).sendKeys("Rua Libia, 10");
        getDriver().findElement(txtEndcity).sendKeys("São Paulo");
        new Select(getDriver().findElement(cbbEndid_state)).selectByVisibleText("Ohio");
        getDriver().findElement(txtEndpostcode).sendKeys("00000");
        new Select(getDriver().findElement(cbbEndid_country)).selectByValue("21");
        getDriver().findElement(txtPhoneMobile).sendKeys("11957771200");
        getDriver().findElement(txtAlias).sendKeys("Proximo a igreja");
        Report.takeScreenShot();
        getDriver().findElement(btnRegister).click();
    }
}
