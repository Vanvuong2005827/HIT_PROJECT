package api.chapter_api.one_chapter_api;

public class ApiOneChapterResponse {
    private String status;
    private String message;
    private ApiOneChapterData data;

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

    public ApiOneChapterData getData() {
        return data;
    }

    public void setData(ApiOneChapterData data) {
        this.data = data;
    }
}
