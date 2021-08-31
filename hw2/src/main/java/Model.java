

public class Model {

    private final int RANGE_MIN = 0;
    private final int RANGE_MAX = 100;

    private int dynamic_range_min = this.RANGE_MIN;          // boundaries that change based on input
    private int dynamic_range_max = this.RANGE_MAX;
    private static  int x_value;                              //value that user try to guess


    public void generateRandNumber(){
        this.x_value = (int) (Math.random()*(this.RANGE_MAX+1)+this.RANGE_MIN);         // [0; 100] boundaries include
        System.out.println((this.x_value));
    }


    public boolean checkWin(int input){
        return this.x_value == input;
    }

    public boolean checkInputInRange(int input){
        if(input < dynamic_range_min || input > dynamic_range_max){
            return false;
        }
        return true;
    }

    public boolean checkIsBiggerThanX(int input){
        return (input > this.x_value);
    }

    public static int getX_value() {
        return x_value;
    }

    public void setMinBoundary(int min){
        this.dynamic_range_min = min;
    }

    public void setMaxBoundary(int max){
        this.dynamic_range_max = max;
    }

    public int getMinBoundary(){
        return this.dynamic_range_min;
    }

    public int getMaxBoundary(){
        return this.dynamic_range_max;
    }


}
