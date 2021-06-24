package homework;

public class FarschFromBlohableCat extends Farsch {

    public FarschFromBlohableCat (float weightIn){
        super(weightIn);
    }

    @Override
    public void get() {
        super.setWeightOut(0);
        System.out.print(" weightIn="+super.getWeightIn()+";");
        System.out.print(" Farsch from blohable cat is ready;");
        System.out.println(" weightOut="+super.getWeightOut());
    }    
}
