package steps;

import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import pages.*;
import support.data.DataYaml;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CompraSteps {

    SummaryPage cartSummary;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;

    public CompraSteps() {
        cartSummary = new SummaryPage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        addressPage = new AddressPage();
        shippingPage = new ShippingPage();
        paymentPage = new PaymentPage();
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

    @Entao("eu valido o endereco {string}")
    public void euValidoOEndereco(String end) {
        addressPage.checkEndereco(end);
    }

    @Quando("ele confirma o endereco e segue em frente")
    public void eleConfirmaOEnderecoESegueEmFrente() {
        addressPage.processaEndereco();
    }

    @E("aceita os termos da entrega")
    public void aceitaOsTermosDaEntrega() {
        shippingPage.acceptTerms();
        shippingPage.processaEntrega();
    }

    @Entao("valida os produto na tabela de pagamento")
    public void validaOsProdutoNaTabelaDePagamento() {
        Map expected = DataYaml.getMapYamlValues("Usuarios","produtos");
        assertThat(paymentPage.checkTable(), is(expected));
        ;
    }
}
