package zenika.rappel.java8;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class Book {
    private final String title;
    private final Topic topic;
    private final int pages;
    private final Set<String> authors;

    public Book(String title, Topic topic, int pages, String...authors) {
        this.title = title;
        this.topic = topic;
        this.pages = pages;
        this.authors = unmodifiableSet(new HashSet<String>() {{
            addAll(asList(authors!=null?authors:new String[0]));
        }});
    }

    public String getTitle() {
        return title;
    }

    public Topic getTopic() {
        return topic;
    }

    public int getPages() {
        return pages;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public static class BookBuilder {
        String title;
        Topic topic;
        int pages;
        String[] authors;

        public Book build() {
            return new Book(this.title, this.topic, this.pages, this.authors);
        }

        public BookBuilder about(Topic topic) {
            this.topic = topic;
            return this;
        }

        public BookBuilder havingPages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookBuilder writtenBy(String... authors) {
            this.authors = authors;
            return this;
        }
    }

    public static BookBuilder named(String title) {
        BookBuilder builder = new BookBuilder();
        builder.title = title;
        return builder;
    }
}
