# Leia me!!!
Gostaria primeiramente de agradecer a oportunidade que vocês me deram! Obrigado!!

# Requisitos 
### Sua aplicação web DEVE:

- [x] Ter uma tela (via um formulário) para fazer o upload do arquivo(pontos extras se não usar um popular CSS Framework )
- [x] Interpretar ("parsear") o arquivo recebido, normalizar os dados, e salvar corretamente a informação em um banco de dados relacional, se atente as documentações que estão logo abaixo.
- [x] +- Exibir uma lista das operações importadas por lojas, e nesta lista deve conter um totalizador do saldo em conta
- [x] Ser escrita na sua linguagem de programação de preferência
- [x] Ser simples de configurar e rodar, funcionando em ambiente compatível com Unix (Linux ou Mac OS X). Ela deve utilizar apenas linguagens e bibliotecas livres ou gratuitas.
- [x] Git com commits atomicos e bem descritos
- [x] PostgreSQL, MySQL ou SQL Server
- [x] Ter testes automatizados
- [x] Docker compose (Pontos extras se utilizar)
- [x] Readme file descrevendo bem o projeto e seu setup
- [x] Incluir informação descrevendo como consumir o endpoint da API

# Configuração da aplicação
### O que fazer para rodar a aplicação:

1. Clone o projeto para sua máquina local [Repositório Git](https://github.com/rivhenrique/desafio-dev)
2. Construa a aplicação utilizando o [Maven](https://maven.apache.org/) no diretório do arquivo pom.xml
   - mvn clean package
3. Execute o ambiente [Docker](https://www.docker.com/) no mesmo diretório que o arquivo docker-compose.yml o comando: 
   - docker-compose up --build
4. Pronto!!! A aplicação e o banco de dados já estão rodando!!!!!

### Acesso a aplicação
Para acessar a aplicação, via [Postman](https://www.postman.com/) ou página: 

* Início - [http://localhost:8080/cnab-persister/upload-file.html](http://localhost:8080/cnab-persister/upload-file.html)
* [Documentação](https://www.getpostman.com/collections/759da0922f02a25dfac6) via Postman
* [Github](https://github.com/rivhenrique/desafio-dev)
* [Gitlab](https://gitlab.com/exemploHen) com meus projetos pessoais

