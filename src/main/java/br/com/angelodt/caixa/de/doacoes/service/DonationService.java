package br.com.angelodt.caixa.de.doacoes.service;

import br.com.angelodt.caixa.de.doacoes.model.Donation;

import java.util.List;

public interface DonationService {

    List<Donation> searchDonations(String searchTerm);

    Donation createDonation(Donation donation);

    void deleteDonation(Long id);

    Donation updateDonation(Long id, Donation donation);

    void addPhotoToDonation(Long donationId, String filename, String contentType, byte[] data);
}
