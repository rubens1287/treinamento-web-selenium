package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.data.DataYaml;
import support.driver.DriverManager;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SignInPage extends DriverManager {

    private By txtEmail = By.name("email_create");
    private By btnCreateAccount = By.id("SubmitCreate");
    private WebDriverWait wait;
    private Faker faker;
    private Map map;

    public SignInPage() {
        wait = new WebDriverWait(getDriver(), configuration.timeout());
        faker = new Faker();
        map = new HashMap();
    }

    public void createAccount(){

        String email = faker.name().fullName().replace(" ","").toLowerCase()+"@gft.com";
        map.put("user",email);
        wait.until(ExpectedConditions.elementToBeClickable(txtEmail)).sendKeys(email);
        getDriver().findElement(btnCreateAccount).click();
        DataYaml.setMapYamlValues("Usuarios","usuario",map);
    }





}
