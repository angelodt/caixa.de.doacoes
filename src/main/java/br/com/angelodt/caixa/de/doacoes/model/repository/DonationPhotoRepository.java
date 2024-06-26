package br.com.angelodt.caixa.de.doacoes.model.repository;

import br.com.angelodt.caixa.de.doacoes.model.DonationPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationPhotoRepository extends JpaRepository<DonationPhoto, Long> {
}

