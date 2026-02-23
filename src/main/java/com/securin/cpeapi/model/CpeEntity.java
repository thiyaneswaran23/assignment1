package com.securin.cpeapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cpes")
public class CpeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpeTitle;

    @Column(columnDefinition = "TEXT")
    private String cpe22Uri;

    @Column(columnDefinition = "TEXT")
    private String cpe23Uri;

    @ElementCollection
    @CollectionTable(
            name = "cpe_references",
            joinColumns = @JoinColumn(name = "cpe_id")
    )
    @Column(name = "reference_link")
    private List<String> referenceLinks;

    private LocalDate cpe22DeprecationDate;
    private LocalDate cpe23DeprecationDate;

    // ---------- GETTERS ----------

    public Long getId() {
        return id;
    }

    public String getCpeTitle() {
        return cpeTitle;
    }

    public String getCpe22Uri() {
        return cpe22Uri;
    }

    public String getCpe23Uri() {
        return cpe23Uri;
    }

    public List<String> getReferenceLinks() {
        return referenceLinks;
    }

    public LocalDate getCpe22DeprecationDate() {
        return cpe22DeprecationDate;
    }

    public LocalDate getCpe23DeprecationDate() {
        return cpe23DeprecationDate;
    }

    // ---------- SETTERS ----------

    public void setId(Long id) {
        this.id = id;
    }

    public void setCpeTitle(String cpeTitle) {
        this.cpeTitle = cpeTitle;
    }

    public void setCpe22Uri(String cpe22Uri) {
        this.cpe22Uri = cpe22Uri;
    }

    public void setCpe23Uri(String cpe23Uri) {
        this.cpe23Uri = cpe23Uri;
    }

    public void setReferenceLinks(List<String> referenceLinks) {
        this.referenceLinks = referenceLinks;
    }

    public void setCpe22DeprecationDate(LocalDate cpe22DeprecationDate) {
        this.cpe22DeprecationDate = cpe22DeprecationDate;
    }

    public void setCpe23DeprecationDate(LocalDate cpe23DeprecationDate) {
        this.cpe23DeprecationDate = cpe23DeprecationDate;
    }
}