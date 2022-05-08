package com.example.autenticatask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private RequestRepository requestRepository;

    String pattern = "dd/MM/yyyy hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @PostMapping("/addrequest")
    public String addRequest(@RequestParam String hardware, @RequestParam String parameters, @RequestParam String comment) {
        HardwareRequest hardwareRequest = new HardwareRequest();
        hardwareRequest.setHardware(hardware);
        hardwareRequest.setParameters(parameters);
        hardwareRequest.setComment(comment);
        hardwareRequest.setDate(simpleDateFormat.format(new Date()));
        requestRepository.save(hardwareRequest);
        return "Pieprasījums iesniegts";
    }

    @GetMapping("/myRequests")
    public List<HardwareRequest> getAllRequests(){
        List<HardwareRequest> requestsList = requestRepository.findAll();
        return requestsList;
    }
}
