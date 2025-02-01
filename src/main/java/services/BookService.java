package services;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import models.User.UserHistoryBooks;
import models.book_information.Book;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static DAO.ConnectDB.collectionHistory;
import static commons.CurrentUser.userAccount;

public class BookService {
    public void StorageBookToUser(Book book){
        if (!CheckIfExitBookInUser(book)){
            UserHistoryBooks userHistoryBooks = new UserHistoryBooks(userAccount.getId(), new ObjectId(book.getId()), book, 1);
            collectionHistory.insertOne(userHistoryBooks);
        }
    }

    public boolean CheckIfExitBookInUser(Book book){
        Bson filter = Filters.and(
                Filters.eq("userId", userAccount.getId()),
                Filters.eq("bookId", new ObjectId(book.getId()))
        );
        UserHistoryBooks userHistoryBooks = collectionHistory.find(filter).first();
        if (userHistoryBooks != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Book> GetAllBooks(){
        List<Book> books = new ArrayList<>();

        FindIterable<UserHistoryBooks> results = collectionHistory.find(new Document("userId", userAccount.getId()));
        for (UserHistoryBooks history : results) {
            if (history.getBook() != null) {
                books.add(history.getBook());
            }
        }

        return books;
    }
}
