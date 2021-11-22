package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "demand")
public class Demands {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long demand_id;

    @ManyToOne @JoinColumn(name="offer_id", nullable=false)
    private Offers offer;
    
    @ManyToOne @JoinColumn(name="room_id", nullable=false)
    private Rooms room;
    

   
    @Column(name = "full_name")
    private String full_name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "university")
    private String university;

    @Column(name = "degre")
    private String degre;

    @Column(name = "comment")
    private String comment;

    @Column(name = "statut")
    private String statut;

    public Timestamp getCreated_at() {
		return created_at;
	}

    public void setRoom(Rooms room) {
		this.room = room;
	}

	public Rooms getRoom() {
		return room;
	}


	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@Column(name = "created_at")
    private Timestamp created_at;
    
    @Column(name = "updated_at")
    private Timestamp updated_at;


    public Demands() {}
    
	public Offers getOffer() {
		return offer;
	}

	
	public void setOffer(Offers offer) {
		this.offer = offer;
	}
	
    public long getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(int demand_id) {
        this.demand_id = demand_id;
    }

   

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegre() {
        return degre;
    }

    public void setDegre(String degre) {
        this.degre = degre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

	public Demands(long demand_id,  String full_name, String phone_number, String university, String degre,
			String comment, String statut, Timestamp created_at, Timestamp updated_at, Offers offer , Rooms room) {
		super();
        this.room = room ;
		this.offer = offer;
		this.demand_id = demand_id;
		this.full_name = full_name;
		this.phone_number = phone_number;
		this.university = university;
		this.degre = degre;
		this.comment = comment;
		this.statut = statut;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}



}
