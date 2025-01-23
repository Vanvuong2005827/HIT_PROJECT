package api.one_book_api;

import api.one_book_api.chapter_api.ApiChapterSeverData;
import com.google.gson.annotations.SerializedName;
import models.book_information.BookAuthor;
import models.book_information.BookCategory;

import java.util.List;

public class ApiOneBookJson {
    @SerializedName("_id")
    private String id;
    private String name;
    private String slug;
    private String content;
    private String status;
    @SerializedName("thumb_url")
    private String thumbUrl;
    private List<BookAuthor> author;
    private List<BookCategory> category;
    private List<ApiChapterSeverData> chapters;
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public List<BookAuthor> getAuthor() {
        return author;
    }

    public void setAuthor(List<BookAuthor> author) {
        this.author = author;
    }

    public List<BookCategory> getCategory() {
        return category;
    }

    public void setCategory(List<BookCategory> category) {
        this.category = category;
    }

    public List<ApiChapterSeverData> getChapters() {
        return chapters;
    }

    public void setChapters(List<ApiChapterSeverData> chapters) {
        this.chapters = chapters;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
