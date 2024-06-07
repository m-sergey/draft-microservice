package dev.mamre.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EchoController {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/ping",
            produces = { "application/json" }
    )
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
}
