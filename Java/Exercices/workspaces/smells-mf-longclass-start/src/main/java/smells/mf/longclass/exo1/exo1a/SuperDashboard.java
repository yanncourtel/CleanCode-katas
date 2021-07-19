package smells.mf.longclass.exo1.exo1a;

import smells.mf.longclass.exo1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Properties;

public class SuperDashboard extends JFrame implements MetaDataUser {
    public String getCustomizerLanguagePath(){
        return null;
    };
    public void setSystemConfigPath(String systemConfigPath){};
    public String getSystemConfigDocument(){
        return null;
    };
    public void setSystemConfigDocument(String systemConfigDocument){};
    public boolean getGuruState(){
        return false;
    };
    public boolean getNoviceState(){
        return false;
    };
    public boolean getOpenSourceState(){
        return false;
    };
    public void showObject(MetaObject object){};
    public void showProgress(String s){};
    public boolean isMetadataDirty(){
        return false;
    };
    public void setIsMetadataDirty(boolean isMetadataDirty){};
    public Component getLastFocusedComponent(){
        return null;
    };
    public void setLastFocused(Component lastFocused){};
    public void setMouseSelectState(boolean isMouseSelected){};
    public boolean isMouseSelected(){
        return false;
    };
    public LanguageManager getLanguageManager(){
        return null;
    };
    public Project getProject(){
        return null;
    };
    public Project getFirstProject(){
        return null;
    };
    public Project getLastProject(){
        return null;
    };
    public String getNewProjectName(){
        return null;
    };
    public void setComponentSizes(Dimension dim){};
    public String getCurrentDir(){
        return null;
    };
    public void setCurrentDir(String newDir){};
    public void updateStatus(int dotPos, int markPos){};
    public Class<?>[] getDataBaseClasses(){
        return new Class<?>[0];
    };
    public MetadataFeeder getMetadataFeeder(){
        return null;
    };
    public void addProject(Project project){};
    public boolean setCurrentProject(Project project){
        return false;
    };
    public boolean removeProject(Project project){
        return false;
    };
    public MetaProjectHeader getProgramMetadata(){
        return null;
    };
    public void resetDashboard(){};
    public Project loadProject(String fileName, String projectName){
        return null;
    };
    public void setCanSaveMetadata(boolean canSave){};
    public MetaObject getSelectedObject(){
        return null;
    };
    public void deselectObjects(){};
    public void setProject(Project project){};
    public void editorAction(String actionName, ActionEvent event){};
    public void setMode(int mode){};
    public FileManager getFileManager(){
        return null;
    };
    public void setFileManager(FileManager fileManager){};
    public ConfigManager getConfigManager(){
        return null;
    };
    public void setConfigManager(ConfigManager configManager){};
    public ClassLoader getClassLoader(){
        return null;
    };
    public void setClassLoader(ClassLoader classLoader){};
    public Properties getProps(){
        return null;
    };
    public String getUserHome(){
        return null;
    };
    public String getBaseDir(){
        return null;
    };
    public int getMajorVersionNumber(){
        return 0;
    };
    public int getMinorVersionNumber(){
        return 0;
    };
    public int getBuildNumber(){
        return 0;
    };
    public MetaObject pasting(
    MetaObject target, MetaObject pasted, MetaProject project){
        return target;
    };
    public void processMenuItems(MetaObject metaObject){};
    public void processMenuSeparators(MetaObject metaObject){};
    public void processTabPages(MetaObject metaObject){};
    public void processPlacement(MetaObject object){};
    public void processCreateLayout(MetaObject object){};
    public void updateDisplayLayer(MetaObject object, int layerIndex){};
    public void propertyEditedRepaint(MetaObject object){};
    public void processDeleteObject(MetaObject object){};
    public boolean getAttachedToDesigner(){
        return false;
    };
    public void processProjectChangedState(boolean hasProjectChanged){};
    public void processObjectNameChanged(MetaObject object){};
    public void runProject(){};
    public void setAllowDragging(boolean allowDragging){};
    public boolean allowDragging(){
        return false;
    };
    public boolean isCustomizing(){
        return false;
    };
    public void setTitle(String title){};
    public IdeMenuBar getIdeMenuBar(){
        return null;
    };
    public void showHelper(MetaObject metaObject, String propertyName){};
}
