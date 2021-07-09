## Requisitos Funcionais

- [x] Deve ser possível gerar novas senhas, que podem ser de dois tipos: NORMAL e PREFERENCIAL, com os formatos “N####” e “P####” respectivamente, onde “#” é um dígito;
- [x] Deve ser possível acompanhar a chamada das senhas;
- [x] O acesso ao acompanhamento e a geração de novas senhas deve ser público;
- [x] Deve ser possível chamar a próxima senha. O sistema deve dar prioridade para as senhas PREFERENCIAIS, garantindo que nenhuma senha NORMAL seja chamada se ainda houver alguma PREFERENCIAL pendente;
- [x] Somente o GERENTE será capaz de chamar próximas senhas;
- [ ] Deve ser possível reiniciar a contagem das senhas;
- Não foi feito.
- [ ] Somente o GERENTE será capaz de reiniciar a contagem de senhas;
- Não foi feito
- [x] Não há necessidade de login e senha para o perfil de GERENTE;
- [x] O sistema deve garantir que a sequência de senhas não seja perdida caso o servidor precise ser reiniciado.

## Requisitos não-funcionais

- [x] Acesso às funcionalidades deve ser remoto, através de interface web, em um browser ou via aplicativo para dispositivos móveis;
- [x] O servidor deve ser escrito obrigatoriamente em Java;
- [x] A comunicação entre a interface cliente e o servidor deve ser realizada utilizando a arquitetura REST.
- [ ] Deve ser possível fazer o build automatizado do servidor, dê preferência com Maven;
- [ ] O servidor deve rodar em Tomcat;
- [x] O código fonte da interface gráfica deve estar separado do servidor e, preferencialmente, utilizar tecnologias como Angular ou React;
- [x] Se necessário a utilização de um banco de dados, este deve ser o PostgreSQL 9.3 ou posterior.

## Prazos

- Para seguir as próximas etapas, você deve primeiramente concluir o teste e inserir o link para a resposta, em modo público, no questionário de avaliação.

## Entrega

- A entrega deve ser feita a partir de um repositório GIT público, Ex.: Github, Bitbucket, etc. No repositório devem existir as orientações necessárias para executar o projeto e, também, um passo a passo simples da utilização do sistema desenvolvido. Se houver aplicativo para dispositivos móveis, enviar também o arquivo pronto para instalar, em iOS e ou Android.

## Dúvidas

- As dúvidas sobre os requisitos podem ser encaminhadas para recrutamento@paripassu.com.br

### **Etapas do Desenvolvimento BACKEND**

- Desenvolvimento feito em em Spring Boot
- Criado o Banco Postgres utilizando o docker
- Gerado o build e tudo funcionou

### **Start da aplicação**

- Para iniciar o banco de dados:

```

Comando Docker

docker-compose up -d

ou

docker-compose up --force-recreate -d


```

- Instalar o maven

```
sudo apt install maven

```

- Verificar a versão maven

```
mvn -version

```

- Output

```
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 11.0.7, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-26-generic", arch: "amd64", family: "unix"

```

- Rode o comando do maven para instalar as dependências

```
mvn spring-boot:run
```
