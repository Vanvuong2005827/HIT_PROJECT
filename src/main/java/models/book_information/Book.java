package models.book_information;


import java.util.List;

public class Book {
    private String name;
    private String status;
    private String updatedAt;
    private String thumbnail;
    private List<BookCategory> category;

    public Book(String name, String status, String updatedAt, String thumbnail, List<BookCategory> category) {
        this.name = name;
        this.status = status;
        this.updatedAt = updatedAt;
        this.thumbnail = thumbnail;
        this.category = category;
    }

    public Book(String name){
        this.name = name;
    }

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
}
