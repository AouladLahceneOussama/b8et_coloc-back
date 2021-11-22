package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long room_id;

    @ManyToOne @JoinColumn(name="offer_id", nullable=false)
    private Offers offer;

    @OneToMany(targetEntity=Demands.class,mappedBy = "room" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demands> demand;

    @Column(name = "intitule")
    private String intitule;
    @Column(name = "image1")
    private String image1;
    @Column(name = "image2")
    private String image2;
    @Column(name = "nbr_personne")
    private int nbr_personne; // max
    @Column(name = "nbr_bed_dispo")
    private int nbr_bed_dispo; // à decrimenter
    @Column(name = "price")
    private int price;

    @Column(name = "equipment")
    private String equipment; 

    public Rooms() {
    }

    public Rooms( Offers offer, String intitule, String image1, String image2, int nbr_personne, int nbr_bed_dispo, int price, String equipment) {
        this.offer = offer;
        this.intitule = intitule;
        this.image1 = image1;
        this.image2 = image2;
        this.nbr_personne = nbr_personne;
        this.nbr_bed_dispo = nbr_bed_dispo;
        this.price = price;
        this.equipment = equipment;
    }

    public String toString() {
		return "{ offer : " + this.offer.getOffer_id() + ", intitule : " + this.intitule + ", image1 : " + this.image1 + ", image2 : " + this.image2 + ", nbr_personne : " + this.nbr_personne + ", nbr_bed_dispo : " + this.nbr_bed_dispo +
         ", price : " + this.price + ", equipement : " + this.equipment + "}";
	}

    public long getRoom_id() {
        return this.room_id;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public Offers getOffer() {
        return this.offer;
    }

    public void setOffer(Offers offer) {
        this.offer = offer;
    }

    public String getIntitule() {
        return this.intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getImage1() {
        return this.image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return this.image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public int getNbr_personne() {
        return this.nbr_personne;
    }

    public void setNbr_personne(int nbr_personne) {
        this.nbr_personne = nbr_personne;
    }

    public int getNbr_bed_dispo() {
        return this.nbr_bed_dispo;
    }

    public void setNbr_bed_dispo(int nbr_bed_dispo) {
        this.nbr_bed_dispo = nbr_bed_dispo;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEquipment() {
        return this.equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}