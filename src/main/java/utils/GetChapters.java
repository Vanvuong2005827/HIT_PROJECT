package utils;

import api.chapter_api.ApiChapterSeverData;
import api.chapter_api.ApiListChapterJson;
import models.book_information.Book;
import models.chapter_information.Chapters;

import java.util.ArrayList;

public class GetChapters {
    public ArrayList<Chapters> getListChapters(Book book){
        ArrayList<Chapters> chapters = new ArrayList<>();
        for(ApiChapterSeverData a : book.getChapters()){
            for(ApiListChapterJson b : a.getServer_data()){
                chapters.add(new Chapters(b.getFilename(), b.getChapter_name()));
            }
        }
        return chapters;
    }
}
