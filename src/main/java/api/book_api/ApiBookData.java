package api.book_api;

import models.book_information.BookDetails;

import java.util.List;

public class ApiBookData {
    private List<BookDetails> items;

    public List<BookDetails> getItems() {
        return items;
    }

    public void setItems(List<BookDetails> books) {
        this.items = books;
    }
}
