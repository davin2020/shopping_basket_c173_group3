package com.xyz.back.Service;

import com.xyz.back.Entity.Customer;
import com.xyz.back.Persistence.CustomerDao;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    CustomerDao customerDao;


    @Override
    public int loginCheck(String customerId, String password) {

        Optional<Customer> customer = customerDao.findById(customerId);

//       System.out.println(customer.orElseGet(()->new Customer("0","No Name","0","0")));
        if (customer.isEmpty()) return 1;
        else if (customer.get().getPassword().equals(password))return 3;
        else return 2;



    }

    @Override
    public Customer addCustomer(Customer customer) {

        return customerDao.save(customer);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerDao.findByEmail(email);
    }


    //  @Autowired
 //   private RestTemplate restTemplate;




}
