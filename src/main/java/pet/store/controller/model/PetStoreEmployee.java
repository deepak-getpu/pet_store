package pet.store.controller.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Employee;

@Data
@NoArgsConstructor
public class PetStoreEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;

public PetStoreEmployee(Employee employee) {
	employeeFirstName = employee.getEmployeeFirstName();
	employeeLastName = employee.getEmployeeLastName();
	employeePhone = employee.getEmployeePhone();
	employeeJobTitle = employee.getEmployeeJobTitle();
}
}
