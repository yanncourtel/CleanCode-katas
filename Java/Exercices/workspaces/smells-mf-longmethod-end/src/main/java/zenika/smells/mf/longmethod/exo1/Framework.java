package zenika.smells.mf.longmethod.exo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Framework {
    
    public void initializeBean(Object bean) {
        try {
            doInitializeBean(bean);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new FrameworkException(e);
        }
    }
    
    private static void doInitializeBean(Object bean) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = bean.getClass();
        Method init = clazz.getMethod("init");
        init.invoke(bean);
    }
    
}
