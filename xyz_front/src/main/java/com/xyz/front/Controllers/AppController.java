package com.xyz.front.Controllers;


import com.xyz.front.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class AppController {
	//private static final String BACKEND_URL_PORT = "http://localhost:8083";
	
  //  @Autowired
 //   CustomerDao customerDao;

//	 @Value("${app.title}")
//	 private String appTitle;
	 
    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping("/mytitle")
//    public String getValue(){
//    	System.out.println("__ Applicatoin /mytitle = " + appTitle);
//        return "index";
//    }
    
	//get the value of the relevant backend api from the app.properties file - test this
	@Value("${app.backend.urlport}") 
	private String BACKEND_URL_PORT;
    
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/demo")
    public String viewdemo(){
        return "demo";
    }
    @GetMapping("/demo2")
    public String viewdemo2(){
        return "index3";
    }
    @GetMapping("/loginregister")
    public String viewLoginRegister(Model model){
        model.addAttribute("customer", new Customer());
        return "newlogin";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "signup_form";
    }
    @GetMapping("/main")
    public String showMainForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "main";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        model.addAttribute("customer", new Customer());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "newlogin";
        }

        return "redirect:/";
    }
    
    //after registering should  this auto-login the user?
    @PostMapping("/process_register")
    public String processRegister(Customer user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Customer customer= restTemplate.postForObject(BACKEND_URL_PORT + "/savecustomer/", user, Customer.class);
//
       // customerDao.save(user);

        return "register_success";
    }

}
