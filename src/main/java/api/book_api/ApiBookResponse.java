package api.book_api;

public class ApiBookResponse {
    private String status;
    private String message;
    private ApiBookData data;

    // Getters và Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiBookData getData() {
        return data;
    }

    public void setData(ApiBookData data) {
        this.data = data;
    }
}
