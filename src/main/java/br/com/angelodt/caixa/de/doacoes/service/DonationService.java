package br.com.angelodt.caixa.de.doacoes.service;

import br.com.angelodt.caixa.de.doacoes.model.Donation;

import java.util.List;

public interface DonationService {

    public List<Donation> searchDonations(String searchTerm);

    public Donation createDonation(Donation donation);

    public void deleteDonation(Long id);

    public Donation updateDonation(Long id, Donation donation);

    public void addPhotoToDonation(Long donationId, String filename, String contentType, byte[] data);
}
