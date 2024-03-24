package alvarez.wilfredo.demotwilio.service;

import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    private final MessageSender messageSender;

    public TwilioService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendSms(MessageRequest messageRequest) {
        this.messageSender.sendSms(messageRequest);
    }

    public void sendWhatsapp(MessageRequest messageRequest) {
        this.messageSender.sendWhatsapp(messageRequest);
    }

}
