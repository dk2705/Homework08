package homework;

public class FarschFromOtherCat extends Farsch {

    public FarschFromOtherCat (float weightIn){
        super(weightIn);
    }

    @Override
    public void get() {
        super.setWeightOut((float)Math.round((super.getWeightIn()*0.6)*100)/100);
        System.out.print(" weightIn="+super.getWeightIn()+";");
        System.out.print(" Farsch from other cat is ready;");
        System.out.println(" weightOut="+super.getWeightOut());
    }    
}
