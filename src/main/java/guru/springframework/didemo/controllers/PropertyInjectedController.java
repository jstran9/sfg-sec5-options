package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

public class PropertyInjectedController {
    public GreetingServiceImpl greetingService;

    String sayHello() {
        return greetingService.sayGreeting();
    }
}
