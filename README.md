# sistema-cadastro-cliente-JavaJframe
Projeto realizado para o Serratec usando Java e JFrame

## Criar um banco de dados que contenha:

* Cliente
* Produto
* Pedido

#### Deve seguir o modelo lógico anexado.
#### Deve permitir cadastrar, alterar e excluir (CRUD): clientes, produtos e pedidos.

## Cada tabela:
* Deve possuir classes para cada entidade.
* Deve possuir uma classe de conexão.
* Deve possuir classes DAO.
* Deve possuir método para selecionar um registro (localizar).
* Deve possuir método para selecionar mais de um registro (relatório).

## O sistema deve possuir um menu para cada situação:

- Produto
- Cliente
- Pedido
  
<hr>

* Cada item deve possuir menu para permitir o CRUD (persistência de dados no banco Postgres) a localização e o relatório.
* Deve permitir selecionar um cliente (por código e/ou nome) e mostrar todos os pedidos que possui.
* Deve permitir selecionar um produto (por código e/ou nome) e mostrar todos os pedidos que possui.
* Deve permitir selecionar um pedido (por código e/ou data) e mostrar o seu cliente e todos os produtos que possui.
* Deve possuir os dados da empresa que vende o produto para o cliente.


- Deve ser entregue o SQL de criação das tabelas e o projeto Java completo.
- Deve ser entregue o Diagrama de Classes (UML)

<hr>

#### Avaliação: O trabalho vale 90 pontos. Sendo 60 da criação das classes e UML e 30 da construção do main.

#### Descontarei pontos se:
- Não for entregue o SQL de criação das tabelas (2 pontos)
- Não for entregue o Diagrama de Classes (2 pontos)
- O projeto possuir um erro de execução (1 ponto por erro)
- Não houver encapsulamento (2 pontos)
- Não atender aos requisitos (1 ponto cada falta)
