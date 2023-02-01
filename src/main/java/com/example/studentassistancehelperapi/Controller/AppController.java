package com.example.studentassistancehelperapi.Controller;
import com.example.studentassistancehelperapi.Model.Mail;
import com.example.studentassistancehelperapi.Service.MailService;
import com.example.studentassistancehelperapi.Util.MailThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {
    @Autowired
   private MailService mailService;

    @PostMapping(value = "/api/mail",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendEmail(@RequestBody Mail request) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", request.getName());
        model.put("usn", request.getUsn());
        model.put("url", request.getUrl());
        model.put("type",request.getType());
        for(String to : request.getTo()){
           new Thread(new MailThread(mailService,request,model,to)).start();
        }
    }
}