package api.all_book_api;

import java.util.List;

public class ApiAllBookData {
    private List<ApiAllBookJson> items;

    public List<ApiAllBookJson> getItems() {
        return items;
    }

    public void setItems(List<ApiAllBookJson> books) {
        this.items = books;
    }
}
