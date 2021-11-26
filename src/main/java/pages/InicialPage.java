package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.driver.DriverManager;
import support.report.Report;

public class InicialPage extends DriverManager {



    public void acessarAplicacao(){
        getDriver().get(configuration.url());
    }

    public void escolheProduto(String produto){
        new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//a[@class='product-name' and @title='"+produto+"']"))).perform();
        Report.takeScreenShot();
        getDriver().findElement(By.xpath("//a[@class='product-name' and @title='"+produto+"']/../../div[2]/a[@title='Add to cart']")).click();
    }
}
