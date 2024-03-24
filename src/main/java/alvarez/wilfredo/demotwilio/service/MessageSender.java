package alvarez.wilfredo.demotwilio.service;

public interface MessageSender {
    void sendSms(MessageRequest messageRequest);
     void sendWhatsapp(MessageRequest messageRequest);
}
