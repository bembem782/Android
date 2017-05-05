package com.example.contact;

public class Contact {

	private int image;
	private String name,tel,sms;
	public Contact(int image, String name, String tel, String sms) {
		super();
		this.image = image;
		this.name = name;
		this.tel = tel;
		this.sms = sms;
		
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSms(){
		return sms;	
	}
	public void setSms(String sms){
		this.sms = sms;
		
	}
	
}
