package de.bithackaton.rest;



import java.util.concurrent.atomic.AtomicLong;

import de.bithackaton.model.Navigation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Navigation greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Navigation(counter.incrementAndGet(),
                String.format(template, name));
    }
}