package services;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import models.User.UserHistoryBooks;
import models.book_information.Book;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static DAO.ConnectDB.collectionBook;
import static DAO.ConnectDB.collectionHistory;
import static commons.CurrentUser.userAccount;

public class BookService {
    public void storageBookToUser(ObjectId bookId){
        if (!checkIfExitBookInUser(bookId)){
            UserHistoryBooks userHistoryBooks = new UserHistoryBooks(userAccount.getId(), bookId, 1, LocalDateTime.now());
            collectionHistory.insertOne(userHistoryBooks);
        } else {

        }
    }

    public int getLastReadIndexChapter(ObjectId bookId){
        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", bookId)
        );
        return collectionHistory.find(filter).first().getLastReadChapter();
    }

    public void saveLastReadChapter(ObjectId bookId, double chapter){
        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", bookId)
        );

        collectionHistory.updateOne(
                filter,
                Updates.set("lastReadChapter", chapter)
        );
    }

    public boolean checkIfExitBookInUser(ObjectId bookId){
        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", bookId)
        );
        UserHistoryBooks userHistoryBooks = collectionHistory.find(filter).first();
        if (userHistoryBooks != null) {
            collectionHistory.updateOne(
                    filter,
                    Updates.set("lastReadDate", LocalDateTime.now())
            );
            return true;
        } else {
            return false;
        }
    }

    public void insertBookToDB(Book book){
        collectionBook.updateOne(
                Filters.eq("_id", book.getId()),
                new Document("$setOnInsert", book),
                new UpdateOptions().upsert(true)
        );
    }

    public Book getBookById(ObjectId bookId){
        return collectionBook.find(Filters.eq("_id", bookId)).first();
    }

    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> books = new ArrayList<>();

        FindIterable<UserHistoryBooks> results = collectionHistory.find(new Document("userId", userAccount.getId())).sort(Sorts.descending("lastReadDate"));
        for (UserHistoryBooks history : results) {
            Book book = getBookById(history.getBookId());
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }

    public void toggleFavorite(ObjectId bookId, Color level) {
        storageBookToUser(bookId);

        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", bookId)
        );

        UserHistoryBooks result = collectionHistory.find(filter).first();

        boolean isFavorite = false;

        if (result != null && result.getFavorite()) {
            isFavorite = result.getFavorite();
        }

        if (result == null || !result.getFavorite()) {
            collectionHistory.updateOne(
                    filter,
                    Updates.set("favorite", false),
                    new UpdateOptions().upsert(true)
            );
        }

        boolean newFavoriteStatus = (level == Color.red);

        collectionHistory.updateOne(
                filter,
                Updates.set("favorite", newFavoriteStatus),
                new UpdateOptions().upsert(true)
        );

    }


    public ArrayList<Book> getAllFavorites(ObjectId bookId) {
        ArrayList<Book> books = new ArrayList<>();

        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("favorite", true)
        );

        FindIterable<UserHistoryBooks> results = collectionHistory.find(filter)
                .sort(Sorts.descending("lastReadDate"));
        for (UserHistoryBooks history : results) {
            Book book = getBookById(history.getBookId());
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }

    public Color checkFavorite(ObjectId bookId) {
        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", bookId)
        );

        UserHistoryBooks result = collectionHistory.find(filter).first();

        if (result == null || !result.getFavorite()) {
            return Color.gray;
        }

        boolean isFavorite = result.getFavorite();
        return isFavorite ? Color.red : Color.gray;

    }



}
