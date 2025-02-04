package models.User;

import models.book_information.Book;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserHistoryBooks {
    private ObjectId userId;
    private ObjectId bookId;
    private int lastReadChapter;
    private LocalDateTime lastReadDate;
    private boolean favorite;

    public UserHistoryBooks() {
        this.lastReadChapter = 1;
    }

    public UserHistoryBooks(ObjectId userId, ObjectId bookId, int lastReadChapter, LocalDateTime lastReadDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.lastReadChapter = lastReadChapter;
        this.lastReadDate = lastReadDate;
        favorite = false;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public int getLastReadChapter() {
        return lastReadChapter;
    }

    public void setLastReadChapter(int lastReadChapter) {
        this.lastReadChapter = lastReadChapter;
    }

    public ObjectId getBookId() {
        return bookId;
    }

    public void setBookId(ObjectId bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getLastReadDate() {
        return lastReadDate;
    }

    public void setLastReadDate(LocalDateTime lastReadDate) {
        this.lastReadDate = lastReadDate;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favourite) {
        this.favorite = favourite;
    }
}
