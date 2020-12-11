package be.ipeters.pma.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

	@GetMapping(value = {"","/Hello"}) //(value = {"/userDetails", "/userDetails/edit/{id}"}
	public String sayHello() {
		return "<h1>Hello</h1>";
	}
	
	@GetMapping(value = "/proper") //(value = {"/userDetails", "/userDetails/edit/{id}"}
	public String sayProperHello() {
		return "<h1>Hello there, how are you?</h1>";
	}
	
	@GetMapping(value = "/user_entry")
	public String userForm() {
		return
		  "<form action=\"/greeting/user_greeting\" method=\"POST\">\r\n"
		+ "  <label for=\"fname\">First name:</label><br>\r\n"
		+ "  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"John\"><br>\r\n"
		+ "  <label for=\"lname\">Last name:</label><br>\r\n"
		+ "  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"Doe\"><br><br>\r\n"
		+ "  <input type=\"submit\" value=\"Submit\">\r\n"
		+ "</form> ";
	}
	
	@PostMapping(value = "/user_greeting")
	public String printUserGreeting(@RequestParam String fname, @RequestParam String lname) {
		
		return "form submitted, Hello there, "+ fname + " " + lname;
	}
	
	@GetMapping(value = "/orders/{id}")
	public String getOrder(@PathVariable String id) {
		
		return "Order Id: " + id ;
		
	}
}
