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

    @Autowired                                                                      //@Autowired, laikam ir kaut kas līdzīgs kā veidot jaunu klases objektu
    private RequestRepository requestRepository;                                    //Izveido RequestRepository instanci (objektu)

    String pattern = "dd/MM/yyyy hh:mm:ss";                                         //Sagatavo reģistrācijas laika formātu.
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    //Izveido jaunu HardwareRequest objektu, kuram, izmantojot seterus, padod lietotāja ievadītos parametrus
    //Tiek saglabāts reģistrācijas laiks objektā
    //Visi objekta mainīgie tiek saglabāti datu bāzē, izmantojot requestRepository.save() metodi.
    @PostMapping("/addrequest")                                                    //Izmanto, lai norādītu, kādas darbības jāveic, ja no index.html faila tiek izsaukta ("/addrequest") komanda
    public String addRequest(@RequestParam String hardware, @RequestParam String parameters, @RequestParam String comment) {
        HardwareRequest hardwareRequest = new HardwareRequest();
        hardwareRequest.setHardware(hardware);
        hardwareRequest.setParameters(parameters);
        hardwareRequest.setComment(comment);
        hardwareRequest.setDate(simpleDateFormat.format(new Date()));
        requestRepository.save(hardwareRequest);
        return "Pieprasījums iesniegts";
    }

    //Atgriež sarakstu ar visām datubāzes vērtībām
    @GetMapping("/myRequests")
    public List<HardwareRequest> getAllRequests(){
        List<HardwareRequest> requestsList = requestRepository.findAll();
        return requestsList;
    }

    //Dzēš no datubāzes rindu ar lietotāja norādīto id.
    @GetMapping("/deleteRequest")
    public String deleteRequest(@RequestParam Integer id) {
        requestRepository.deleteById(id);
        return "Pieprasījums dzēsts";
    }
}
