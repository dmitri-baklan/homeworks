import org.junit.Assert;
import org.junit.Test;

public class TestModule {
        Model model = new Model();
        private final int RANGE_MIN = 0;
        private final int RANGE_MAX = 100;

        private int dynamic_range_min = this.RANGE_MIN;          // boundaries that change based on input
        private int dynamic_range_max = this.RANGE_MAX;
        private static  int x_value;                              //value that user try to guess

        @Test
        public void generateRandNumber(){
            this.x_value = (int) (Math.random()*(this.RANGE_MAX+1)+this.RANGE_MIN);         // [0; 100] boundaries include
            if(this.x_value > 100 || this.x_value < 0) Assert.fail();
        }

        @Test
        public void checkWin(){
            model.generateRandNumber();
            if(!model.checkWin(model.getX_value()))Assert.fail();
        }

        @Test
        public void checkInputInRange(){
            if(model.checkInputInRange(101))Assert.fail();
        }

        @Test
        public void checkIsBiggerThanX(){
            if(!model.checkIsBiggerThanX(101))Assert.fail();
        }
        @Test
        public void getMinBoundary(){
            int min = 1;
            model.setMinBoundary(1);
            if(model.getMinBoundary() != min)Assert.fail();
        }
        @Test
        public void getMaxBoundary(){
            int max = 99;
            model.setMaxBoundary(max);
            if(model.getMaxBoundary() != max)Assert.fail();
        }


}
