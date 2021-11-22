package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long offer_id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@OneToMany(targetEntity = Rooms.class, mappedBy = "offer",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rooms> room;

	@Column(name = "address")
	private String address;
	@Column(name = "floor")
	private int floor;
	@Column(name = "area")
	private int area;
	@Column(name = "city")
	private String city;

	@Column(name = "image")
	private String image;

	@Column(name = "room_number")
	private int room_number;
	@Column(columnDefinition = "TINYINT(1)")
	private boolean contrat;
	@Column(name = "duration")
	private int duration;
	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(name = "wifi")
	private String wifi;
	@Column(name = "water_electricity")
	private String water_electricity;
	@Column(name = "created_at")
	private Timestamp created_at;
	@Column(name = "updated_at")
	private Timestamp updated_at;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public boolean isContrat() {
		return contrat;
	}

	public void setContrat(boolean contrat) {
		this.contrat = contrat;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getWater_electricity() {
		return water_electricity;
	}

	public void setWater_electricity(String water_electricity) {
		this.water_electricity = water_electricity;
	}

	public Timestamp getCreated_at() {
		return created_at;
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

	public long getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(long offer_id) {
		this.offer_id = offer_id;
	}

	public Offers() {
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Offers(Users user, String address, int floor, int area, String city, String image, int room_number, boolean contrat,
			int duration, String description, String wifi, String water_electricity, Timestamp created_at,
			Timestamp updated_at) {
		super();
		this.user = user;
		this.address = address;
		this.floor = floor;
		this.area = area;
		this.city = city;
		this.image = image;
		this.room_number = room_number;
		this.contrat = contrat;
		this.duration = duration;
		this.description = description;
		this.wifi = wifi;
		this.water_electricity = water_electricity;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public String toString() {
		return "{" + this.user + "," + this.address + "," + this.floor + "," + this.area + "," + this.city + "," + this.image + ","
		+ this.room_number + "," + this.contrat + "," + this.duration + "," + this.description + ","
		+ this.wifi + "," + this.water_electricity + "," + this.created_at + "," + this.updated_at + "}";
	}

}