package br.com.angelodt.caixa.de.doacoes.model.repository;

import br.com.angelodt.caixa.de.doacoes.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByTitleContainingOrDescriptionContainingOrKeywordsContaining(String title, String description, String keywords);
}
