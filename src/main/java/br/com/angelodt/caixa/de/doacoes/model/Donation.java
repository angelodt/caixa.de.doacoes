package br.com.angelodt.caixa.de.doacoes.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private String keywords;

    private String location;

    private Boolean open;

    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    private User donor;

    @OneToMany(mappedBy = "donation", cascade = CascadeType.ALL)
    private List<DonationPhoto> photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public User getDonor() {
        return donor;
    }

    public void setDonor(User donor) {
        this.donor = donor;
    }

    public List<DonationPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<DonationPhoto> photos) {
        this.photos = photos;
    }

    // getters and setters
}
