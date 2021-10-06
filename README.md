# Aplicação de exemplo para persistência em cascata

Aplicação de exemplo sobre como persistir objetos em cascata com jpa

Documentação [Spring Boot](http://projects.spring.io/spring-boot/) 

## Requerimentos:

Para construir e executar o aplicativo, você precisa:

- [JDK 11](https://openjdk.java.net/projects/jdk/11/)
- [Maven 3](https://maven.apache.org)

## Executando a aplicação localmente

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método principal na classe com.persistenciacascata.PersistenciaEmCascataApplication da sua IDE.

Como alternativa, você pode usar o plugin Spring Boot Maven da seguinte maneira:

```shell
mvn spring-boot:run
```
## Testando:

Via client, como o postman, acessar o endpoint /restaurantes:

#### POST http://localhost:8080/restaurantes

Informar um payload no formato json na requisição, algo como:

{
    "nome": "Restaurante teste",
	"taxaFrete": 10,
	"contatos": [
		{
			"nome": "Zé das couves",
			"email": "zedascouves@gmail.com"
		},
		{
			"nome": "Zélia das Couves",
			"email": "zeliadascouves@gmail.com"
		}
	],
	"enderecos": [
		{
			"cidade": "Uma cidade",
			"cep": "22222222",
			"logradouro": "Rua das Couves",
			"numero": "1000",
			"complemento": "Em frente a sabe-se lá o que",
			"bairro": "Um bairro"
		}
	]
}

No fim, checar se os dados foram persistidos corretamente nas tabelas de restaurante, contato e endereco.
