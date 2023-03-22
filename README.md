# desafio-act

## REQUISITOS:

1. [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. [Gradle > 7.6.1](https://gradle.org/releases/)
3. configurar variáveis de ambiente:
   - JAVA_HOME
   - GRADLE_USER_HOME
   - adicionar o *path* dos bins para a variável **PATH**

> necessário executar os comandos de build e execuação na raiz do projeto

## BUILD:

`gradle clean build`

---

## EXECUÇÃO:

### GRADLE

`gradle bootRun`

### JVM

`java -jar build/libs/spa-0.0.1-SNAPSHOT.jar com.act.spa.SpaApplication`

### Docker

`docker build --build-arg JAR_FILE=build/libs/*.jar -t spa .`

`docker run -d -p 8090:8090 spa`

---

## CONSULTAR BANCO DE DADOS:
- link: http://localhost:8090/spa/h2-console
- login: myuser

---

### RESOURCES

- spa/estoque-de-produtos/listagem ; GET
- spa/estoque-de-produtos/atualizar-produto ; POST ; Content-Type: application/json; body:
      `
         {
             "codigo": "8D7SA897DS8AD7A",
             "nome": "SHAMPOO WELLA INVIGO NUTRI-ENRICH",
             "descricao": "Shamppo de cabelo WELLA",
             "preco": 129.90,
             "quantidade": 200
         }
      `
