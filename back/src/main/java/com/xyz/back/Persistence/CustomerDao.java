package com.xyz.back.Persistence;

import com.xyz.back.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer,String> {

    @Query("from Customer where customerId=:customerId and password=:password")
    public Customer findUserByUserNameAndPassword(@Param("customerId") String customerId, @Param("password") String password);

    // REVIEW how come this is working with a SELECT keyword like normal SQL ? maybe 
    // FYI Customer refers to Object rather than Table - so maybe query has to refer to objects and properties, rather than table/field names when writing JOIN queries in HQL?
    @Query("SELECT u FROM Customer u WHERE u.customerEmail = ?1")
    public Customer findByEmail(String customerEmail);
}
