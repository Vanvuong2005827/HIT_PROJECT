package data;

import api.book.ApiAllBookResponse;
import api.book.ApiOneBookJson;
import api.book.ApiOneBookResponse;
import api.search.ApiSearchBookResponse;
import com.google.gson.Gson;
import models.book.Book;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static api.ApiGet.getApi;

public class GetAllBook {
    public ArrayList<Book> getBooksTruyenMoi(int numberPage) {
        ArrayList<Book> books = new ArrayList<>();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            try {
                String pageNumber = Integer.toString(numberPage);
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<Book> getBooksHoanThanh(int numberPage) {
        ArrayList<Book> books = new ArrayList<>();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            try {
                String pageNumber = Integer.toString(numberPage);
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<Book> getBooksSapRaMat(int numberPage) {
        ArrayList<Book> books = new ArrayList<>();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            try {
                String pageNumber = Integer.toString(numberPage);
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<Book> getBooksTheLoai() {
        ArrayList<Book> books = new ArrayList<>();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            try {
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        List<Future<ArrayList<Book>>> futures = new ArrayList<>();
        Callable<ArrayList<Book>> task = () -> {
            ArrayList<Book> pageBooks = new ArrayList<>();
            try {
                String pageNumber = Integer.toString(numberPage);
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public Book getBooksTheoTen(String tenTruyen) {
        Book book = new Book();
        try {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
            try {
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
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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


