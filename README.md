Sistema de Gestão de Projetos

Sistema desenvolvido em Java com integração ao banco de dados MySQL para gerenciamento de Usuários, Equipes, Projetos e Tarefas.

Tecnologias Utilizadas

Java 
MySQL 
JDBC 

Como executar este projeto
1. Clone ou baixe este repositório.
2. Abra o MySQL Workbench, vá em Data Import e importe o arquivo `.sql` incluso para restaurar as tabelas e dados de teste.
3. Abra a pasta do projeto no IntelliJ IDEA.
4. Verifique se o driver JDBC do MySQL está configurado nas bibliotecas do projeto.
5. No arquivo `ConnectionFactory.java`, altere as credenciais (usuário e senha) para as do seu banco local.
6. Execute a classe `Main.java` e utilize o menu interativo no console.
