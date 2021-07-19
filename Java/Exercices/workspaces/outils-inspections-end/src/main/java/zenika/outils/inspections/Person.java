package zenika.outils.inspections;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Person
{
    private final String name;

    public Person(String name) {
        this.name = requireNonNull(name);
    }

    @Override public boolean equals(Object obj) {
        if(!(obj instanceof Person)) return false;
        Person that = (Person) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }
}
