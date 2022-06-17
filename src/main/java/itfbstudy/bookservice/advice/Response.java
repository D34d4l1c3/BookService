package itfbstudy.bookservice.advice;

public class Response {
    private String message;
    public int code;

    public Response() {
    }
    public Response(String message,int code) {
        this.message = message;
        this.code = code;
    }
    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}