package com.example.autenticatask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    @PostMapping("/addrequest")
    public String addRequest(@RequestParam String hardware, @RequestParam String parameters, @RequestParam String comment) {
        HardwareRequest hardwareRequest = new HardwareRequest();
        hardwareRequest.setHardware(hardware);
        hardwareRequest.setParameters(parameters);
        hardwareRequest.setComment(comment);
        requestRepository.save(hardwareRequest);
        return "Request placed";
    }
}
