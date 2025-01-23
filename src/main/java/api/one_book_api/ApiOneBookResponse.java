package api.one_book_api;

public class ApiOneBookResponse {
    private String status;
    private String message;
    private ApiOneBookData data;

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

    public ApiOneBookData getData() {
        return data;
    }

    public void setData(ApiOneBookData data) {
        this.data = data;
    }
}
