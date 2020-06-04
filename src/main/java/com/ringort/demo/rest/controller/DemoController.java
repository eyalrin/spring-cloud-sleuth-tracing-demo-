package com.ringort.demo.rest.controller;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final Tracer tracer;

    @RequestMapping("/")
    public String index() {
        log.info("In controller");
        return tracer.currentSpan().context().toString();
    }
}
