package homework;

public class Cat {
    
    @Color(value="unknownColor")
    private String name;
    
    private float weight;
    
    public Cat (String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}