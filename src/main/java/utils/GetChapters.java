package utils;

import api.chapter_api.ApiChapterSeverData;
import api.chapter_api.ApiListChapterJson;
import api.chapter_api.one_chapter_api.ApiOneChapterJson;
import api.chapter_api.one_chapter_api.ApiOneChapterResponse;
import api.one_book_api.ApiOneBookJson;
import api.one_book_api.ApiOneBookResponse;
import com.google.gson.Gson;
import models.book_information.Book;
import models.chapter_information.AllChapters;
import models.chapter_information.Chapter;

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

        return chapter;
    }
}
