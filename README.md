# poo-lista-05

Questão 01

O Java 8 permitiu métodos com corpo em interfaces, com default e static.

Utilidade:
default: permite adicionar um método novo a uma interface sem quebrar as classes que já a implementam. Elas herdam a implementação padrão e podem sobrescrevê-la se quiserem. Foi assim que a API de coleções ganhou métodos como forEach() sem quebrar código antigo.
static: permite colocar métodos utilitários dentro da própria interface, relacionados a ela, sem precisar de uma classe auxiliar separada (como Collections). Exemplo: Comparator.comparing(...). Esses métodos não são herdados pelas classes implementadoras.





Questão 02

Uma interface define um contrato (o que fazer) sem impor a implementação (como fazer). Assim, o código cliente depende da abstração, não de uma classe concreta, o que traz:

- Baixo acoplamento: dá para trocar a implementação sem alterar quem a usa.
- Facilidade de manutenção: mudanças ficam isoladas em uma classe.
- Testabilidade: é possível substituir dependências reais por mocks.
- Extensibilidade: novas implementações entram no sistema sem modificar o código existente (princípio aberto/fechado).

Exemplo prático: um sistema de e-commerce com pagamento. Em vez de o Pedido usar diretamente PagamentoCartao, ele usa a interface MeioPagamento (com pagar(double valor)). Hoje há PagamentoCartao e PagamentoBoleto. Amanhã, para incluir PagamentoPix, basta criar uma nova classe que implemente a interface, e a classe Pedido não muda. Nos testes, usa-se um PagamentoFake, sem cobrar de verdade.




