package pet.store.controller.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;

@Data
@NoArgsConstructor
public class PetStoreCustomer {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;

public PetStoreCustomer (Customer customer) {
	customerFirstName = customer.getCustomerFirstName();
	customerLastName = customer.getCustomerLastName();
	customerEmail = customer.getCustomerEmail();
}

}
