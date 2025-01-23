package api.one_book_api.chapter_api;

import java.util.List;

public class ApiChapterSeverData {
    List<ApiListChapterJson> server_data;

    public List<ApiListChapterJson> getServer_data() {
        return server_data;
    }

    public void setServer_data(List<ApiListChapterJson> server_data) {
        this.server_data = server_data;
    }
}
