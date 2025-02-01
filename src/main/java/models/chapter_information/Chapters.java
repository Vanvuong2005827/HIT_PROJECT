package models.chapter_information;

public class Chapters {
    private String filename;
    private String chapter_name;

    public Chapters() {
    }

    public Chapters(String filename, String chapter_name) {
        this.filename = filename;
        this.chapter_name = chapter_name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
}
