package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class InfoController {

    @GetMapping("/info")
    public String info(){
        return "Info Controller API running -" + LocalDate.now().toString();
    }

//    @GetMapping("/info")
//    public String get() { return "This is an application designed to teach me endpoints"; }
}
