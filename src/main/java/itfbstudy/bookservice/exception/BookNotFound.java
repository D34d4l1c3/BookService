package itfbstudy.bookservice.exception;

import itfbstudy.exception.IResponse;
public class BookNotFound extends RuntimeException implements IResponse {
    private final String message = "Такого книги не существует";
    private final int code = 404;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}