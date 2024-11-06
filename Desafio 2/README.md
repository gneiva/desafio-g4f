# Projeto de Emissão de Cartão de Crédito

Este projeto consiste em um sistema de microserviços para emissão de cartões de crédito. Ele inclui uma interface frontend desenvolvida em React para captura dos dados do cliente e dois microserviços em Spring Boot que processam e emitem a proposta de crédito.

## Desafio

A aplicação lida com o seguinte fluxo:

+ **Frontend (React):**: Um formulário permite que o cliente envie uma proposta de crédito, informando o nome, e-mail e limite de crédito desejado. (O templete não foi enviado, então foi criado um simples formulário)
+ **Microserviço cartoes-ms**: Responsável por receber a proposta de crédito, criar uma proposta com um limite aprovado e, em seguida, solicitar ao emissor-ms a emissão de um cartão físico.
+ **Microserviço emissor-ms**: Gera o número do cartão, cria o cartão físico e envia uma notificação por e-mail ao cliente com os detalhes.

## Estrutura do Projeto
O projeto possui a seguinte estrutura de diretórios:
~~~
cartao-credito/
├── cartoes-ms/               # Microserviço para gerenciamento de propostas de crédito
├── emissor-ms/               # Microserviço para emissão do cartão e envio de notificação
├── client/cartao-proposta/   # Interface frontend em React para captura de proposta
└── docker-compose.yml        # Configuração do Docker Compose para iniciar todos os serviços
~~~~


## Arquitetura do Projeto
### 1. Princípios SOLID Utilizados ###

+ **Single Responsibility Principle (SRP):**
  +   Cada microserviço tem uma responsabilidade única. O cartoes-ms lida apenas com a criação de propostas de crédito e o emissor-ms é dedicado à emissão do cartão físico e envio de notificações.
  +   No código, cada classe também cumpre uma função única, por exemplo, CreditProposalService no cartoes-ms apenas gerencia a lógica das propostas de crédito, enquanto o CardIssuerService no emissor-ms se encarrega da emissão do cartão.

+ **Open/Closed Principle (OCP):**
  + Cada microserviço está aberto para extensão e fechado para modificação. Por exemplo, novos tipos de notificação podem ser adicionados ao emissor-ms sem modificar os serviços existentes.
  + Para o CreditProposalService, podemos adicionar novas lógicas de validação de crédito sem alterar o fluxo principal do serviço.
 
+ **Liskov Substitution Principle (LSP):**
  + Cada microserviço está aberto para extensão e fechado para modificação. Por exemplo, novos tipos de notificação podem ser adicionados ao emissor-ms sem modificar os serviços existentes.

+ **Interface Segregation Principle (ISP):**
  + A interface Device no projeto foi criada apenas com os métodos essenciais que qualquer dispositivo de automação precisa. Da mesma forma, os métodos turnOn e turnOff são separados dos métodos de controle específico, evitando interfaces muito grandes
 
+ **Dependency Inversion Principle (DIP):**
  + Os serviços dependem de abstrações. No emissor-ms, o CardIssuerService depende de EmailNotificationService para enviar e-mails, mas a lógica de envio específica está no EmailNotificationService, não no CardIssuerService.

### 2. Estrutura dos Endpoints Principais ###
+ **cartoes-ms: /api/proposals (POST)** – Recebe as propostas de crédito com o nome do cliente, e-mail e limite solicitado.
+ **emissor-ms: /api/cards/issue (POST)** – Emite o cartão e envia a notificação por e-mail com os dados do cartão emitido.

## Bibliotecas Utilizadas
+ **Spring Boot:** Facilita a criação de microserviços e oferece uma estrutura para configurar rapidamente APIs REST, como o cartoes-ms e o emissor-ms
+ **Spring Data JPA:** Permite o mapeamento objeto-relacional para persistir propostas de crédito no cartoes-ms e dados do cartão no emissor-ms.
+ **Spring Mail:** Utilizado no emissor-ms para enviar e-mails com as informações do cartão emitido
+ **H2 Database:** Banco de dados em memória usado para desenvolvimento rápido e testes.
+ **Lombok:** Reduz a necessidade de boilerplate, como getters, setters e construtores
+ **React e Material-UI:** Para criar a interface do formulário de proposta de crédito, utilizando componentes visuais de Material Design para uma experiência de usuário moderna e intuitiva.
+ **Docker e Docker Compose**: Contêineres permitem fácil configuração e execução de cada parte do sistema, enquanto o Docker Compose facilita o gerenciamento e orquestração dos microserviços e da interface React.

## Variáveis de Ambiente
No arquivo docker-compose.yml, defina as credenciais e configurações do servidor de e-mail, como **SPRING_MAIL_HOST**, **SPRING_MAIL_USERNAME**, e **SPRING_MAIL_PASSWORD**, para que o emissor-ms possa enviar notificações.

Exemplo de configuração com **Gmail**
~~~
 - SPRING_MAIL_HOST=smtp.gmail.com
 - SPRING_MAIL_PORT=587
 - SPRING_MAIL_USERNAME=<seu e-mail>@gmail.com
 - SPRING_MAIL_PASSWORD=<senha de aplicativo>
~~~
**A senha de aplicativo para o gmail pode ser criada em: https://myaccount.google.com/apppasswords**

## Executar o Projeto
### Pré-Requisitos
Certifique-se de ter o Docker e o Docker Compose instalados na máquina.    
    
### Executar com Docker Compose
1 - Clone o projeto para a máquina
~~~
git clone https://github.com/gneiva/desafio-g4f.git
~~~

2 - Navegue até o diretório "Desafio 2" e execute o comando:
~~~
docker-compose up --build
~~~~

3 - Os serviços estarão disponíveis nas seguintes URLs:
+ **Frontend React:** http://localhost:3000
+ **cartoes-ms:** http://localhost:8081
+ **emissor-ms:** http://localhost:8080

4 - Acesse http://localhost:3000 para visualizar o formulário.

## Evoluções Futuras

Para aprimorar o projeto e aumentar sua confiabilidade e manutenibilidade, é recomendável:
+ **Implementação de Testes Unitários:** Adicionar testes unitários para todos os serviços, especialmente os métodos de criação de propostas e envio de notificações. Isso garante que a aplicação continue funcionando conforme o esperado ao longo das mudanças.
+ **Segurança e Autenticação:** Implementar autenticação e autorização para proteger os endpoints, especialmente em um ambiente de produção.
+ **Monitoramento e Logging:** Adicionar monitoramento para rastrear o uso e desempenho dos serviços, além de um sistema de logs para diagnosticar problemas rapidamente.
+ **Integração com Banco de Dados Persistente:** Migrar do H2 para um banco de dados persistente, como PostgreSQL, para ambientes de produção.
+ **Mensageria com Kafka ou RabbitMQ:** Utilizar um sistema de mensageria para comunicação assíncrona entre os microserviços.

