package org.free13.rubik.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */
@RestController
@RequestMapping(value = "/exec")
public class ExeController {

    @Autowired
    private Codability codability;

    // curl -X GET -H "Content-Type: application/json" -d '{"command":"ls"}' http://localhost:8080/exec/command
    @GetMapping(value = "/command")
    public String  executeCommand(@RequestParam String command) {
        return codability.execute(command);
    }

}
