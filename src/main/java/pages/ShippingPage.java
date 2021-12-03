package pages;

import org.openqa.selenium.By;
import support.Verifications;
import support.driver.DriverManager;

public class ShippingPage extends DriverManager {

    By chkTermos = By.name("cgv");
    By btnProcessa =  By.name("processCarrier");

    public void acceptTerms(){

        Verifications.verifyElementExists(chkTermos);
        getDriver().findElement(chkTermos).click();
    }

    public void processaEntrega(){
        Verifications.verifyElementIsClickable(btnProcessa);
        getDriver().findElement(btnProcessa).click();
    }

}
