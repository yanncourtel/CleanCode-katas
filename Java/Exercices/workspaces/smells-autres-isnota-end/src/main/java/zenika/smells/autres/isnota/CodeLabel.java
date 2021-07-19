package zenika.smells.autres.isnota;

import static java.util.Objects.requireNonNull;

public final class CodeLabel {

    private final String code, label;

    public CodeLabel(String code, String label) {
        this.code = requireNonNull(code);
        this.label = requireNonNull(label);
    }

    public String getCode() {
        return this.code;
    }

    public String getLabel() {
        return this.label;
    }

    @Override public boolean equals(Object obj) {
        if(!(obj instanceof CodeLabel)) return false;
        CodeLabel that = (CodeLabel) obj;
        return this.code.equals(that.code);
    }

    @Override public int hashCode() {
        return code.hashCode();
    }
}
