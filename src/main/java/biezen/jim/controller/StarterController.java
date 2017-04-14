package biezen.jim.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Jim on 14-4-2017.
 */


@RestController
public class StarterController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/start")
    public String start() throws IOException {
        Process p = Runtime.getRuntime().exec("python /home/pi/dev/pi-motion/pi-motion/pi-surveillance.py --conf conf.json");
        return "Started";
    }

}