package models.book_information;

import com.google.gson.annotations.SerializedName;

public class BookChapter {
    @SerializedName("chapter_api_data")
    private String apiData;

    // Getter và Setter
    public String getApiData() {
        return apiData;
    }

    public void setApiData(String apiData) {
        this.apiData = apiData;
    }
}
