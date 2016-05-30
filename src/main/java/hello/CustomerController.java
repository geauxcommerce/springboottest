package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@RequestMapping(method=RequestMethod.POST)
	ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(repository.save(customer), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	ResponseEntity<Customer> deleteAllCustomers() {
		repository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{customer}", method=RequestMethod.DELETE)
	ResponseEntity<Customer> deleteCustomer(@PathVariable String customer) {
		Customer deleteCustomer = new Customer();
		deleteCustomer.setId(customer);
		repository.delete(deleteCustomer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{customer}", method=RequestMethod.GET)
	ResponseEntity<Customer> getCustomer(@PathVariable String customer) {
		Customer getCustomer = (Customer) repository.findOne(customer.toString());
		return Optional.ofNullable(getCustomer)
				.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	ResponseEntity<List<Customer>> findCustomer() {
		System.out.println("in find customer method");
		return new ResponseEntity<List<Customer>>(repository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/createSample", method=RequestMethod.GET)
	ResponseEntity<List<Customer>> createSampleCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		// save a couple of customers
		customers.add(repository.save(new Customer("Alice", "Smith")));
		customers.add(repository.save(new Customer("Bob", "Smith")));
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.CREATED);
	}

}
