package ro.siit.model;

/**
 * DTO - Data Transfer Object
 */
public class MessageDto {

    private String email;
    private String subject;
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
