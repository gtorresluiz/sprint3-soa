# Sprint 1
# Sistema de Cadastro de Usuários

## Descrição do Projeto

Este projeto é uma aplicação Java que permite o cadastro e gerenciamento de usuários. Ele possui um menu principal com opções para registrar novos usuários, realizar login e um modo administrador para operações avançadas, como listar todos os usuários, buscar usuários por ID e deletar usuários.

O sistema foi desenvolvido utilizando Java 17+, com arquitetura em camadas (Controller, Service, DAO) e comunicação via REST APIs.

---

## Funcionalidades

- Cadastro de novos usuários (nome, email e senha)
- Login de usuários com validação
- Modo administrador com:
  - Listagem de todos os usuários cadastrados
  - Busca de usuário por ID
  - Exclusão de usuários
- Comunicação via HTTP com API RESTful
- Validação das requisições com respostas HTTP apropriadas
- Interface gráfica simples para login

---

## Como Rodar o Projeto

### Requisitos

- Java 17 ou superior instalado
- Maven instalado
- IDE de sua preferência (IntelliJ, Eclipse, VSCode) ou terminal

### Passo a passo

1. **Clonar o repositório**

   ```bash
   git clone https://github.com/OtavioBtm1/SOASprint.git

2. **Entrar na pasta do projeto**
   
   ```bash
   cd demo
   
3. ** Build do projeto**
   
   ```bash
   mvn clean install

4. **Rodar o app**
   
   ```bash
   mvn spring-boot:run

5. **Acessar a aplicação**

- A API estará rodando em:  
  `http://localhost:8080`

- Para registrar um usuário, envie um POST para:  
  `http://localhost:8080/usuarios/register`

- Para fazer login, envie um POST para:  
  `http://localhost:8080/usuarios/login`

- Modo administrador: use os endpoints para listar, buscar e deletar usuários.

### Interface Web

- Para acessar a interface gráfica simples de login:  
  `http://localhost:8080/login.html`

- Nela, você pode realizar login e receberá sinal verde se for sucesso ou um X vermelho se falhar.

### Documentação da API

- Disponível em:  
  `http://localhost:8080/swagger-ui.html`

### Equipe

- Murilo Henrique Obinata RM99855
- Otavio Vitoriano da Silva RM552012
- Eduardo Fedeli Souza RM550132
- Gabriel Torres Luiz RM98600

## 🏗️ Arquitetura

- **Controller** → expõe os endpoints REST  
- **Service** → contém as regras de negócio  
- **Repository** → camada de acesso ao banco de dados  
- **Model** → entidades, VOs e Enums  
- **DTO** → objetos de transferência de dados  

# 📌 Exemplo de Requisição e Resposta - Usuário

Este exemplo demonstra como consumir a API para a entidade `Usuario` usando endpoints REST.

---

## **Cadastrar Usuário (POST /usuarios)**

**Request:**

```json
POST /usuarios
Content-Type: application/json

{
  "nome": "Otavio Vitoriano",
  "email": "otavio@email.com",
  "senha": "senha123",
  "perfil": "ADMIN",
  "endereco": {
    "rua": "Rua das Flores",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01000-000"
  }
}
```
***Response:**

```json
HTTP/1.1 201 Created
Content-Type: application/json

{
  "id": 1,
  "nome": "Otavio Vitoriano",
  "email": "otavio@email.com",
  "perfil": "ADMIN",
  "endereco": {
    "rua": "Rua das Flores",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01000-000"
  }
}
```


### Observações

- O projeto usa banco de dados H2 em memória para facilitar testes.

- Use Postman ou Insomnia para testar os endpoints REST.

- Spring Security já configurado para autenticação básica.

- A arquitetura segue boas práticas, usando DAO, Service e Controller.


