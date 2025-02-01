package services;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import models.User.UserHistoryBooks;
import models.book_information.Book;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static DAO.ConnectDB.collectionBook;
import static DAO.ConnectDB.collectionHistory;
import static commons.CurrentUser.userAccount;

public class BookService {
    public void StorageBookToUser(ObjectId bookId){
        if (!CheckIfExitBookInUser(bookId)){
            UserHistoryBooks userHistoryBooks = new UserHistoryBooks(userAccount.getId(), bookId, 1);
            collectionHistory.insertOne(userHistoryBooks);
        }
    }

    public boolean CheckIfExitBookInUser(ObjectId bookId){
        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", bookId)
        );
        UserHistoryBooks userHistoryBooks = collectionHistory.find(filter).first();
        if (userHistoryBooks != null) {
            return true;
        } else {
            return false;
        }
    }

    public void InsertBookToDB(Book book){
        collectionBook.updateOne(
                Filters.eq("_id", book.getId()),
                new Document("$setOnInsert", book),
                new UpdateOptions().upsert(true)
        );
    }

    public Book getBookById(ObjectId bookId){
        return collectionBook.find(Filters.eq("_id", bookId)).first();
    }

    public List<Book> GetAllBooks(){
        List<Book> books = new ArrayList<>();

        FindIterable<UserHistoryBooks> results = collectionHistory.find(new Document("userId", userAccount.getId()));
        for (UserHistoryBooks history : results) {
            Book book = getBookById(history.getBookId());
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }
}
