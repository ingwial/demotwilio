package alvarez.wilfredo.demotwilio.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class MessageRequest {
    @NotBlank
    private final String phoneNumber; //destination
    @NotBlank
    private final String message;

    public MessageRequest(@JsonProperty("phoneNumber") String phoneNumber,
                          @JsonProperty("message") String message
    ) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
