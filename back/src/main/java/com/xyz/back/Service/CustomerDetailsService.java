package com.xyz.back.Service;

import com.xyz.back.Entity.Customer;

public interface CustomerDetailsService {
    public int loginCheck(String customerId, String password);
    public Customer addCustomer(Customer customer);
    public Customer getCustomerByEmail(String email);

}
