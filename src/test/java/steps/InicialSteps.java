package steps;

import cucumber.api.java.pt.Quando;
import pages.InicialPage;
import cucumber.api.java.pt.Dado;

public class InicialSteps {

    InicialPage inicialPage;

    public InicialSteps() {
        inicialPage = new InicialPage();
    }

    @Dado("acessar aplicacao")
    public void acessarAplicacao() {
        inicialPage.acessarAplicacao();
    }

    @Quando("o cliente escolher o produto {string}")
    public void oClienteEscolherOProduto(String produto) {
        inicialPage.escolheProduto(produto);
    }
}
