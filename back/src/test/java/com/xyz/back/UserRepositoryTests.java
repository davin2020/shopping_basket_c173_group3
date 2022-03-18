package com.xyz.back;

import com.xyz.back.Entity.Customer;
import com.xyz.back.Entity.Type;
import com.xyz.back.Persistence.CustomerDao;
import com.xyz.back.Persistence.TypeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private TypeDao typeDao;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setCustomerId("vcbcvbv");
        customer.setCustomerName("nbvnbv");
        customer.setPassword("nvbnbvn");
        customer.setCustomerEmail("vbnbvnbv");

        Customer savedCustomer =  customerDao.save(customer);

        Customer existCustomer =  entityManager.find(Customer.class,savedCustomer.getCustomerId());

        assertThat(existCustomer.getCustomerEmail()).isEqualTo(customer.getCustomerEmail());
    }
    @Test
    public void testCreateType(){
        Type t1 = new Type(111, "Books", 0.0);
        Type t2 = new Type(222, "CDs", 10.0);
        Type t3 = new Type(333, "Cosmetics", 12.0);
        Type t4 = new Type(444, "DVDs", 20.0);
        Type t0 = typeDao.save(t1);
        typeDao.save(t2);
        typeDao.save(t3);
        typeDao.save(t4);

        assertThat(t0.getTypeId()).isEqualTo(t1.getTypeId());
    }
    @Test
    public  void  testFindUserByEmail(){
        String email = "n@test.com";
        Customer customer =  customerDao.findByEmail(email);
        assertThat(customer).isNotNull();

    }

}
