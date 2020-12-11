package be.ipeters.pma.user.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.ipeters.pma.product.domain.model.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "user found: " + userId;
	}

	@GetMapping("/{userId}/invoices")
	public String displayUserInvoices(@PathVariable int userId, @RequestParam(value="date", required=false) Date date) {
		return "invoice fo user found: " + userId + " on date: " +date; // MMddyyyy
	}

	@GetMapping("/{id}/items")
	public List<String> displayStringJson(@PathVariable int id) {
		return Arrays.asList("shoes","laptop","button");
	}
	
	@GetMapping("/{id}/products_as_json")
	public List<Product> displayProductsJson(@PathVariable int id) {
		return Arrays.asList(new Product(1,"shoes",42.99),
				new Product(2,"laptop",3090.00), new Product(3,"button", 05.55));
	}
}
