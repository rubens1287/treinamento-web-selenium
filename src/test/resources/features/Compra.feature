# language: pt
# charset: UTF-8

Funcionalidade: Compra
  Eu como cliente gostaria de comprar um produto para ter mais acessorios

  @dev
  Cenario: Comprar um produto
    Dado acessar aplicacao
    Quando o cliente escolher o produto "Blouse"
    E proceder para o checkout "detalhe"
    E proceder para o checkout "compra"
    E crio uma conta
 #   Entao deve ser apresentado compra com sucesso
