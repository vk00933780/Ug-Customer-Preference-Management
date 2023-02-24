package com.ug.cpm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_CPM_PreferenceMaster")
public class Preference {

	@Id
	@Column(name = "Preference_Id", nullable = false)
	private int preferenceId;
	
	@Column(name = "Preference_Type")
	private String preferenceType;
	
	@Column(name = "Preference_Name")
	private String preferenceName;
	
	@Column(name = "Preference_Description")
	private String preferenceDescription;
	
}
