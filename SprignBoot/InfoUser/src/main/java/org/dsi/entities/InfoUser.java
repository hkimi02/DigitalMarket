package org.dsi.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String FirstName;
	
	private String LastName;
	
	private String Email;
	
	private String Password;
	
	private String NumTlf;
	
	private String Photo;
	
	private String Cin;
	
	private String Sexe;
	
	@Column(length=999999999)
	private String PhotoCin;
	
	@ColumnDefault(value="null")
	private Boolean welcome_field; 
	
	@ColumnDefault(value="null")
	private String password_token;
	
	@UpdateTimestamp
	private Timestamp updated_at;
	
	@CreationTimestamp
	private Timestamp created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ColumnDefault(value = "null")
	private Date email_verified_at;
	
	
	
	
}