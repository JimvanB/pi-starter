package biezen.jim.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public void runProgram(String program) throws InterruptedException, IOException
    {
        Process proc = Runtime.getRuntime().exec (program);
        InputStream progOutput = proc.getInputStream ();
        InputStreamReader inputReader=new InputStreamReader(progOutput);
        BufferedReader reader = new BufferedReader(inputReader);
        String line;
        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }
        if (0 == proc.waitFor ()) {
            System.out.println("Process completed successfully");
        }
        else
        {
            System.out.println("Their was some issue while running the program");
        }
    }

}