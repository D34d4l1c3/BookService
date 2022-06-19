package itfbstudy.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class Response{
    private String message;
    public int code = 500;

    public Response(String message,int code) {
        this.message = message;
        this.code = code;
    }
    public Response(String message) {
        this.message = message;
    }
}