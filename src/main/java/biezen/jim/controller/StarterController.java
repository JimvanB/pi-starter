package biezen.jim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by Jim on 14-4-2017.
 */
@Controller
public class StarterController {

    @RequestMapping("/start")
    public void start() throws IOException {
        Process p = Runtime.getRuntime().exec("python yourapp.py");
    }


}
