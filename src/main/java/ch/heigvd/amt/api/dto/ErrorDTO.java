package ch.heigvd.amt.api.dto;

public class ErrorDTO {
    private String code, message;

    public ErrorDTO() {
    }

    public ErrorDTO(String code) {
        this.code = code;
        this.message = "";
    }

    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
