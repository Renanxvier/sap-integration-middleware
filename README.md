# SAP Integration Middleware

Middleware de exemplo para receber pedidos por uma API REST, armazená-los localmente e simular o envio ao SAP. O projeto demonstra uma estrutura inicial com Spring Boot, Spring Data JPA e H2.

## Funcionalidades

- Cadastro de pedidos com cliente e itens.
- Consulta dos pedidos cadastrados.
- Persistência com Spring Data JPA.
- Simulação do envio ao SAP e atualização do status do pedido.

> **Importante:** a integração com o SAP ainda é simulada. O projeto não realiza chamadas a um ERP real. O banco H2 usa configuração padrão em memória, então os dados não são mantidos após o encerramento da aplicação.

## Requisitos

- Java 17 ou superior
- Maven Wrapper incluído no repositório

## Como executar

Clone o repositório, entre na pasta do projeto e inicie a aplicação:

```bash
git clone https://github.com/Renanxvier/sap-integration-middleware.git
cd sap-integration-middleware
```

No Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

No macOS ou Linux:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em <http://localhost:8081>.

## Endpoints

| Método | Endpoint | Ação |
| --- | --- | --- |
| `POST` | `/api/orders` | Cria um pedido e simula seu envio ao SAP. |
| `GET` | `/api/orders` | Lista os pedidos cadastrados. |

### Criar um pedido

Envie um `POST` para `/api/orders` com um JSON como este:

```json
{
  "customerName": "Cliente de exemplo",
  "customerEmail": "cliente@example.com",
  "items": [
    {
      "productCode": "SKU-001",
      "quantity": 2,
      "unitPrice": 49.90
    }
  ]
}
```

O fluxo atual registra o pedido e simula uma resposta bem-sucedida do SAP, atribuindo o status `SYNCED_WITH_SAP` e um identificador fictício. Os status possíveis são `PENDING`, `SYNCED_WITH_SAP` e `FAILED`.

## Testes

No Windows:

```powershell
.\mvnw.cmd test
```

No macOS ou Linux:

```bash
./mvnw test
```

## Estrutura do projeto

```text
sap-integration-middleware/
├── src/
│   ├── main/
│   │   ├── java/com/syncedcorp/sapintegration/
│   │   │   ├── controller/   # Endpoints REST
│   │   │   ├── dto/          # Dados de entrada da API
│   │   │   ├── model/        # Entidades e status dos pedidos
│   │   │   ├── repository/   # Persistência com Spring Data JPA
│   │   │   └── service/      # Processamento e simulação SAP
│   │   └── resources/
│   │       └── application.properties
│   └── test/                 # Testes da aplicação
├── .mvn/                     # Configuração do Maven Wrapper
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Tecnologias

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven
