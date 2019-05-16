package com.educare.admin.model;

import java.util.List;

public class AdminUploadClientLogoModel {

	private int schoolid;
	private String school;
	private String logo;
	private int clientlogoid;
	private String carousel;
	private String contactinfo;
	private String address;
	private int contactid;
	private String emailid;
	private List<AdminUploadClientLogoModel> carousellist;

	public List<AdminUploadClientLogoModel> getCarousellist() {
		return carousellist;
	}

	public void setCarousellist(List<AdminUploadClientLogoModel> carousellist) {
		this.carousellist = carousellist;
	}

	public String getContactinfo() {
		return contactinfo;
	}

	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactid() {
		return contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getCarousel() {
		return carousel;
	}

	public void setCarousel(String carousel) {
		this.carousel = carousel;
	}

	public int getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getClientlogoid() {
		return clientlogoid;
	}

	public void setClientlogoid(int clientlogoid) {
		this.clientlogoid = clientlogoid;
	}
}
