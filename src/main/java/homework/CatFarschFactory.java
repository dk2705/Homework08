package homework;

import java.lang.reflect.Field;

public class CatFarschFactory {

    private Cat cat;
    private Color color;
    private Blohable blohable;
    
    public CatFarschFactory(Cat cat, Color color, Blohable blohable) throws ClassNotFoundException {
        this.cat = cat;
        this.color = color;
        this.blohable = blohable;
    }
    
    public Farsch getFarsch() throws NoSuchFieldException, IllegalAccessException {
        
        Farsch farsch;

        Field weightField = Cat.class.getDeclaredField("weight");
        weightField.setAccessible(true);
        float weight = (float)weightField.get(cat);

        if("true".equals(blohable.value())){
            farsch = new FarschFromBlohableCat(weight);
        }else if("black".equals(color.value())){
            farsch = new FarschFromBlackColorCat(weight);
        }else{
            farsch = new FarschFromOtherCat(weight);
        }

        return farsch;
    }

}
