package alvarez.wilfredo.demotwilio.service.impl;

import alvarez.wilfredo.demotwilio.configuration.TwilioConfiguration;
import alvarez.wilfredo.demotwilio.service.MessageRequest;
import alvarez.wilfredo.demotwilio.service.MessageSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessageSenderImpl implements MessageSender {
    private static final Logger log = LoggerFactory.getLogger(MessageSenderImpl.class);
    private final TwilioConfiguration twilioConfiguration;

    public MessageSenderImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(MessageRequest messageRequest) {
        if (isPhoneNumberValid(messageRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(messageRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumberSms());
            String message = messageRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            log.info("Send sms {}", messageRequest);
        } else {
            throw new IllegalArgumentException(
                     "Phonenumber [" + messageRequest.getPhoneNumber() + "] is not valid number"
            );
        }
    }

    @Override
    public void sendWhatsapp(MessageRequest messageRequest) {
        if (isPhoneNumberValid(messageRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber("whatsapp:".concat(messageRequest.getPhoneNumber()));
            PhoneNumber from = new PhoneNumber("whatsapp:".concat(twilioConfiguration.getTrialNumberWhatsapp()));
            String message = messageRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,
                    from,
                    message);
            creator.create();
            log.info("Send sms {}", messageRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phonenumber [" + messageRequest.getPhoneNumber() + "] is not valid number"
            );
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        // TODO: Implement phone number validator
        return Objects.nonNull(phoneNumber);
    }
}
