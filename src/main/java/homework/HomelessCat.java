package homework;

@Blohable(value="unknownBlohable")
public class HomelessCat extends Cat {

    @Color(value="unknownColor")
    private String name;

    public HomelessCat (String name, float weight){
        super(name, weight);
        this.name = super.getName();
    }    
    
}
