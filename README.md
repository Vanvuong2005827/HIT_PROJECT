# HIT_PROJECT
This is an online library application that allows you to read books and search for your favorite ones. It helps you organize and track the books you have read or wish to read.
## Installation
### Require 
 - Java 11+
 - Maven.
 - IDE: IntelliJ or Netbeans.
### How to run the project?
 - Clone the project.
 - Install the library necessary.
## How to Use
1. Ensure you are connected to the internet.
2. Run the project in the main class.
3. If you don't have an account, create one.
4. Log in using your account credentials.
5. Retrieve your account information if needed.
### Home Page
- You can choose a book from the home page.
    - View books in a list or grid layout.
    - Browse books by style.

You can search for books using the search label.  
You can view more books by clicking on the "Thêm >" label.
### Recent Page
You can see a list of recently read books.
### Favorite Page
This page displays the books you've marked as favorites.
### Account Page
You can see the information of your account in this page. Moreover, you can choose options in setting.
- Change your name.
- Change your password.
- Change the theme of the application.
- Retrieve your password if forgotten.
- Remove your account.
### More Book Screen
This screen lets you view books categorized by their status (e.g., ongoing, completed, new, etc.).
### One Book Screen
In this screen, you can read the book by clicking "Bắt đầu đọc". You can also see a list of chapters and choose one to 
read. If you've already read a chapter, it will be marked. You can also add this book to your favorites list.
### Chapter Screen
Read books on this screen. You can navigate between chapters using the next or previous chapter labels.
### Search Screen
Search for books by typing the book name in the text field.
 

## TECHNOLOGY USED
### UI (User Interface)
- **FlatLaf** (flatlaf, flatlaf-extras) – A modern look and feel for Java Swing applications.
- **AbsoluteLayout** – A layout manager from NetBeans for drag-and-drop UI design.
- **Font Awesome** – A library for UI icons.
### JSON processing
- **Gson** – Used for converting Java objects to JSON and vice versa.
### Database
- **MongoDB Driver** – A synchronous driver for MongoDB database connectivity.
### Email Handling
- **Jakarta Mail** – A library for handling email sending and receiving in Java applications.
- **Javax Mail** – An older version of JavaMail for email handling.
### Image Processing
- **Thumbnailator** – A library for generating high-quality thumbnails.
- **OpenCV** – A library for computer vision and image processing.
### Security & Authentication
- **JBCrypt** – A library for password hashing and encryption.
###  Concurrency & Multi-threading
- **SwingWorker** – Used for performing background tasks in Swing applications.
- **Multi-threading** – Used for faster processing.
## Folder Structure
📁pet_project  
┣📁.idea  
┣📁src/main/java  
┃ ┣📁api (API-related classes and services)  
┃ ┣📁commons (Common utilities or constants used across the project)   
┃ ┣📁controllers (Controller classes managing business logic)  
┃ ┣📁dao (Data Access Object classes for database interaction)  
┃ ┣📁data (Data handling and processing classes)  
┃ ┣📁libs  (External libraries and dependencies)  
┃ ┣📁models (Model classes representing data entities)  
┃ ┣📁services (Service classes containing business logic)  
┃ ┣📁utils (Utility classes for various helper functions)  
┃ ┣📁view (UI components and screens)  
┃ ┣📁assets (Images, fonts, and other static resources)  
┃ ┗📜GitFlow.txt   
┣📜pom.xml (Maven build configuration)  
┗📜README.md  
