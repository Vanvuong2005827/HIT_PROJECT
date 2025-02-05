package utils.get_data;

import api.all_book_api.ApiAllBookResponse;
import api.one_book_api.ApiOneBookJson;
import api.one_book_api.ApiOneBookResponse;
import api.seach_book_api.ApiSearchBookResponse;
import com.google.gson.Gson;
import models.book_information.Book;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static api.ApiGet.getApi;

public class GetAllBook {
    public ArrayList<Book> getBooksTruyenMoi(int numberPage) {
        ArrayList<Book> books = new ArrayList<>();
        int totalPages = numberPage;
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            int page = i;
            Callable<ArrayList<Book>> task = () -> {
                ArrayList<Book> pageBooks = new ArrayList<>();
                String pageNumber = Integer.toString(page);
                String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/truyen-moi?page=" + pageNumber;
                String jsonData = getApi(apiUrl);
                if (jsonData != null && !jsonData.isEmpty()) {
                    Gson gson = new Gson();
                    ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

                    if (apiResponse != null && apiResponse.getData() != null) {
                        apiResponse.getData().getItems().forEach(item -> {
                            pageBooks.add(new Book(item.getId(), item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                        });
                    }
                }
                return pageBooks;
            };

            futures.add(executor.submit(task));
        }

        for (Future<ArrayList<Book>> future : futures) {
            try {
                books.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return books;
    }

    public ArrayList<Book> getBooksHoanThanh(int numberPage) {
        ArrayList<Book> books = new ArrayList<>();
        int totalPages = numberPage;
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            int page = i;
            Callable<ArrayList<Book>> task = () -> {
                ArrayList<Book> pageBooks = new ArrayList<>();
                String pageNumber = Integer.toString(page);
                String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/hoan-thanh?page=" + pageNumber;
                String jsonData = getApi(apiUrl);
                if (jsonData != null && !jsonData.isEmpty()) {
                    Gson gson = new Gson();
                    ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

                    if (apiResponse != null && apiResponse.getData() != null) {
                        apiResponse.getData().getItems().forEach(item -> {
                            pageBooks.add(new Book(item.getId(), item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                        });
                    }
                }
                return pageBooks;
            };

            futures.add(executor.submit(task));
        }

        for (Future<ArrayList<Book>> future : futures) {
            try {
                books.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return books;
    }

    public ArrayList<Book> getBooksSapRaMat(int numberPage) {
        ArrayList<Book> books = new ArrayList<>();
        int totalPages = numberPage;
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            int page = i;
            Callable<ArrayList<Book>> task = () -> {
                ArrayList<Book> pageBooks = new ArrayList<>();
                String pageNumber = Integer.toString(page);
                String apiUrl = "https://otruyenapi.com/v1/api/danh-sach/sap-ra-mat?page=" + pageNumber;
                String jsonData = getApi(apiUrl);
                if (jsonData != null && !jsonData.isEmpty()) {
                    Gson gson = new Gson();
                    ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

                    if (apiResponse != null && apiResponse.getData() != null) {
                        apiResponse.getData().getItems().forEach(item -> {
                            pageBooks.add(new Book(item.getId(), item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                        });
                    }
                }
                return pageBooks;
            };

            futures.add(executor.submit(task));
        }

        for (Future<ArrayList<Book>> future : futures) {
            try {
                books.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return books;
    }

    public ArrayList<Book> getBooksTheLoai() {
        ArrayList<Book> books = new ArrayList<>();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            String apiUrl = "https://otruyenapi.com/v1/api/the-loai";
            String jsonData = getApi(apiUrl);
            if (jsonData != null && !jsonData.isEmpty()) {
                Gson gson = new Gson();
                ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

                if (apiResponse != null && apiResponse.getData() != null) {
                    apiResponse.getData().getItems().forEach(item -> {
                        pageBooks.add(new Book(item.getName(), item.getSlug()));
                    });
                }
            }
            return pageBooks;
        };

        futures.add(executor.submit(task));


        for (Future<ArrayList<Book>> future : futures) {
            try {
                books.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return books;
    }

    public ArrayList<Book> getBooksTungTheLoai(int numberPage, String nameStyle) {
        ArrayList<Book> books = new ArrayList<>();
        int totalPages = numberPage;
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            int page = i;
            Callable<ArrayList<Book>> task = () -> {
                ArrayList<Book> pageBooks = new ArrayList<>();
                String pageNumber = Integer.toString(page);
                String apiUrl = "https://otruyenapi.com/v1/api/the-loai/" + nameStyle + "?page=" + pageNumber;
                String jsonData = getApi(apiUrl);
                if (jsonData != null && !jsonData.isEmpty()) {
                    Gson gson = new Gson();
                    ApiAllBookResponse apiResponse = gson.fromJson(jsonData, ApiAllBookResponse.class);

                    if (apiResponse != null && apiResponse.getData() != null) {
                        apiResponse.getData().getItems().forEach(item -> {
                            pageBooks.add(new Book(item.getId(), item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChaptersLatest()));
                        });
                    }
                }
                return pageBooks;
            };

            futures.add(executor.submit(task));
        }

        for (Future<ArrayList<Book>> future : futures) {
            try {
                books.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return books;
    }

    public Book getBooksTheoTen(String tenTruyen) {
        Book book = new Book();
        String apiUrl = "https://otruyenapi.com/v1/api/truyen-tranh/" + tenTruyen;
        String jsonData = getApi(apiUrl);
        if (jsonData != null && !jsonData.isEmpty()) {
            Gson gson = new Gson();
            ApiOneBookResponse apiResponse = gson.fromJson(jsonData, ApiOneBookResponse.class);

            if (apiResponse != null && apiResponse.getData() != null) {
                ApiOneBookJson b = apiResponse.getData().getItem();
                book = new Book(b.getId(), b.getName(), b.getSlug(), b.getContent(), b.getStatus(), b.getThumbUrl(), b.getCategory(), b.getChapters(), b.getUpdatedAt());
            }
        }
        return book;
    }

    public ArrayList<Book> getBooksTheoKeywords(String keywords, JLabel label) {
        ArrayList<Book> books = new ArrayList<>();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            String apiUrl = "https://otruyenapi.com/v1/api/tim-kiem?keyword=" + keywords;
            String jsonData = getApi(apiUrl);
            if (jsonData != null && !jsonData.isEmpty()) {
                Gson gson = new Gson();
                ApiSearchBookResponse apiResponse = gson.fromJson(jsonData, ApiSearchBookResponse.class);

                if (apiResponse != null && apiResponse.getData() != null) {
                    apiResponse.getData().getItems().forEach(item -> {
                        pageBooks.add(new Book(item.getName(), item.getSlug(), item.getStatus(), item.getUpdatedAt(), item.getThumbUrl(), item.getCategory(), item.getChapters()));
                    });
                    label.setText(apiResponse.getData().getTitlePage());
                }
            }
            return pageBooks;
        };

        futures.add(executor.submit(task));

        for (Future<ArrayList<Book>> future : futures) {
            try {
                books.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return books;
    }
}


