package com.ug.cpm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ug.cpm.config.CustomerResultTransformer;
import com.ug.cpm.dto.CustomerDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class CustomerDtoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<CustomerDto> getAllCustomerData() {
		
		List<CustomerDto> customerDTOs = entityManager.createQuery("""
			    select c.customerId as customerId, 
			    c.customerFirstName as customerFirstName,
			    c.customerLastName as customerLastName,
			    c.customerMiddleName as customerMiddleName,
			    c.preferredName as preferredName,
				c.primaryContactNumber as primaryContactNumber,
				c.secondaryContactNumner as secondaryContactNumner,
				c.address as address,
				c.emailId as emailId,
				c.age as age,
				c.dateOfBirth as dateOfBirth,
				c.gender as gender,
				c.race as race,
				c.religion as religion,
				c.maritalStatus as maritalStatus,
 				c.ethnicity as ethnicity,
				c.hobbies as hobbies,
				c.customerType as customerType,
				c.primaryGuestId as primaryGuestId,
				c.primaryGuestRelationship as primaryGuestRelationship,
				c.createdDate as createdDate,
				c.updatedDated as updatedDated,

			    p.personality as personality,
			    p.habits as habits,
			    p.emotions as emotions,
			    
			    cp.preferenceId as preferenceId,
			    cp.preferenceType as preferenceType,
			    cp.preferenceName as preferenceName,
			    cp.preferenceCreatedDate as preferenceCreatedDate,
			    cp.preferenceUpdatedDate as preferenceUpdatedDate,
			    cp.isActive as isActive,
			    cp.isLike as isLike,
			    
			    b.bookingId as bookingId,
			    b.arrivalDate as arrivalDate,
			    b.arrivalTime as arrivalTime,
			    b.departureDate as departureDate,
			    b.departureTime as departureTime
			    
			    from Customer c left join CustomerPersonalityTrait p on c.customerId = p.customerId
			     left join CustomerPreference cp on c.customerId = cp.customerId 
			     left join CustomerBookingHistory b on c.customerId = b.customerId
			    """)
			.unwrap(org.hibernate.query.Query.class)
			//.setTupleTransformer(new CustomerResultTransformer())
			.setResultTransformer(new CustomerResultTransformer())
			.getResultList();
		
		return customerDTOs;
	} 
	
	public CustomerDto getCustomerData(int customerId) {
		
		CustomerDto customerDTO = (CustomerDto) entityManager.createQuery("""
			    select c.customerId as customerId, 
			    c.customerFirstName as customerFirstName,
			    c.customerLastName as customerLastName,
			    c.customerMiddleName as customerMiddleName,
			    c.preferredName as preferredName,
				c.primaryContactNumber as primaryContactNumber,
				c.secondaryContactNumner as secondaryContactNumner,
				c.address as address,
				c.emailId as emailId,
				c.age as age,
				c.dateOfBirth as dateOfBirth,
				c.gender as gender,
				c.race as race,
				c.religion as religion,
				c.maritalStatus as maritalStatus,
 				c.ethnicity as ethnicity,
				c.hobbies as hobbies,
				c.customerType as customerType,
				c.primaryGuestId as primaryGuestId,
				c.primaryGuestRelationship as primaryGuestRelationship,
				c.createdDate as createdDate,
				c.updatedDated as updatedDated,

			    p.personality as personality,
			    p.habits as habits,
			    p.emotions as emotions,
			    
			    cp.preferenceId as preferenceId,
			    cp.preferenceType as preferenceType,
			    cp.preferenceName as preferenceName,
			    cp.preferenceCreatedDate as preferenceCreatedDate,
			    cp.preferenceUpdatedDate as preferenceUpdatedDate,
			    cp.isActive as isActive,
			    cp.isLike as isLike,
			    
			    b.bookingId as bookingId,
			    b.arrivalDate as arrivalDate,
			    b.arrivalTime as arrivalTime,
			    b.departureDate as departureDate,
			    b.departureTime as departureTime
			    
			    from Customer c left join CustomerPersonalityTrait p on c.customerId = p.customerId
			     left join CustomerPreference cp on c.customerId = cp.customerId 
			     left join CustomerBookingHistory b on c.customerId = b.customerId
			     where c.customerId = ?1
			    """)
			.unwrap(org.hibernate.query.Query.class)
			.setParameter(1, customerId)
			.setResultTransformer(new CustomerResultTransformer())
			.getResultList().get(0);
		
		return customerDTO;
	} 
	
	/*public List<CustomerDto> getAllCustomerData() {
		@SuppressWarnings("unchecked")
		List<CustomerDto> customerDTOs = entityManager.createQuery("""
			    select c as customerDto, p as customerPersonalityTraitDto
			    from Customer c left join CustomerPersonalityTrait p on c.customerId = p.customerId
			    """)
			.unwrap(org.hibernate.query.Query.class)
			.setTupleTransformer(new CustomerResultTransformer())
			.getResultList();
		
		return customerDTOs;
	}*/
	
}
	
	
