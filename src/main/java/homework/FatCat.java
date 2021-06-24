package homework;

@Blohable(value="unknownBlohable")
public class FatCat extends Cat {

    @Color(value="unknownColor")
    private String name;
    
    public FatCat (String name, float weight){
        super(name, weight);
        this.name = super.getName();
    }

}
