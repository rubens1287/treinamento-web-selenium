package pages;

import org.openqa.selenium.By;
import support.Verifications;
import support.driver.DriverManager;

public class AddressPage extends DriverManager {

    By lbladdress = By.className("address_address2");
    By BtnProcess = By.name("processAddress");

    public boolean checkEndereco(String end){
        return Verifications.verifyElementIsClickable(lbladdress) &&
         getDriver().findElement(lbladdress).getText().equals(end);
    }

    public void processaEndereco(){
        getDriver().findElement(BtnProcess).click();
    }


}
