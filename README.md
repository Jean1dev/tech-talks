# tech-talks

Repositório para organizar as tech talks que apresento. Cada pasta contém o código-fonte e exemplos utilizados nas apresentações.

## Conteúdo

| Pasta | Tema | Tecnologias |
|---|---|---|
| `env-vars` | Gerenciamento de variáveis de ambiente | Node.js, dotenv, Azure Functions |
| `techtalk-java` | Configuração de aplicações Spring Boot com perfis | Java 11, Spring Boot |
| `event-driven-devlopment` | Arquitetura orientada a eventos | Java 15, padrões DDD |
| `sonarqube` | Configuração e uso do SonarQube | Docker, SonarQube |

---

## env-vars

Demonstra o uso de variáveis de ambiente em Node.js utilizando a biblioteca `dotenv`, com exemplos também para Azure Functions.

### Requisitos

- Node.js
- npm

### Como rodar

```bash
cd env-vars
npm install
cp .env.example .env
# Edite o arquivo .env e defina TECH_TALK_NUMBER=<valor>
node index.js
```

---

## techtalk-java

Aplicação Spring Boot que demonstra o carregamento de configurações a partir de variáveis de ambiente e perfis (`profiles`).

### Requisitos

- Java 11
- Maven (ou usar o wrapper incluso)

### Como rodar

```bash
cd techtalk-java

# Perfil padrão
./mvnw spring-boot:run

# Perfil local
./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=local"
```

> A apresentação em PDF está disponível em `techtalk-java/techtalk.pdf`.

---

## event-driven-devlopment

Demonstração de arquitetura orientada a eventos com implementação de um mock de Kafka baseado em arquivo. Contém dois módulos: **paciente** e **agendamento**, seguindo conceitos de DDD.

### Requisitos

- Java 15
- Maven (ou usar o wrapper incluso)

### Como rodar

Abra dois terminais:

```bash
# Terminal 1 — produtor de eventos
cd event-driven-devlopment
./mvnw exec:java -Dexec.mainClass="ProducerMockStart"

# Terminal 2 — consumidor de eventos
cd event-driven-devlopment
./mvnw exec:java -Dexec.mainClass="ConsumerMockStart"
```

O produtor grava eventos em um arquivo (`messages.txt`) e o consumidor os lê e processa.

---

## sonarqube

Scripts para subir o SonarQube via Docker e configurar análise de código.

Consulte `sonarqube/scripts.md` para os comandos completos.

---

## Licença

Este projeto está licenciado sob a [GNU General Public License v3](LICENSE).
