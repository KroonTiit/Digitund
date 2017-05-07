package com.digitund;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Controller {
	@RequestMapping("/showAllUsers")
	
    public String showAllUsers(){
    	return "siin";
    }
}
