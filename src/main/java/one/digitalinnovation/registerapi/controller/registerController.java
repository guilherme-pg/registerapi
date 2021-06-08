package one.digitalinnovation.registerapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talia")
public class registerController {

    @GetMapping
    public String getBook() {
        return "API TEST";
    }

}
