//package pet.store.service;
//
//import java.util.NoSuchElementException;
//import java.util.Objects;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import pet.store.controller.model.PetStoreEmployee;
//import pet.store.entity.Employee;
//import pet.store.entity.PetStore;
//
//
//public class EmployeeService {
//
//	@Transactional(readOnly = false)
//	@Autowired
//	public PetStoreEmployee saveEmployee(Long petStoreId, PetStoreEmployee petStoreEmployee) { 
//		
//		PetStore petStore = findPetStoreById(petStoreId);
//		Long employeeId = petStoreEmployee.getEmployeeId();
//		Employee employee = findOrCreateEmployee(petStoreId, employeeId);
//		
//		copyEmployeeFields(employee, petStoreEmployee);
//		
//		employee.setPetStore(petStore);
//		petStore.getEmployees().add(employee);
//		
//		Employee dbEmployee = employeeDao.save(employee);
//		
//		return new PetStoreEmployee(dbEmployee);
//	}
//
//	private void copyEmployeeFields(Employee employee, PetStoreEmployee petStoreEmployee) {
//		employee.setEmployeeFirstName(petStoreEmployee.getEmployeeFirstName());
//		employee.setEmployeeId(petStoreEmployee.getEmployeeId());
//		employee.setEmployeeJobTitle(petStoreEmployee.getEmployeeJobTitle());
//		employee.setEmployeeLastName(petStoreEmployee.getEmployeeLastName());
//		employee.setEmployeePhone(petStoreEmployee.getEmployeePhone());
//		
//		
//	}
//
//	private Employee findOrCreateEmployee(Long petStoreId, Long employeeId) {
//		if(Objects.isNull(employeeId)) {
//			return new Employee();
//	}
//		return findEmployeeById(petStoreId, employeeId);	
//	}
//
//	
//	private Employee findEmployeeById(Long petStoreId, Long employeeId) {
//		Employee employee = employeeDao.findById(employeeId)
//			.orElseThrow( () -> new NoSuchElementException(
//					"Employee with ID=" + employeeId + "was not found."));
//		
//		if(employee.getPetStore().getPetStoreId() !=petStoreId) {
//			throw new IllegalArgumentException("The employee with ID=" 
//		    + employeeId + " is not employeed by the pet store with ID=" + petStoreId + ".");
//		}
//	 
//	return employee;
//	}
//
//}
