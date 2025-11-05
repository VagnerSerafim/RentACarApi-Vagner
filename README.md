# 🚘 Rent-a-Car API | Projeto Final - Gerenciamento de Aluguéis de Carros

Este projeto é uma API REST desenvolvida em Java com o framework **Spring Boot (3.x)** e persistência em **H2 Database (em memória)**. O objetivo é fornecer um CRUD (Create, Read, Update, Delete) completo para a entidade principal `Carro` em um sistema de locação de veículos.

### 👥 Integrantes do Grupo


* [Vagner Serafim] - https://github.com/VagnerSerafim/RentACarApi-Vagner.git


### ✨ Funcionalidades Implementadas

* **CRUD Completo (`Carro`):** Implementação dos 6 endpoints obrigatórios (GET, POST, PUT, DELETE, PATCH).
* **Persistência de Dados:** Uso de Spring Data JPA com banco de dados **H2** para desenvolvimento.
* **Regra de Rastreamento (Obrigatório):** O campo `criadoPor` é automaticamente preenchido no Service com o nome **"Vagner Serafim"** em cada requisição POST, atendendo a um requisito específico de auditoria.

### 🔗 Endpoints do Recurso Principal (`/carros`)

| Método | Rota | Descrição |
| :----- | :------------------ | :--------------------------------------------- |
| `GET`  | `/carros`           | Retorna todos os carros cadastrados.           |
| `GET`  | `/carros/{id}`      | Retorna um carro por ID.                       |
| `POST` | `/carros`           | Cadastra um novo carro. (Inclui o campo `criadoPor`) |
| `PUT`  | `/carros/{id}`      | Atualiza **completamente** o registro por ID.  |
| `DELETE`| `/carros/{id}`      | Deleta o registro por ID.                      |
| `PATCH`| `/carros/{id}`      | Atualiza **parcialmente** o registro (ex: preço, disponibilidade). |

### 🚀 Como Executar o Projeto

**Pré-requisitos:**

* JDK 21+
* Apache Maven

**Passo a Passo:**

1.  **Clonar o Repositório:**
    ```bash
    git clone [SUA_URL_DO_REPOSITORIO_AQUI]
    cd RentACarApi
    ```
2.  **Compilar e Empacotar (Maven):**
    ```bash
    mvn clean install
    ```
3.  **Executar a Aplicação (Jar):**
    ```bash
    java -jar target/RentACarApi-1.0-SNAPSHOT.jar 
    # (O nome do arquivo .jar pode variar, verifique a pasta target)
    ```
    Alternativamente, execute a classe `Main.java` diretamente pela IDE (IntelliJ).

### 🧪 Teste Rápido (Localhost)

A aplicação será iniciada na porta 8080.

* **URL Base:** `http://localhost:8080`
* **Console H2 (Banco de Dados):** Acesse `http://localhost:8080/h2-console`
    * *JDBC URL:* `jdbc:h2:mem:rentacardb`
    * *User:* `sa` / *Password:* `password`

**Exemplo de POST (Criar Carro):**

```bash
curl -X POST "http://localhost:8080/carros" \
  -H "Content-Type: application/json" \
  -d '{
    "modelo": "Civic EX",
    "marca": "Honda",
    "categoria": "SEDAN",
    "potenciaMotor": 155.0,
    "anoFabricacao": 2022,
    "precoDiaria": 199.90
}'
```

### Testes Adicionais (CRUD Completo):
Recomendamos o uso do arquivo `src/main/resources/testes.http` (Formato nativo do IntelliJ e amplamente suportado) para executar e validar todos os 6 endpoints: `GET` (todos e por ID), `PUT`, `DELETE` e `PATCH`. Com isso, o projeto está 100% completo, funcional e documentado para a entrega.