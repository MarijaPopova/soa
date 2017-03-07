package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Created by 131513 on 3/7/2017.
 */

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/getbyid")
    public Customer getById(@RequestParam(value="id", defaultValue = "-1") Long id){
        Customer customer = customerRepository.findOne(id);
        return  customer;
    }

    @RequestMapping("/create")
    public Customer createNew(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname){
        Customer c = new Customer(name, surname);
        customerRepository.save(c);
        return c;
    }
}
