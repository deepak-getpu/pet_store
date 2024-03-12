//package pet.store.service;
//
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import pet.store.controller.model.PetStoreCustomer;
//import pet.store.controller.model.PetStoreEmployee;
//import pet.store.entity.Customer;
//import pet.store.entity.Employee;
//import pet.store.entity.PetStore;
//
//public class CustomerService {
//
//	@Transactional(readOnly = false)
//	@Autowired
//	public PetStoreCustomer saveCustomer(Long petStoreId, PetStoreCustomer petStoreCustomer) { 
//		
//		PetStore petStore = findPetStoreById(petStoreId);
//		Long customerId = petStoreCustomer.getCustomerId();
//		Customer customer = findOrCreateCustomer(petStoreId, customerId);
//		
//		copyCustomerFields(customer, petStoreCustomer);
//		
//		customer.getPetStores().add(petStore);
////		petStore.getCustomers().add(customer);
//		
//		Customer dbCustomer = customerDao.save(customer);
//		
//		return new PetStoreCustomer(dbCustomer);
//	}
//
//	
//	
//	private void copyCustomerFields(Customer customer, PetStoreCustomer petStoreCustomer) {
//		customer.setCustomerEmail(petStoreCustomer.getCustomerEmail());
//		customer.setCustomerFirstName(petStoreCustomer.getCustomerFirstName());
//		customer.setCustomerId(petStoreCustomer.getCustomerId());
//		customer.setCustomerLastName(petStoreCustomer.getCustomerLastName());	
//	}
//
//	private Customer findOrCreateCustomer(Long petStoreId, Long customerId) {
//		if(Objects.isNull(customerId)) {
//			return new Customer();
//	}
//		return findCustomerById(petStoreId, customerId);	
//	}
//
//	
//	private Customer findCustomerById(Long petStoreId, Long customerId) {
//		Customer customer = customerDao.findById(customerId)
//			.orElseThrow( () -> new NoSuchElementException(
//					"Customer with ID=" + customerId + "was not found."));
//		
//		boolean found = false;
//		
//		for(PetStore petStore : customer.getPetStores()) {
//		if(petStore.getPetStoreId() ==petStoreId) {
//			found = true;
//			break;
////		}
//		
//		}
//		
//		if(! found) {
//			throw new IllegalArgumentException("The customer with ID=" 
//		    + customerId + " is not a member of the pet store with ID=" + petStoreId);
//		}
//	return customer;
//	}
//
//}
