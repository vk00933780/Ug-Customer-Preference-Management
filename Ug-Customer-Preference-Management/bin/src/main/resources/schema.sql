CREATE TABLE T_CPM_Customer(
	Customer_Id INT NOT NULL AUTO_INCREMENT,
	Customer_FirstName VARCHAR(500) NULL,
	Customer_LastName VARCHAR(500) NULL,
	Customer_MiddleName VARCHAR(500) NULL,
	Customer_PreferredName VARCHAR(500) NULL,
	Primary_ContactNumber VARCHAR(50) NULL,
	Secondary_ContactNumber VARCHAR(50) NULL,
	Address VARCHAR(500) NULL,
	Email VARCHAR(200) NULL,
	Customer_Age INT NULL,
	Customer_DOB VARCHAR(50) NULL,
	Customer_Gender VARCHAR(50) NULL,
	Customer_Race VARCHAR(200) NULL,
	Customer_Religion VARCHAR(200) NULL,
	Customer_MaritalStatus VARCHAR(50) NULL,
	Customer_Ethnicity VARCHAR(200) NULL,
	Hobbies VARCHAR(500) NULL,
	Customer_Type VARCHAR(200) NULL,	-- Primary Guest | Family Member
	CustomerId_SourceSystem INT NULL,
	PrimaryGuest_Customer_Id INT NULL,	-- Primary Guest For Family Member
	PrimaryGuest_CustomerRelationship VARCHAR(200) NULL,	-- Husband | Wife | Son | Daughter
	Image_Path	VARCHAR(500) NULL,
	Customer_Id_IDAM VARCHAR(200) NULL,	-- For Future Use
	VisitorPass_Id VARCHAR(200) NULL,	-- For Future Use
	National_Id VARCHAR(200) NULL,		-- For Future Use
	NEOM_Id VARCHAR(200) NULL,			-- For Future Use
	MELD_Consent VARCHAR(1) NULL,	-- Y | N
	Created_On DATETIME NULL DEFAULT current_timestamp(),
	Last_Updated_On DATETIME NULL,
	PRIMARY KEY (Customer_Id)
);

CREATE TABLE T_CPM_Preference(
	Preference_Id INT NOT NULL,
	Preference_Type VARCHAR(500) NULL,	-- Lifestyle | Sport | Privacy | Restaurant | Food
	Preference_Name VARCHAR(500) NULL,	-- Music | Golf | SMS | Hotel Sun | Pasta
	Preference_Description VARCHAR(500) NULL,
	Created_On DATETIME NULL DEFAULT current_timestamp(),
	Last_Updated_On DATETIME NULL,
	PRIMARY KEY (Preference_Id)
);

CREATE TABLE T_CPM_CustomerPreference(
	Id INT NOT NULL AUTO_INCREMENT,
	Customer_Id INT NOT NULL,
	Customer_FirstName VARCHAR(500) NULL,
	Customer_LastName VARCHAR(500) NULL,
	Customer_MiddleName VARCHAR(500) NULL,
	Customer_Type VARCHAR(200) NULL,	-- Primary Guest | Family Member
	Preference_Id INT NULL,
	Preference_Type VARCHAR(500) NULL,	-- Lifestyle | Sport | Privacy | Restaurant | Food
	Preference_Name VARCHAR(500) NULL,	-- Music | Golf | SMS | Hotel Sun | Pasta
	Preference_CreatedOn DATETIME NULL,
	Preference_LastUpdatedOn DATETIME NULL,					
	IsActive boolean NULL,	-- Y | N
	IsLike boolean NULL,	-- Y | N
	Created_On DATETIME NULL DEFAULT current_timestamp(),
	Last_Updated_On DATETIME NULL,
	PRIMARY KEY (Id)
	--FOREIGN KEY (Customer_Id) REFERENCES T_CPM_Customer(Customer_Id),
	--FOREIGN KEY (Preference_Id) REFERENCES T_CPM_Preference(Preference_Id)
); 

