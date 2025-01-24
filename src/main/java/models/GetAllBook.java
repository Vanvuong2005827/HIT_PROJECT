package models;

import api.all_book_api.ApiAllBookResponse;
import api.one_book_api.ApiOneBookJson;
import api.one_book_api.ApiOneBookResponse;
import com.google.gson.Gson;
import models.book_information.Book;

import java.util.ArrayList;

import static api.ApiGet.getApi;

public class GetAllBook {
    public ArrayList<Book> getBooksTruyenMoi() {
        ArrayList<Book> books = new ArrayList<>();
//        for (int i = 1; i <= 2; i++) {
//            String pageNumber = Integer.toString(i);
            String pageNumber = "1";
            String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/truyen-moi?page=" + pageNumber;
            String jsonData = getApi(apiUrl);
            if (jsonData != null && !jsonData.isEmpty()) {
                Gson gson = new Gson();
                ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

                if (apiResponse != null && apiResponse.getData() != null) {
                    apiResponse.getData().getItems().forEach(item -> {
                        books.add(new Book(item.getName(),item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
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
            ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
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
            ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
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
            ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                apiResponse.getData().getItems().forEach(item -> {
                    books.add(new Book(item.getName()));
                });
            }
        }
        return books;
    }

    public Book getBooksTheoTen(String tenTruyen){
        Book book = null;
        String apiUrl = "https://otruyenapi.com/v1/api/truyen-tranh/" + tenTruyen;
        String jsonData = getApi(apiUrl);
        if (jsonData != null && !jsonData.isEmpty()) {
            Gson gson = new Gson();
            ApiOneBookResponse apiResponse = gson.fromJson(jsonData, ApiOneBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                ApiOneBookJson b = apiResponse.getData().getItem();
                book = new Book(b.getName(),b.getSlug(), b.getContent(), b.getStatus(), b.getThumbUrl(), b.getAuthor(), b.getCategory(), b.getChapters(), b.getUpdatedAt());
            }
        }
        return book;
    }
}


