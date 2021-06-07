package fa.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fa.spring.model.Customer;

public interface CustomerService {
	Customer save(Customer customer);
	List<Customer> findAll();
	void delete(Long id );
	 Optional<Customer> findById(Long id);

}
