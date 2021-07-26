package ro.siit.model;

import ro.siit.validator.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * DTO - Data Transfer Object
 */
public class MessageDto {

    @NotBlank
    @Email
    @UniqueEmail(message = "email.in.use")
    private String email;

    @NotBlank
    @Size(min = 3, max = 255)
    private String subject;

    @NotBlank
    @Size(min = 5, max = 2000)
    private String body;

    public MessageDto() {
    }

    public MessageDto(final String email, final String subject, final String body) {
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
