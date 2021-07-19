package zenika.smells.mf.longmethod.exo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Framework {
    
    public void initializeBean(Object bean) {
        try {
            Class<?> clazz = bean.getClass();
            Method init = clazz.getMethod("init");
            init.invoke(bean);
        } catch (NoSuchMethodException e) {
            throw new FrameworkException(e);
        } catch (IllegalAccessException e) {
            throw new FrameworkException(e);
        } catch (InvocationTargetException e) {
            throw new FrameworkException(e);
        }
    }
    
}
