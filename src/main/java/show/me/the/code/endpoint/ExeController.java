package show.me.the.code.endpoint;


import org.springframework.web.bind.annotation.*;
import show.me.the.code.codable.Codability;

@RestController
@RequestMapping(value = "/exec")
public class ExeController {

    // curl -X GET -H "Content-Type: application/json" -d '{"command":"ls"}' http://localhost:8080/exec/command
    @GetMapping(value = "/command")
    public String  executeCommand(@RequestParam String command) {
        return Codability.getInstance().exec(command);
    }

}
