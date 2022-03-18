package com.xyz.front.Service;

import com.xyz.front.Entity.Customer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public int loginCheck(String customerId, String password) {

       // Optional<Customer> customer = customerDao.findById(customerId);
        Customer customer= restTemplate.getForObject("http://localhost:8082/customerByEmail/"+customerId, Customer.class);
//       System.out.println(customer.orElseGet(()->new Customer("0","No Name","0","0")));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        if (customer == null) return 1;
        else if (customer.getPassword().equals(encodedPassword))return 3;
        else return 2;



    }



    //  @Autowired
 //   private RestTemplate restTemplate;




}
