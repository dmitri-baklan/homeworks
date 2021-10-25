public class Mechanic {
    private String name;
    private String birth_date;
    private CarMechanic carMechanic;

    public Mechanic(String name, String birth_date, CarMechanic carMechanic) {
        this.name = name;
        this.birth_date = birth_date;
        this.carMechanic = carMechanic;
    }

    public void setCarMechanic(CarMechanic carMechanic) {
        this.carMechanic = carMechanic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public boolean checkEngineIsOK() {
        carMechanic.getEngine_capacity();
        /* do smth*/
        return true;
    }

    public boolean checkGearbox() {
        carMechanic.getGearbox();
        return true;
    }

    public void changeColor() {
        carMechanic.getColor();
        String new_color = "";
        carMechanic.setColor(new_color);
    }

    public void changeTank_placement() {
        carMechanic.getTank_placement();
        String new_tank_placement = "";
        carMechanic.setTank_placement(new_tank_placement);
    }

}
