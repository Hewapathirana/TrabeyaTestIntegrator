package noetic.example.codetest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DS hewapathirana.
 * Date:24/02/2020
 * Time: 9:10 PM
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public  String welcome() {

        return "Integrator Service Started";
    }
}
