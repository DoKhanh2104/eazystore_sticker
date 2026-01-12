package com.devithedev.eazystore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/dummy")
public class DummyController {

    @GetMapping("/search")
    public String search() {
        return "hihi";
    }

}
