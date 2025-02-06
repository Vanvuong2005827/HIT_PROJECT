package data;

import api.list_chapter_api.ApiChapterSeverData;
import api.list_chapter_api.ApiListChapterJson;
import api.one_chapter_api.ApiOneChapterJson;
import api.one_chapter_api.ApiOneChapterResponse;
import com.google.gson.Gson;
import models.book_information.Book;
import models.chapter_information.AllChapters;
import models.chapter_information.Chapter;

import javax.swing.*;
import java.util.ArrayList;

import static api.ApiGet.getApi;

public class GetChapters {
    public ArrayList<AllChapters> getListChapters(Book book) {
        ArrayList<AllChapters> chapters = new ArrayList<>();
        for (ApiChapterSeverData a : book.getChapters()) {
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
