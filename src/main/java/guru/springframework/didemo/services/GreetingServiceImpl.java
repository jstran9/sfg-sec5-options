package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETING_MESSAGE = "Greeting from GreetingServiceImpl! Hello Gurus!";

    @Override
    public String sayGreeting() {
        return GREETING_MESSAGE;
    }
}
