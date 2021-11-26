package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.driver.DriverManager;
import support.report.Report;

public class CartSummary extends DriverManager {

    public void procedeToCheckout(String type){
        //p//a[@title='Proceed to checkout']
        Report.takeScreenShot();
        WebDriverWait wait = new WebDriverWait(getDriver(), configuration.timeout());
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath(type+"//a[@title='Proceed to checkout']")))).click();
    }

}
