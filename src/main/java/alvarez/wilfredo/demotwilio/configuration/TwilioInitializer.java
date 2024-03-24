package alvarez.wilfredo.demotwilio.configuration;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitializer {
    private static final Logger log = LoggerFactory.getLogger(TwilioInitializer.class);

    TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        log.info("Twilio initialized ... with account sid {}", twilioConfiguration.getAccountSid());
    }
}
