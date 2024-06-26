package br.com.angelodt.caixa.de.doacoes.model.repository;

import br.com.angelodt.caixa.de.doacoes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
