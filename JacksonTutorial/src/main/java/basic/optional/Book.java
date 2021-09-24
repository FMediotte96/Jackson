package basic.optional;

import java.util.Optional;

public class Book {
    private String title;
    private Optional<String> subTitle;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Optional<String> getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(Optional<String> subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "Book{" +
            "title='" + title + '\'' +
            ", subTitle=" + subTitle +
            '}';
    }
}
