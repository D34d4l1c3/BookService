package itfbstudy.transactionservise.exception;

import itfbstudy.exception.IResponse;
import itfbstudy.exception.Response;
import lombok.Getter;

public class TransactionError extends Exception implements IResponse {
    private String message = "Такая операция уже была добавлена ранее";
    private int code = 409;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

