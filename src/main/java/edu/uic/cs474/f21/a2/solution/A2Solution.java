package edu.uic.cs474.f21.a2.solution;
import edu.uic.cs474.f21.a2.ObjectInspector;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class A2Solution implements ObjectInspector{
    @Override
    public Map<String, String> describeObject(Object o) {
        Class<?> c = o.getClass();
        Field[] fs = c.getDeclaredFields();

        Map<String, String> ret = new HashMap<>();

        for(Field f: fs){
            try {
                String key = f.getName();
                Object valueOfTheField = f.get(o);
                String value = (String) valueOfTheField;
                ret.put(key , value);
            }
            catch(ReflectiveOperationException e)
            {
                throw new Error(e);
            }

        }
        return ret;

    }

    @Override
    public void updateObject(Object o, Map<String, Object> fields) {
        throw new Error("Not Implemented");
    }
}
