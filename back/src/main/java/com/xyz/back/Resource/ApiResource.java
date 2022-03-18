package com.xyz.back.Resource;

import com.xyz.back.Entity.*;
import com.xyz.back.Service.CustomerDetailsService;
import com.xyz.back.Service.OrderService;
import com.xyz.back.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiResource {
    @Autowired
    private CustomerDetailsService customerService;



    @GetMapping(path = "/customerByEmail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerDetailsByUserIdResource(@PathVariable("id") String customerId) {
        return customerService.getCustomerByEmail(customerId);
    }



    @PostMapping(path = "/savecustomer",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer saveEmployeeResource(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @Autowired
    private ProductService productService;


    @GetMapping(path = "/products/{id}",produces =  MediaType.APPLICATION_JSON_VALUE)
    public Product getProductByIdResource(@PathVariable("id") int prodId) {
        return productService.getProductById(prodId);
    }

    @GetMapping(path = "/products",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductList getAllProductResource(){
        ProductList productList=new ProductList();
        productList.setProdList(productService.getAllProducts());
        return productList ;
    }

    // Get all products that match a given Type Id - similar to getAllTypeResource but returns ProductList instead of TypeList
    @GetMapping(path = "/products/type/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductList  getProductByTypeIdResource(@PathVariable("id") int typeId) {
        ProductList productList = new ProductList();
        productList.setProdList(productService.getProductByTypeId(typeId));
        return productList ;
    }

    @PostMapping(path = "/products",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProductResource(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @DeleteMapping(path = "/products/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Product deleteProductResource(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    //Get all the Types available in DB to allow searching bt type
    @GetMapping(path = "/types",produces = MediaType.APPLICATION_JSON_VALUE)
    public TypeList getAllTypeResource(){
        TypeList typeList = new TypeList();
        typeList.setTypeList(productService.getAllTypes());
        return typeList ;
    }

    //Get Type by Type ID
    @GetMapping(path = "/types/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Type getProductTypeByIdResource(@PathVariable("id") int typeId) {
        return productService.getTypeById(typeId);
    }

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders/{cId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders getOrdersByCustomerIdResource(@PathVariable("cId") String cId) {

        Orders orders = new Orders();
        orders.setOrderList(orderService.getOrderByCustomerId(cId));

        return orders;
    }

    @GetMapping(path = "/orderLines/{oId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderLines getOrderLinesByOrderIdResource(@PathVariable("oId") int oId) {

        OrderLines orderLines = new OrderLines();
        orderLines.setProductList(orderService.getProductDetails(oId));

        return orderLines;
    }

}
