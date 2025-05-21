# 📚 Sistema de Livraria
    Projeto desenvolvido como parte dos estudos dos fundamentos de Java, inspirado nos conteúdos da Rocketseat. O objetivo é simular um sistema básico de gerenciamento de uma livraria, permitindo operações como cadastro de livros, autores e editoras.

### 🚀 Funcionalidades
	•	Cadastro de livros com título, autor e editora.
	•	Listagem de livros disponíveis.
	•	Busca de livros por título ou autor.
	•	Remoção de livros do catálogo.

### 🛠️ Tecnologias Utilizadas
	•	Java 17
	•	Paradigma de Programação Orientada a Objetos (POO)
	•	IDE: VS Code 

### 📂 Estrutura do Projeto
    Sistema de Livraria/
    ├── bin/                    
    ├── lib/                   
    ├── src/
    │   ├── app/                # Classe principal
    │   │   └── App.java
    │   ├── model/              # Modelos de domínio
    │   │   ├── Autor.java
    │   │   ├── Biblioteca.java
    │   │   ├── Cliente.java
    │   │   ├── Emprestimo.java
    │   │   ├── Livro.java
    │   │   └── TipoArquivo.java
    │   ├── resources/          # Arquivos de dados (.txt)
    │   │   ├── clientes.txt
    │   │   ├── emprestimos.txt
    │   │   └── livros.txt
    │   └── util/               # Classes utilitárias
    │       ├── ArquivoUtil.java
    │       ├── ConsoleUtil.java
    │       └── MenuUtil.java
    ├── README.md               # Documentação do projeto

### 📄 Recursos Extras
	•	Os arquivos .txt na pasta resources são utilizados como “banco de dados” simples.
	•	A estrutura separa responsabilidades entre modelos, lógica da aplicação e utilitários.

### 🧠 Conceitos Praticados
	•	Programação Orientada a Objetos
	•	Manipulação de arquivos com Java
	•	Modularização de código
	•	Interação com usuário via terminal

### 📃 Licença
    Projeto com fins educativos — sinta-se livre para usar, modificar e estudar!