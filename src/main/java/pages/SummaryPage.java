package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.driver.DriverManager;
import support.report.Report;

public class SummaryPage extends DriverManager {

    By btnProceedFirst = By.xpath("//a[@title='Proceed to checkout']");
    By btnProceedSecond = By.xpath("//p//a[@title='Proceed to checkout']");
    WebDriverWait wait;

    public SummaryPage() {
        wait = new WebDriverWait(getDriver(), configuration.timeout());
    }

    private void procedeToCheckoutFirst(){
        Report.takeScreenShot();
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(btnProceedFirst))).click();
    }

    private void procedeToCheckoutSecond(){
        Report.takeScreenShot();
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(btnProceedSecond))).click();
    }

    public void proceedToCheckout(String action){
        switch(action.toUpperCase()) {
            case "DETALHE":
                procedeToCheckoutFirst();
                break;
            case "COMPRA":
                procedeToCheckoutSecond();
                break;
            default:
                throw new RuntimeException("Erro ao tentar identificar o tipo de ação");
        }
    }

}
