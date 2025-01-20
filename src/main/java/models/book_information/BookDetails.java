package models.book_information;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDetails {
    @SerializedName("_id")
    private String id;
    private String name;
    private String slug;
    private String status;
    @SerializedName("thumb_url")
    private String thumbUrl;
    private List<BookCategory> category;
    private String updatedAt;
    private List<BookChapter> chapters;

    // Getters, Setters và hàm để lấy URL đầy đủ của chapter
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

    public List<BookCategory> getCategory() {
        return category;
    }

    public void setCategory(List<BookCategory> category) {
        this.category = category;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<BookChapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<BookChapter> chaptersLatest) {
        this.chapters = chaptersLatest;
    }

    // Tạo danh sách URL đầy đủ cho chapters
    public List<String> getChapterUrls() {
        return chapters.stream()
                .map(chapter -> "https://otruyenapi.com/v1/api/truyen-tranh/" + slug)
                .toList();
    }
}
