package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id

	private long user_id;
	@Column(name = "full_name")
	private String full_name;
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "profile_image")
	private String profile_image;

	@Column(name = "gender")
	private String gender;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;

	@Column(name = "university")
	private String university;

	@Column(name = "degre")
	private String degre;
	@Column(name = "password")
	private String password;

	@OneToMany(targetEntity = Offers.class, mappedBy = "user")
	private List<Offers> offers;

	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean confirmed_email;

	private String confirmPassword;

	public Users() {
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getProfil_image() {
		return profile_image;
	}

	public void setProfil_image(String profil_image) {
		this.profile_image = profil_image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String password) {
		this.confirmPassword = password;
	}

	public boolean isConfirmed_email() {
		return confirmed_email;
	}

	public void setConfirmed_email(boolean confirmed_email) {
		this.confirmed_email = confirmed_email;
	}

	public Users(String full_name, String user_name, String profile_image, String gender, String phone, String email,
			String university, String degre, String password, boolean confirmed_email , String confirmPassword) {
		super();
		this.full_name = full_name;
		this.user_name = user_name;
		this.profile_image = profile_image;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.university = university;
		this.degre = degre;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.confirmed_email = confirmed_email;
	}

}