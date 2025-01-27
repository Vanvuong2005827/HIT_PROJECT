package models.book_information;


import api.one_book_api.chapter_api.ApiChapterSeverData;

import java.util.List;

public class Book {
    private String name;
    private String slug;
    private String status;
    private String updatedAt;
    private String thumbnail;
    private List<BookCategory> category;
    private List<BookChapterLastest> chapterLastests;

    private String content;
    private List<ApiChapterSeverData> chapters;

    public Book() {
    }

    public Book(String name, String slug, String status, String updatedAt, String thumbnail, List<BookCategory> category, List<BookChapterLastest> chapterLastests) {
        this.name = name;
        this.slug = slug;
        this.status = status;
        this.updatedAt = updatedAt;
        this.thumbnail = thumbnail;
        this.category = category;
        this.chapterLastests = chapterLastests;
    }
    public Book(String name, String slug, String content, String status, String thumbnail, List<BookCategory> category, List<ApiChapterSeverData> chapters, String updatedAt) {
        this.name = name;
        this.slug = slug;
        this.content = content;
        this.status = status;
        this.thumbnail = thumbnail;
        this.category = category;
        this.chapters = chapters;
        this.updatedAt = updatedAt;
    }

    public Book(String name){this.name = name;}

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BookCategory> getCategory() {
        return category;
    }

    public void setCategory(List<BookCategory> category) {
        this.category = category;
    }

    public List<BookChapterLastest> getChapterLastests() {
        return chapterLastests;
    }

    public void setChapterLastests(List<BookChapterLastest> chapterLastests) {
        this.chapterLastests = chapterLastests;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ApiChapterSeverData> getChapters() {
        return chapters;
    }

    public void setChapters(List<ApiChapterSeverData> chapters) {
        this.chapters = chapters;
    }
}
