package fa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.spring.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
