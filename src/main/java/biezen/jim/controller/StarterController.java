package biezen.jim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * Created by Jim on 14-4-2017.
 */
@Controller
public class StarterController {

    @RequestMapping("/start")
    public String start() throws IOException {
        Process p = Runtime.getRuntime().exec("python /home/pi/dev/pi-motion/pi-motion/pi-surveillance.py --conf conf.json");
        return "Started";
    }

    @RequestMapping("/stop")
    public String stop(){
        return "Stop";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


}
