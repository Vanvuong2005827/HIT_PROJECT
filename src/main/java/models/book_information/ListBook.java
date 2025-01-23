package models.book_information;

import api.book_api.ApiBookResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import static api.ApiGet.getApi;

public class ListBook {
    public ArrayList<Book> getBooksTruyenMoi() {
        ArrayList<Book> books = new ArrayList<>();
//        for (int i = 1; i <= 2; i++) {
//            String pageNumber = Integer.toString(i);
            String pageNumber = "1";
            String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/truyen-moi?page=" + pageNumber;
            String jsonData = getApi(apiUrl);
            if (jsonData != null && !jsonData.isEmpty()) {
                Gson gson = new Gson();
                ApiBookResponse apiResponse = gson.fromJson(jsonData, ApiBookResponse.class);

                if (apiResponse != null && apiResponse.getData() != null) {
                    apiResponse.getData().getItems().forEach(item -> {
                        books.add(new Book(item.getName(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                    });
                }
            }
//        }
        return books;
    }
    public ArrayList<Book> getBooksHoanThanh() {
        ArrayList<Book> books = new ArrayList<>();
//        for (int i = 1; i <= 2; i++) {
//            String pageNumber = Integer.toString(i);
        String pageNumber = "1";
        String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/hoan-thanh?page=" + pageNumber;
        String jsonData = getApi(apiUrl);
        if (jsonData != null && !jsonData.isEmpty()) {
            Gson gson = new Gson();
            ApiBookResponse apiResponse = gson.fromJson(jsonData, ApiBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                });
            }
        }
//        }
        return books;
    }

    public ArrayList<Book> getBooksSapRaMat() {
        ArrayList<Book> books = new ArrayList<>();
//        for (int i = 1; i <= 2; i++) {
//            String pageNumber = Integer.toString(i);
        String pageNumber = "1";
        String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/sap-ra-mat?page=" + pageNumber;
        String jsonData = getApi(apiUrl);
        if (jsonData != null && !jsonData.isEmpty()) {
            Gson gson = new Gson();
            ApiBookResponse apiResponse = gson.fromJson(jsonData, ApiBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                });
            }
        }
//        }
        return books;
    }
    public ArrayList<Book> getBooksDangPhatHanh() {
        ArrayList<Book> books = new ArrayList<>();
//        for (int i = 1; i <= 2; i++) {
//            String pageNumber = Integer.toString(i);
        String pageNumber = "1";
        String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/dang-phat-hanh?page=" + pageNumber;
        String jsonData = getApi(apiUrl);
        if (jsonData != null && !jsonData.isEmpty()) {
            Gson gson = new Gson();
            ApiBookResponse apiResponse = gson.fromJson(jsonData, ApiBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                });
            }
        }
//        }
        return books;
    }

    public ArrayList<Book> getBooksTheLoai(){
        ArrayList<Book> books = new ArrayList<>();
        String apiUrl = "https://otruyenapi.com/v1/api/the-loai";
        String jsonData = getApi(apiUrl);
        if (jsonData != null && !jsonData.isEmpty()) {
            Gson gson = new Gson();
            ApiBookResponse apiResponse = gson.fromJson(jsonData, ApiBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName()));
                });
            }
        }
        return books;
    }
}


