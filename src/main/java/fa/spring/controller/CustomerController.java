package fa.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.spring.model.Customer;
import fa.spring.model.ResponseBodyDto;
import fa.spring.service.CustomerService;


@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			Customer returnedCustomer  = customerService.save(customer);
			pageData.setData(returnedCustomer);
			pageData.setMessage("OK");
			return new ResponseEntity<Object>(pageData, HttpStatus.OK);
			
		}catch(Exception e) {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			pageData.setMessage("Fail to post a new Customer!");
			return new ResponseEntity<Object>(pageData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id){
		try {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			Optional<Customer> optCustomer = customerService.findById(id);
			if (optCustomer.isPresent()) {
				
				pageData.setData(optCustomer.get());
				return new ResponseEntity<Object>(pageData, HttpStatus.OK);
			}else {
				pageData.setMessage("Failure -> NOT Found a customer by id = " + id);
				return new ResponseEntity<Object>(pageData, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			pageData.setMessage("Failure");
			return new ResponseEntity<Object>(pageData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		try {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			Optional<Customer> optCustomer = customerService.findById(id);
			if (optCustomer.isPresent()) {
				customerService.delete(id);
				pageData.setMessage("Successfully! Delete a Customer with id = " + id);
				return new ResponseEntity<Object>(pageData, HttpStatus.OK);
			}else {
				pageData.setMessage("Failure -> NOT Found a customer by id = " + id);
				return new ResponseEntity<Object>(pageData, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			pageData.setMessage("Failure");
			return new ResponseEntity<Object>(pageData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCustomerById(@RequestBody Customer _customer,@PathVariable Long id){
		try {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			Optional<Customer> optCustomer = customerService.findById(id);
			if (optCustomer.isPresent()) {
				Customer customer = customerService.findById(id).get();
				//set new values for customer
				customer.setFristName(_customer.getFristName());
				customer.setAge(_customer.getAge());
				customer.setAddress(_customer.getAddress());
				customer.setLastName(_customer.getLastName());
				// save the change to database
				
				customerService.save(customer);
				pageData.setMessage("Successfully! Updated a Customer "
						+ "with id = " + id);
				return new ResponseEntity<Object>(pageData, HttpStatus.OK);
			}else {
				pageData.setMessage("Failure -> NOT Found a customer by id = " + id);
				return new ResponseEntity<Object>(pageData, HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			ResponseBodyDto<Customer> pageData =  new ResponseBodyDto<>();
			pageData.setMessage("Failure");
			return new ResponseEntity<Object>(pageData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
