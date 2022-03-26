package com.xyz.front.Service;

import com.xyz.front.Entity.Customer;
import com.xyz.front.Entity.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

public class SecurirtyCustomerDetails implements UserDetailsService {
	//get the value of the relevant backend api from the app.properties file
	@Value("${app.backend.urlport}") 
	private String BACKEND_URL_PORT;
	//private static final String BACKEND_URL_PORT = "http://localhost:8083";

   // @Autowired
    // CustomerDao customerDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer=restTemplate.getForObject(BACKEND_URL_PORT + "/customerByEmail/"+username, Customer.class);
       // Customer customer = customerDao.findByEmail(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerDetails(customer);
    }
}


