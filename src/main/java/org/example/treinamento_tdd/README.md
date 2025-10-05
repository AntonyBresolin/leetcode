Projeto: Validador de Pedidos de E-commerce
Contexto:
Você trabalha em um e-commerce que está crescendo rapidamente. A primeira versão do sistema de processamento de pedidos foi criada por um desenvolvedor júnior que precisava entregar tudo muito rápido. A lógica principal está toda em um único método, que verifica se um pedido é válido antes de enviá-lo para o sistema de pagamento e logística.

Agora, a empresa precisa adicionar novas regras e integrações, mas o código atual é frágil e muito difícil de testar. Qualquer pequena mudança pode quebrar o sistema.

Seu Desafio:
Seu trabalho é pegar a classe ValidadorPedido, que contém toda a lógica atual, e melhorá-la. Seus objetivos são:

Criar uma suíte de testes unitários que cubra todas as regras de negócio existentes. Seu primeiro passo deve ser garantir o comportamento atual antes de mudar qualquer coisa.

Refatorar o código para que ele seja limpo, legível e fácil de manter.

Aplicar os princípios de Clean Code e SOLID, especialmente o Princípio da Responsabilidade Única (SRP).

Separar as responsabilidades, de modo que a lógica de negócio principal não esteja misturada com a forma como os dados são apresentados (dica: pense em como a Arquitetura Hexagonal faria isso).

Regras de Negócio Atuais (Conforme a Especificação Original):

Um pedido não pode ser aprovado se o produto estiver sem estoque.

O valor total do pedido não pode exceder o limite de crédito do cliente.

Clientes com nome na "lista negra" devem ser rejeitados automaticamente.

Pedidos para o estado de SP têm um imposto de 18%. Os demais estados têm um imposto de 12%.

Pedidos acima de R$ 500,00 (valor do produto + imposto) têm frete grátis. Caso contrário, o frete é fixo de R$ 25,00.

O método deve retornar uma string indicando se o pedido foi "APROVADO" ou o motivo do erro.

O Código a ser Refatorado
Aqui está a classe ValidadorPedido. Copie e cole este código na sua IDE para começar a trabalhar.