package pages;

import cucumber.api.java.hu.Ha;
import cucumber.api.java.it.Ma;
import org.openqa.selenium.By;
import support.Verifications;
import support.driver.DriverManager;

import java.util.HashMap;
import java.util.Map;

public class PaymentPage extends DriverManager {

    By btnPayByBankWire = By.className("bankwire");
    By btnConfirma = By.xpath("//button/span[contains(text(),'I confirm my order')]");

    public Map<String,String> checkTable(){
        Verifications.verifyElementIsClickable(btnPayByBankWire);
        Map<String,String>  dataTable =  new HashMap();

        for (int i = 0; i < getDriver().findElements(By.xpath("//table[@id='cart_summary']//tfoot/tr/td")).size(); i++) {
            if (!getDriver().findElements(By.xpath("//table[@id='cart_summary']//tfoot/tr/td")).get(i).getText().equals("") && i <= getDriver().findElements(By.xpath("//table[@id='cart_summary']//tfoot/tr/td")).size()){
                dataTable.put(getDriver().findElements(By.xpath("//table[@id='cart_summary']//tfoot/tr/td")).get(i).getText(),
                        getDriver().findElements(By.xpath("//table[@id='cart_summary']//tfoot/tr/td")).get(i+1).getText());
                i++;
            }
        }
        return dataTable;
    }


    public void choosePaymentModel(){
        getDriver().findElement(By.className("payment_module")).click();
    }

    public void confirmar(){
        Verifications.verifyElementIsClickable(btnConfirma);
        getDriver().findElement(btnConfirma).click();
    }

    public void checkStatusCompra(){
        Verifications.verifyElementExists(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]"));
    }


}
