package br.com.angelodt.caixa.de.doacoes.controller;

import br.com.angelodt.caixa.de.doacoes.model.Donation;
import br.com.angelodt.caixa.de.doacoes.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/donations")
public class UserController {

    @Autowired
    private DonationService donationService;

    @GetMapping("/search")
    public ResponseEntity<?> searchDonations(@RequestParam String searchTerm) {
        return ResponseEntity.ok(donationService.searchDonations(searchTerm));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDonation(@RequestBody Donation donation) {
        return ResponseEntity.ok(donationService.createDonation(donation));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDonation(@PathVariable Long id) {
        donationService.deleteDonation(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDonation(@PathVariable Long id, @RequestBody Donation donation) {
        Donation updatedDonation = donationService.updateDonation(id, donation);
        if (updatedDonation != null) {
            return ResponseEntity.ok(updatedDonation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{donationId}/photos")
    public ResponseEntity<?> addPhotoToDonation(
            @PathVariable Long donationId,
            @RequestParam("file") MultipartFile file) {
        try {
            donationService.addPhotoToDonation(donationId, file.getOriginalFilename(), file.getContentType(), file.getBytes());
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Failed to upload photo");
        }
    }
}
