package data;

import api.chapter.ApiListChapterData;
import api.chapter.ApiListChapterJson;
import api.chapter.ApiOneChapterJson;
import api.chapter.ApiOneChapterResponse;
import com.google.gson.Gson;
import models.book.Book;
import models.chapter.AllChapters;
import models.chapter.Chapter;

import javax.swing.*;
import java.util.ArrayList;

import static api.ApiGet.getApi;

public class GetChapters {
    public ArrayList<AllChapters> getListChapters(Book book) {
        ArrayList<AllChapters> chapters = new ArrayList<>();
        for (ApiListChapterData a : book.getChapters()) {
            for (ApiListChapterJson b : a.getServer_data()) {
                chapters.add(new AllChapters(b.getFilename(), b.getChapter_name(), b.getChapter_api_data()));
            }
        }
        return chapters;
    }

    public Chapter getChapter(AllChapters chapters) {
        Chapter chapter = new Chapter();
        try {
            String apiUrl = chapters.getChapterData();
            String jsonData = getApi(apiUrl);
            if (jsonData != null && !jsonData.isEmpty()) {
                Gson gson = new Gson();
                ApiOneChapterResponse apiResponse = gson.fromJson(jsonData, ApiOneChapterResponse.class);
                if (apiResponse != null && apiResponse.getData() != null) {
                    ApiOneChapterJson a = apiResponse.getData().getItem();
                    chapter = new Chapter(a.getId(), a.getChapter_name(), a.getChapter_path(), a.getChapter_image());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return chapter;
    }
}
