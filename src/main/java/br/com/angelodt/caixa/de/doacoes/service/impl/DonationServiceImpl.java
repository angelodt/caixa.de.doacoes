package br.com.angelodt.caixa.de.doacoes.service.impl;

import br.com.angelodt.caixa.de.doacoes.model.Donation;
import br.com.angelodt.caixa.de.doacoes.model.DonationPhoto;
import br.com.angelodt.caixa.de.doacoes.model.repository.DonationPhotoRepository;
import br.com.angelodt.caixa.de.doacoes.model.repository.DonationRepository;
import br.com.angelodt.caixa.de.doacoes.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonationPhotoRepository donationPhotoRepository;

    public List<Donation> searchDonations(String searchTerm) {
        // Implementação da busca de doações por termo de pesquisa
        return donationRepository.findByTitleContainingOrDescriptionContainingOrKeywordsContaining(searchTerm, searchTerm, searchTerm);
    }

    public Donation createDonation(Donation donation) {
        // Implementação da criação de doação
        return donationRepository.save(donation);
    }

    public void deleteDonation(Long id) {
        // Implementação da exclusão de doação
        donationRepository.deleteById(id);
    }

    public Donation updateDonation(Long id, Donation donation) {
        // Implementação da atualização de doação
        Donation existingDonation = donationRepository.findById(id).orElse(null);
        if (existingDonation != null) {
            donation.setId(id);
            return donationRepository.save(donation);
        }
        return null;
    }

    public void addPhotoToDonation(Long donationId, String filename, String contentType, byte[] data) {
        Donation donation = donationRepository.findById(donationId).orElse(null);
        if (donation != null) {
            DonationPhoto photo = new DonationPhoto();
            photo.setDonation(donation);
            photo.setFilename(filename);
            photo.setContentType(contentType);
            photo.setData(data);
            donation.getPhotos().add(photo);
            donationRepository.save(donation);
        }
    }
}

