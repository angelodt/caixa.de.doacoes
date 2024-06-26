# Projeto: Caixa de Doações

Este projeto visa proporcionar uma plataforma onde usuários podem cadastrar, pesquisar e gerenciar doações de forma eficiente e organizada. Desenvolvido utilizando Java 17 e Spring Boot 3, o projeto utiliza tecnologias robustas como Spring Data JPA e Spring Security para oferecer funcionalidades de persistência de dados e segurança.

## Funcionalidades Principais

- **Cadastro de Usuários:** Registro na plataforma com nome de usuário único, e-mail e senha.
  
- **Cadastro de Doações:** Cadastramento de doações com título, descrição detalhada, palavras-chave e localização.
  
- **Pesquisa de Doações:** Busca por doações utilizando critérios como título, descrição, palavras-chave e localização.
  
- **Gerenciamento de Doações:** Edição e exclusão de doações conforme necessário.
  
- **Upload de Fotos:** Possibilidade de adicionar fotos às doações para uma melhor visualização.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security
- Banco de Dados Relacional (MySQL, PostgreSQL, etc.)

## Como Utilizar

1. **Pré-requisitos:**
   - JDK 17 ou superior
   - Maven
   - Banco de Dados Relacional (configurado no arquivo `application.properties`)

2. **Configuração:**
   - Clone o repositório: `git clone https://github.com/seu-usuario/nome-do-repositorio.git`
   - Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`

3. **Execução:**
   - Navegue até o diretório do projeto: `cd nome-do-repositorio`
   - Compile o projeto: `mvn clean package`
   - Execute o aplicativo: `java -jar target/nome-do-arquivo.jar`

4. **Acesso:**
   - Acesse a aplicação através do navegador: `http://localhost:8080`

## Contribuições

Contribuições são bem-vindas! Para contribuir com este projeto:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).

---

  ## Class Diagram

  ```mermaid
classDiagram
    class User {
        - Long id
        - String username
        - String email
        - String password
        + getters/setters
    }

    class Donation {
        - Long id
        - String title
        - String description
        - String keywords
        - String location
        - Boolean open
        - User donor
        - List<DonationPhoto> photos
        + getters/setters
    }

    class DonationPhoto {
        - Long id
        - String filename
        - String contentType
        - byte[] data
        + getters/setters
    }

    class DonationService {
        + List<Donation> searchDonations(String searchTerm)
        + Donation createDonation(Donation donation)
        + void deleteDonation(Long id)
        + Donation updateDonation(Long id, Donation donation)
        + void addPhotoToDonation(Long donationId, String filename, String contentType, byte[] data)
    }

    class DonationController {
        + ResponseEntity<?> searchDonations(String searchTerm)
        + ResponseEntity<?> createDonation(Donation donation)
        + ResponseEntity<?> deleteDonation(Long id)
        + ResponseEntity<?> updateDonation(Long id, Donation donation)
        + ResponseEntity<?> addPhotoToDonation(Long donationId, MultipartFile photo)
    }

    class UserController {
        + ResponseEntity<?> createUser(User user)
        + ResponseEntity<?> readUser(Long id)
        + ResponseEntity<?> updateUser(Long id, User user)
        + ResponseEntity<?> deleteUser(Long id)
    }

    class UserRepository {
        <<SpringBean>>
        - JpaRepository<User, Long> repository
    }

    class DonationRepository {
        <<SpringBean>>
        - JpaRepository<Donation, Long> repository
    }

    class DonationPhotoRepository {
        <<SpringBean>>
        - JpaRepository<DonationPhoto, Long> repository
    }

    User "1" -- "*" Donation : owns
    Donation "1" *-- "*" DonationPhoto : has
    DonationService "1" --> "*" Donation : uses
    DonationService "1" --> "1" DonationPhotoRepository : uses
    DonationService --> DonationRepository : uses
    DonationController --> DonationService : uses
    UserController --> UserRepository : uses
```
