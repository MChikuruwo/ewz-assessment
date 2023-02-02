package zw.co.ewz.assessment.business.dto.response;


import java.io.Serializable;

public record ApiResponse(int statusCode, String message, Object responseBody) implements Serializable {

    public ApiResponse(int statusCode, String message) {
        this(statusCode, message, null);
    }
}