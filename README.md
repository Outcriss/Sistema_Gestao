# Sistema de Gestão de Projetos e Tarefas

## 1. Objetivo do Projeto
O objetivo deste projeto é desenvolver uma aplicação robusta de gerenciamento de projetos e tarefas focado em ambiente corporativo. O sistema visa mitigar falhas de persistência volátil, substituindo o armazenamento temporário em memória por uma base de dados relacional estável. A aplicação permite a criação, delegação e acompanhamento de projetos e suas respectivas demandas, associando responsabilidades de forma clara e segura.

---

## 2. Requisitos do Sistema

### Requisitos Funcionais (RF)
* RF-001: O sistema deve permitir o cadastro de usuários com identificação única (ID, Nome, CPF e Cargo).
* RF-002: O sistema deve permitir a criação de projetos, vinculando obrigatoriamente um usuário como gerente responsável.
* RF-003: O sistema deve permitir a criação de tarefas associadas a um projeto existente e delegadas a um usuário responsável cadastrado.
* RF-004: O sistema deve exibir um menu interativo no console para navegação entre as operações.

### Requisitos Não-Funcionais (RNF)
* RNF-001 (Persistência): Os dados inseridos devem ser armazenados de forma permanente em um banco de dados relacional MySQL.
* RNF-002 (Arquitetura): O código deve seguir o padrão de arquitetura DAO (Data Access Object) para separação das responsabilidades de negócio e persistência.
* RNF-003 (Segurança): O tráfego de instruções SQL deve ser blindado contra SQL Injection utilizando queries parametrizadas com PreparedStatement.

---

## 3. Tecnologias e Ferramentas Utilizadas
* Linguagem: Java (Princípios de Orientação a Objetos)
* Banco de Dados: MySQL 8.0
* Conectividade: JDBC (Java Database Connectivity)
* IDE de Desenvolvimento: IntelliJ IDEA

---

## 4. Instruções de Execução e Configuração

### Passo 1: Restauração do Banco de Dados
1. Abra o seu MySQL Workbench.
2. Vá ao menu superior em Server > Data Import.
3. Escolha a opção Import from Self-Contained File e selecione o arquivo .sql disponível na raiz deste repositório.
4. Defina o schema de destino como sistema_projetos e clique em Start Import.

### Passo 2: Configuração do Projeto em Java
1. Importe a pasta do projeto no IntelliJ IDEA.
2. Certifique-se de que o driver Connector/J do MySQL (mysql-connector-j-x.x.x.jar) está adicionado às dependências e bibliotecas do projeto (Project Structure > Libraries).
3. Abra o arquivo ConnectionFactory.java e altere a URL de conexão, o usuário e a senha para corresponderem às credenciais do seu servidor MySQL local.

### Passo 3: Inicialização
1. Localize a classe Main.java dentro da pasta src/.
2. Execute o arquivo através do botão Run.
3. Utilize o terminal integrado para gerenciar o menu de operações.

---

## 5. Descrição das Funcionalidades

O software opera em um ecossistema integrado dividido em módulos através de um menu interativo por console:

1. Módulo de Usuários: Cadastro de colaboradores e atribuição de cargos, servindo de base para o controle de permissões e responsabilidades.
2. Módulo de Projetos: Criação de escopos de trabalho corporativos. Exige a associação de um ID de usuário válido para atuar como Gerente do Projeto, assegurando a integridade referencial.
3. Módulo de Tarefas: Criação e delegação de demandas técnicas. Vincula a atividade diretamente a um projeto pai e a um executor responsável no banco, atualizando o progresso das rotinas corporativas.
