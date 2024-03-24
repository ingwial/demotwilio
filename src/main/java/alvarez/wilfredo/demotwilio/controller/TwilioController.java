package alvarez.wilfredo.demotwilio.controller;

import alvarez.wilfredo.demotwilio.service.MessageRequest;
import alvarez.wilfredo.demotwilio.service.TwilioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class TwilioController {
    private final TwilioService twilioService;

    public TwilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping(value = "/sms")
    public ResponseEntity<MessageRequest> sendSms(@Valid @RequestBody MessageRequest messageRequest) {
        this.twilioService.sendSms(messageRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/whatsapp")
    public ResponseEntity<MessageRequest> sendWhatsapp(@Valid @RequestBody MessageRequest messageRequest) {
        this.twilioService.sendWhatsapp(messageRequest);
        return ResponseEntity.ok().build();
    }
}
