package com.paripassu.bankpass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "number")
	private String number;	
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "is_attending")
	private Boolean is_attending;
	
	
	

	public Ticket() {
		
	}
	
	public Ticket(String type, String number, String status, Boolean is_attending) {
		super();
		this.type = type;
		this.number = number;
		this.status = status;
		this.is_attending = is_attending;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

	public Boolean getIs_attending() {
		return is_attending;
	}

	public void setIs_attending(Boolean is_attending) {
		this.is_attending = is_attending;
	}

	@Override
	public String toString() {
		return "Ticket [type=" + type + ", number=" + number + "]";
	}
	
}
