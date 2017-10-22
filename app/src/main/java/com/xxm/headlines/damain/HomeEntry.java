package com.xxm.headlines.damain;

/**
 *主页实体类
 */
public class HomeEntry {

    private String error_code;  //错误码
    private String reason;      //原因
    private DisplayResult result; //

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DisplayResult getResult() {
        return result;
    }

    public void setResult(DisplayResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HomeEntry [error_code=" + error_code + ", reason=" + reason + ", result=" + result + "]";
    }


}
