package lv.venta.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lv.venta.models.Ticket;

@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping("/home")
    public String home() {
        return "index.html";
    }
	
}
