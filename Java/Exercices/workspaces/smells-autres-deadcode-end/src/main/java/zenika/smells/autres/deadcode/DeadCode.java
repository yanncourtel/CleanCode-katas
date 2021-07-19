package zenika.smells.autres.deadcode;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public class DeadCode {
    
    private final Set<String> resource;

    public DeadCode(Set<String> resource) {
        this.resource = requireNonNull(resource);
    }

    void useResource() {
        for(String s : resource) {
            //Simule une utilisation de la resource
        }
    } 

    
}
