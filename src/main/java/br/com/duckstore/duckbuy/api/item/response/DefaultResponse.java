package br.com.duckstore.duckbuy.api.item.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultResponse {

    private String message;

    private boolean success;

    public DefaultResponse() {
        this.success = true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "DefaultResponse{" +
                "message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
