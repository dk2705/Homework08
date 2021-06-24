package homework;

import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainClass {
    
        public static void main(String[] args) throws Exception {

            Cat cat;
            CatFarschFactory factory;
            Farsch farsch;
            Field field;
            Color colorInit;
            double colorValueRandom;
            String colorValue;
            Class catClass;
            Blohable blohableInit;
            double blohableValueRandom;
            String blohableValue;
            
            float total = 0;
                    
            // создаем 10 случайных котов
            for (int i=0; i<10; i++){
                if (Math.random() < 0.5){
                    cat = new FatCat("Cat1",6.0f);
                }else{
                    cat = new HomelessCat("Cat2",3.5f);
                }
                System.out.print(cat.getClass().getName().substring(cat.getClass().getName().indexOf(".")+1));
                // выбираем для созданного кота случайный цвет, генерируем значение в аннотации поля name
                field = cat.getClass().getDeclaredField("name");
                colorInit = field.getAnnotation(Color.class);
                colorValueRandom = Math.random();
                if(colorValueRandom < 0.25){
                    colorValue = "black";
                }else if(colorValueRandom >= 0.25 && colorValueRandom < 0.5){
                    colorValue = "blue";
                }else if(colorValueRandom >= 0.5 && colorValueRandom < 0.75){
                    colorValue = "green";
                }else{
                    colorValue = "red";
                }
                Color color = (Color)setAttrValue(colorInit, Color.class, "value", colorValue);
                System.out.print(" color=" + color.value() + ";");
                
                // выбираем для созданного кота случайный признак Blohable, генерируем значение в аннотации класса
                catClass = cat.getClass();
                blohableInit = (Blohable)catClass.getAnnotation(Blohable.class);
                blohableValueRandom = Math.random();
                if(blohableValueRandom < 0.5){
                    blohableValue = "true";
                }else{
                    blohableValue = "false";
                }
                Blohable blohable = (Blohable)setAttrValue(blohableInit, Blohable.class, "value", blohableValue);
                System.out.print(" blohable=" + blohable.value() + ";");
                        
                // делаем фарш
                factory = new CatFarschFactory(cat, color, blohable);
                farsch = factory.getFarsch();
                farsch.get();
                total += farsch.getWeightOut();
            }
            System.out.println("Total farsch = " + (float)Math.round(total*100)/100);
        }
        
        public static Annotation setAttrValue(Annotation anno, Class<? extends Annotation> type, String attrName, Object newValue) throws Exception {
            InvocationHandler handler = new AnnotationInvocationHandler(anno, attrName, newValue);
            Annotation proxy = (Annotation)Proxy.newProxyInstance(anno.getClass().getClassLoader(), new Class[]{type}, handler);
            return proxy;
        }
}

class AnnotationInvocationHandler implements InvocationHandler {
    private Annotation orig;
    private String attrName;
    private Object newValue;

    public AnnotationInvocationHandler(Annotation orig, String attrName, Object newValue) throws Exception {
        this.orig = orig;
        this.attrName = attrName;
        this.newValue = newValue;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals(attrName) && args == null)
            return newValue;
        else {
            Class<?>[] paramTypes = toClassArray(args);
            return orig.getClass().getMethod(method.getName(), paramTypes).invoke(orig, args);
        }
    }

    private static Class<?>[] toClassArray(Object[] arr) {
        if (arr == null)
            return null;
        Class<?>[] classArr = new Class[arr.length];
        for (int i=0; i<arr.length; i++)
            classArr[i] = arr[i].getClass();
        return classArr;
    }
}