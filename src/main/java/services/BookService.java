package services;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import models.user.UserHistoryBooks;
import models.book_information.Book;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static dao.ConnectDB.collectionBook;
import static dao.ConnectDB.collectionHistory;
import static commons.CurrentUser.userAccount;

public class BookService {
    public void storageBookToUser(ObjectId bookId) {
        try {
            if (!checkIfExitBookInUser(bookId)) {
                UserHistoryBooks userHistoryBooks = new UserHistoryBooks(userAccount.getId(), bookId, 1, LocalDateTime.now());
                collectionHistory.insertOne(userHistoryBooks);
            }
        } catch (NullPointerException e) {
            System.err.println("Lỗi: userAccount hoặc bookId bị null.");
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu sách vào user: " + e.getMessage());
        }
    }

    public int getLastReadIndexChapter(ObjectId bookId) {
        try {
            Bson filter = Filters.and(Filters.eq("userId", userAccount.getId()), Filters.eq("bookId", bookId));
            UserHistoryBooks result = collectionHistory.find(filter).first();
            return (result != null) ? result.getLastReadChapter() : 1;
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Không tìm thấy dữ liệu user hoặc book.");
            return 1;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return 1;
        }
    }

    public void saveLastReadChapter(ObjectId bookId, double chapter) {
        try {
            Bson filter = Filters.and(Filters.eq("userId", userAccount.getId()), Filters.eq("bookId", bookId));
            collectionHistory.updateOne(filter, Updates.set("lastReadChapter", chapter));
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu chương cuối cùng đã đọc: " + e.getMessage());
        }
    }

    public boolean checkIfExitBookInUser(ObjectId bookId) {
        try {
            Bson filter = Filters.and(Filters.eq("userId", userAccount.getId()), Filters.eq("bookId", bookId));
            UserHistoryBooks userHistoryBooks = collectionHistory.find(filter).first();

            if (userHistoryBooks != null) {
                collectionHistory.updateOne(filter, Updates.set("lastReadDate", LocalDateTime.now()));
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Dữ liệu user hoặc bookId bị null.");
            return false;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return false;
        }
    }

    public void insertBookToDB(Book book) {
        try {
            collectionBook.updateOne(Filters.eq("_id", book.getId()), new Document("$setOnInsert", book), new UpdateOptions().upsert(true));
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Dữ liệu sách bị null.");
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm sách vào DB: " + e.getMessage());
        }
    }

    public Book getBookById(ObjectId bookId) {
        try {
            return collectionBook.find(Filters.eq("_id", bookId)).first();
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy sách theo ID: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            FindIterable<UserHistoryBooks> results = collectionHistory.find(new Document("userId", userAccount.getId())).sort(Sorts.descending("lastReadDate"));

            for (UserHistoryBooks history : results) {
                Book book = getBookById(history.getBookId());
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Dữ liệu null khi lấy danh sách sách.");
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách sách: " + e.getMessage());
        }
        return books;
    }

    public void toggleFavorite(ObjectId bookId, Color level) {
        try {
            storageBookToUser(bookId);

            Bson filter = Filters.and(Filters.eq("userId", userAccount.getId()), Filters.eq("bookId", bookId));

            UserHistoryBooks result = collectionHistory.find(filter).first();

            if (result == null || !result.getFavorite()) {
                collectionHistory.updateOne(filter, Updates.set("favorite", false), new UpdateOptions().upsert(true));
            }

            boolean newFavoriteStatus = (level == Color.red);
            collectionHistory.updateOne(filter, Updates.set("favorite", newFavoriteStatus), new UpdateOptions().upsert(true));
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Dữ liệu null khi thao tác với yêu thích.");
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi đổi trạng thái yêu thích: " + e.getMessage());
        }
    }

    public ArrayList<Book> getAllFavorites() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Bson filter = Filters.and(Filters.eq("userId", userAccount.getId()), Filters.eq("favorite", true));
            FindIterable<UserHistoryBooks> results = collectionHistory.find(filter).sort(Sorts.descending("lastReadDate"));

            for (UserHistoryBooks history : results) {
                Book book = getBookById(history.getBookId());
                if (book != null) {
                    books.add(book);
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Dữ liệu null khi lấy danh sách yêu thích.");
        } catch (Exception e) {
            System.err.println("Lỗi khi lấy danh sách sách yêu thích: " + e.getMessage());
        }
        return books;
    }

    public Color checkFavorite(ObjectId bookId) {
        try {
            Bson filter = Filters.and(Filters.eq("userId", userAccount.getId()), Filters.eq("bookId", bookId));
            UserHistoryBooks result = collectionHistory.find(filter).first();

            if (result == null || !result.getFavorite()) {
                return Color.gray;
            }

            return result.getFavorite() ? Color.red : Color.gray;
        } catch (NullPointerException e) {
            System.err.println("Lỗi: Dữ liệu null khi kiểm tra yêu thích.");
            return Color.gray;
        } catch (Exception e) {
            System.err.println("Lỗi không xác định: " + e.getMessage());
            return Color.gray;
        }
    }

}
