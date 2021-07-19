package zenika.smells.mf.longmethod.exo2.app;

import zenika.smells.mf.longmethod.exo2.lib.DomNode;
import zenika.smells.mf.longmethod.exo2.lib.DomSnippet;

import java.util.ArrayList;
import java.util.List;

public class DomBuilder {
    
    void processNode(DomSnippet root, List<DomNode> childNodes) {
        if(root != null) {
            if(childNodes != null) {
                root.addNode(new DomSnippet(childNodes));
            }   
            root.addChild(DomSnippet.NullSnippet);
        }
        
        List<DomNode> paraList = new ArrayList<>();
        for(DomNode node : childNodes) {
            //basic child
            if(node.type().equals(DomNode.TF_G) || node.type().equals(DomNode.TF_H) ||
                    (node.type().equals(DomNode.TF_GLOT) && node.isChild())) {
                paraList.add(node);
            }
        }
    }
            
}
