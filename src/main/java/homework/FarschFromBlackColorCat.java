package homework;

public class FarschFromBlackColorCat extends Farsch {

    public FarschFromBlackColorCat (float weightIn){
        super(weightIn);
    }

    @Override
    public void get() {
        if(Math.random() < 0.5){
            super.setWeightOut((float)Math.round((super.getWeightIn()*0.6)*100)/100);
        }else{
            super.setWeightOut(0);
        }
        System.out.print(" weightIn="+super.getWeightIn()+";");
        System.out.print(" Farsch from blackColor cat is ready;");
        System.out.println(" weightOut="+super.getWeightOut());
    }
}
