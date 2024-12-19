package com.cdac.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass//class level JPA annotation to specify following is a common base
//class from which all other entities will be derived . no table.
@Getter//lombok notattion all 3 below
@Setter
@ToString
public class BaseEntity {
	// id prop MUST be - Serializable
	@Id // PK
		// For auto ID generation using auto increment constraint -
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column // column name - user_id
	private Long id; // mapped to PK
	// creation date
	@CreationTimestamp
	@Column(name="created_on")
	private LocalDate createdOn;
	// updataion time stamp
	@UpdateTimestamp
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
//	@Version //used for optimistic locking
//	private int entityVersion;

}
