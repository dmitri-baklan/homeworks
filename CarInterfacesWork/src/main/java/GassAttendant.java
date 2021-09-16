import java.awt.*;

public class GassAttendant {
    CarGassAttendant carGassAttendant;
    private String name;
    private String birth_date;

    public GassAttendant(String name, String birth_date, CarGassAttendant carGassAttendant){
        this.name = name;
        this.birth_date = birth_date;
        this.carGassAttendant = carGassAttendant;
    }

    public CarGassAttendant getCarGassAttendant() {
        return carGassAttendant;
    }

    public void setCarGassAttendant(CarGassAttendant carGassAttendant) {
        this.carGassAttendant = carGassAttendant;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void refulCar(){
        carGassAttendant.getTank_placement();
        carGassAttendant.getType_of_engine();
        System.out.println("Car is full of fuel");
    }
}
