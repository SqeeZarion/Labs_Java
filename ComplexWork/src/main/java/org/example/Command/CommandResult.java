package org.example.Command;

public class CommandResult<T> {
    private T Result;
    private String Message;
    private boolean IsSucceed;

    public CommandResult(T result, String message, boolean isSucceed) {
        Result = result;
        Message = message;
        IsSucceed = isSucceed;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isSucceed() {
        return IsSucceed;
    }

    public void setSucceed(boolean succeed) {
        IsSucceed = succeed;
    }

    public String Result() {
        return "CommandResult{" +
                "Result=" + Result +
                ", Message='" + Message + '\'' +
                ", IsSucceed=" + IsSucceed +
                '}';
    }
}
