package zenika.smells.mf.dupmethod;

public class Artist {
    private final String name;

    private Artist(String name) {
        this.name = name;
    }

    public static Artist named(String name) {
        return new Artist(name);
    }
}
