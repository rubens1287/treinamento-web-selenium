package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;
import pages.CartSummary;

public class CompraSteps {

    CartSummary cartSummary;

    public CompraSteps() {
        cartSummary = new CartSummary();
    }

    @E("proceder para o checkout {string}")
    public void procederParaOCheckout(String type) {
        cartSummary.procedeToCheckout(type);
    }
}
