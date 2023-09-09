package dev.ashwani.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDto {
    private HttpStatus errorCode;
    private String errorMessage;

    public ExceptionDto(HttpStatus status, String message){
        this.errorCode = status;
        this.errorMessage = message;
    }
}
