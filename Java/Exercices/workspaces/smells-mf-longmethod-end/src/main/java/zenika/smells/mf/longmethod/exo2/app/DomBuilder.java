package zenika.smells.mf.longmethod.exo2.app;

import zenika.smells.mf.longmethod.exo2.lib.DomNode;
import zenika.smells.mf.longmethod.exo2.lib.DomSnippet;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DomBuilder {
    
    List<DomNode> processNode(DomSnippet root, List<DomNode> childNodes) {
        if(root != null) {
            if(childNodes != null) {
                root.addNode(new DomSnippet(childNodes));
            }   
            root.addChild(DomSnippet.NullSnippet);
        }
                
        return childNodes.stream()
                .filter(DomBuilder::isBasicChild)
                .collect(toList());
    }

    //extract method
    private static boolean isBasicChild(DomNode node) {
        return node.type().equals(DomNode.TF_G) 
                || node.type().equals(DomNode.TF_H) 
                || (node.type().equals(DomNode.TF_GLOT) && node.isChild());
    }

}
