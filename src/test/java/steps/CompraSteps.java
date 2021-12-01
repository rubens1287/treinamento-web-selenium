package steps;

import cucumber.api.java.pt.E;
import pages.CreateAccountPage;
import pages.SignInPage;
import pages.SummaryPage;

public class CompraSteps {

    SummaryPage cartSummary;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    public CompraSteps() {

        cartSummary = new SummaryPage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }

    @E("proceder para o checkout {string}")
    public void procederParaOCheckout(String action) {
        cartSummary.proceedToCheckout(action);
    }

    @E("crio uma conta")
    public void crioUmaConta() {
        signInPage.createAccount();
        createAccountPage.fillPersonalInformation();
        createAccountPage.fillAddressInfo();
    }
}
