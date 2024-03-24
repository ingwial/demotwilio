package alvarez.wilfredo.demotwilio.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
    private String accountSid;
    private String authToken;
    private String trialNumberSms;
    private String trialNumberWhatsapp;

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumberSms() {
        return trialNumberSms;
    }

    public void setTrialNumberSms(String trialNumberSms) {
        this.trialNumberSms = trialNumberSms;
    }

    public String getTrialNumberWhatsapp() {
        return trialNumberWhatsapp;
    }

    public void setTrialNumberWhatsapp(String trialNumberWhatsapp) {
        this.trialNumberWhatsapp = trialNumberWhatsapp;
    }
}
