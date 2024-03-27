package br.com.duckstore.duckbuy.api.auth.response;

public class TokenValidateResponse {

    private String message;
    private boolean success;

    public TokenValidateResponse() {
    }

    public TokenValidateResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "JwtValidationResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
