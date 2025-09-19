<p align="center">
    <a href="#guia">Guia de Instalação do Projeto</a>  |  
    <a href="#regras--de--negocio">Regras de negócio</a>
</p>

<span id="guia">

## Guia de Instalação do Projeto Vue com Spring e Docker

Este documento descreve os passos para configurar e executar uma aplicação composta por um frontend em Vue.js e um backend em Spring, utilizando Docker para gerenciar o banco de dados PostgreSQL.

## Pré-requisitos

Antes de começar, certifique-se de que os seguintes softwares estão instalados na sua máquina:

- **[Node.js](https://nodejs.org/en/download) e npm**: Necessário para gerenciar e servir o frontend Vue.js.
- **[Java 21](https://www.azul.com/downloads/?version=java-21-lts&package=jdk#zulu)**: Requerido para executar o arquivo .jar do backend Spring.
- **[Docker](https://www.docker.com/products/docker-desktop/)**: Usado para criar e gerenciar o container do PostgreSQL.

## Passos de Instalação

1. **Baixar os arquivos do projeto**
   - Faça o download da pasta do projeto no Google Drive: [Link para a pasta TO DO]().
   - A pasta contém:
     - A pasta `dist` com o build do frontend Vue.js.
     - O arquivo `.jar` do backend Spring.
     - O arquivo `compose.yaml` para configurar o Docker.

2. **Instalar a biblioteca `serve` globalmente**
   - Abra um terminal e execute o seguinte comando para instalar a biblioteca `serve` globalmente com npm:
     ```bash
     npm install -g serve
     ```

3. **Criar e iniciar o container do PostgreSQL**
   - No diretório onde está o arquivo `compose.yaml`, execute o comando abaixo para iniciar o container do PostgreSQL:
     ```bash
     docker-compose -f compose.yaml up -d
     ```
   - Isso criará e iniciará o container do banco de dados em segundo plano. Certifique-se de que o Docker está em execução.

4. **Executar o backend Spring**
   - No diretório onde está o arquivo `.jar`, execute o comando abaixo para iniciar a aplicação Spring:
     ```bash
     java -jar checkpoint.jar
     ```
   - Substitua `checkpoint.jar` pelo nome real do arquivo .jar baixado.
   - Aguarde até que a aplicação Spring esteja completamente inicializada.

5. **Servir o frontend Vue.js**
   - Navegue até o diretório onde está a pasta `dist` do frontend e execute o comando:
     ```bash
     serve -s dist -p 3000
     ```
   - Isso servirá o frontend na porta 3000.

6. **Acessar a aplicação**
   - Abra um navegador e acesse: [http://localhost:3000](http://localhost:3000).
   - A aplicação Vue.js estará disponível, conectada ao backend Spring e ao banco de dados MySQL.

## Possíveis Erros

- **MySQL já instalado na máquina**
  - Se o MySQL já está instalado localmente e em execução, pode haver um conflito de portas (geralmente a porta 5432). Para resolver:
    - Verifique se o MySQL local está rodando com:
      ```bash
      ps aux | grep mysql
      ```
    - Pare o serviço local, se necessário:
      ```bash
      sudo systemctl stop mysql
      ```
    - Alternativamente, edite o arquivo `compose.yaml` para usar uma porta diferente para o container do PostgreSQL, modificando a seção de portas, por exemplo:
      ```yaml
      ports:
        - "5433:5432"
      ```
    - Após alterar a porta, atualize as configurações de conexão no backend Spring (geralmente em `application.properties` ou `application.yml`) para apontar para a nova porta.

## Contato

Para suporte ou dúvidas, entre em contato com:
- **Email**: davisfs2110@gmail.com

## Notas
- Certifique-se de que as portas necessárias (como 3000 para o frontend e a porta configurada no Spring, geralmente 8080) não estão em uso.
- Caso o PostgreSQL exija configurações específicas (como usuário, senha ou nome do banco), verifique o arquivo `compose.yaml` e ajuste as variáveis de ambiente conforme necessário.
- Para parar os containers do Docker, use:
  ```bash
  docker-compose -f compose.yaml down
  ```
<span id="regras--de--negocio">

## Regras de Negócio

[Critérios e níveis de mobilidade](https://drive.google.com/file/d/1IKE2cbQQ0cMa3z-ZV18vwZaXsBptKfXH/view?usp=drive_link)
