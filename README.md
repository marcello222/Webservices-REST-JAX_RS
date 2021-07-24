# Webservices-REST-JAX-RS-Jersey


 Usando Interface uniforme como um padrão que faz com que todas as aplicações, todos os programas utilizando essa API, tenham em comum essas características, todas elas sabem entender o que uma requisição HTTP está fazendo, e Serialização via XStream.




CHamada de métodos HTTP pré definidos, todos os métodos estão na classe CarrinhoResource no pacote Resource.

"POST"  passar o comando para remover no prompt de comando  - curl -d "<br.com.alura.loja.modelo.Carrinho>  <produtos>    <br.com.alura.loja.modelo.Produto>      <preco>4000.0</preco>      <id>6237</id>      <nome>Videogame 4</nome>      <quantidade>1</quantidade>    </br.com.alura.loja.modelo.Produto>  </produtos>  <rua>Rua Vergueiro 3185, 8 andar</rua>  <cidade>São Paulo</cidade>  <id>1</id></br.com.alura.loja.modelo.Carrinho>" http://localhost:8080/carrinhos

"DELETE" passar o comando para remover no prompt de comando -  curl -v -X DELETE http://localhost:8080/carrinhos/1/produtos/6237

"PUT" passar o comando para remover no prompt de comando -  curl -v -X "PUT" -d "<br.com.alura.loja.modelo.Produto><preco>60.0</preco><id>3467</id><nome>Jogo de esporte</nome><quantidade>1</quantidade></br.com.alura.loja.modelo.Produto>" http://localhost:8080/carrinhos/1/produtos/3467 nesse caso foi trocado a quantidade para 1
