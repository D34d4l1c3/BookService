package itfbstudy.exception;

import org.springframework.stereotype.Component;

@Component
public interface IResponse {
    int getCode();
    String getMessage();
}
