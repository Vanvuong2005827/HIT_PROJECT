package models.User;

import models.book_information.Book;
import org.bson.types.ObjectId;

public class UserHistoryBooks {
    private ObjectId userId;
    private ObjectId bookId;
    private Book book;
    private int lastReadChapter;

    public UserHistoryBooks() {
        this.lastReadChapter = 1;
    }

    public UserHistoryBooks(ObjectId userId, ObjectId bookId, Book book, int lastReadChapter) {
        this.userId = userId;
        this.bookId = bookId;
        this.book = book;
        this.lastReadChapter = lastReadChapter;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
}
