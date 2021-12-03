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
    Entao eu valido o endereco "Rua Libia, 10 "
    Quando ele confirma o endereco e segue em frente
    E aceita os termos da entrega
    Entao valida os produto na tabela de pagamento
    E confirma a compra
    E valida se a compra foi efetuada com sucesso
 #   Entao deve ser apresentado compra com sucesso
