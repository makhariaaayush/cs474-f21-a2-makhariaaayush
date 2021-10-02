package edu.uic.cs474.f21.a2.solution;
import edu.uic.cs474.f21.a2.ObjectInspector;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class A2Solution implements ObjectInspector{
    String key;
    String value;
    Object Obj;
    Object Obj1;
    //Helper Function
    public String GetValue(Object c,Field f) throws IllegalAccessException{

        Obj=f.get(c);

        if(Obj==null){
            return "null";
        }
        Obj1= Obj.getClass().getName();

        String v;
        if(Obj1.equals("java.lang.Integer")){
            if(f.getType().getName().equals("int")) {
                v = Integer.toString((Integer) f.get(c));
            }
            else{
                v = "Boxed "+ (Integer) f.get(c);
            }
            return v;
        }
        if(Obj1.equals("java.lang.Long")){
            if(f.getType().getName().equals("long")) {
                v = Long.toString((Long) f.get(c));
            }
            else{
                v = "Boxed "+ (Long) f.get(c);
            }
            return v+ "#L";
        }

        if(Obj1.equals("java.lang.Float")){
            if(f.getType().getName().equals("float")) {
                v = Float.toString((Float) f.get(c));
            }
            else{
                v = "Boxed "+ (Float) f.get(c);
            }
            return v+ "#F";
        }

        if(Obj1.equals("java.lang.Double")){
            if(f.getType().getName().equals("double")) {
                v = Double.toString((Double) f.get(c));
            }
            else{
                v = "Boxed "+ (Double) f.get(c);
            }
            return v+ "#D";
        }

        if(Obj1.equals("java.lang.Short")){
            if(f.getType().getName().equals("short")) {
                v = "0" +Integer.toOctalString((Short) f.get(c));
            }
            else{
                v = "Boxed 0"+Integer.toOctalString((Short) f.get(c));
            }
            return v;
        }

        if(Obj1.equals("java.lang.Byte")){
            if(f.getType().getName().equals("byte")) {
                v = "0x"+Integer.toHexString((Byte) f.get(c));
            }
            else{
                v = "Boxed 0x"+Integer.toHexString((Byte) f.get(c));
            }
            return v;
        }

        if(Obj1.equals("java.lang.Boolean")){
            if(f.getType().getName().equals("boolean")) {
                v = Boolean.toString((Boolean) f.get(c));
            }
            else{
                v = "Boxed "+ (Boolean) f.get(c);
            }
            return v;
        }

        if(Obj1.equals("java.lang.Character")){
            if(f.getType().getName().equals("char")) {
                v = Character.toString((Character) f.get(c));
            }
            else{
                v = "Boxed "+ (Character) f.get(c);
            }
            return v;
        }
        else{
            return Obj.toString();

        }
    }

    @Override
    public Map<String, String> describeObject(Object o) {
        Class<?> c = o.getClass();
        Field[] fs = c.getFields();

        Map<String, String> ret = new HashMap<>();
        for(Field f: fs){
            try {
                key = f.getName();
                //Helper Function Called

                value = GetValue(o,f);
                ret.put(key , value);
            }
            catch(ReflectiveOperationException e) {
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

