public class Car implements CarGassAttendant, CarMechanic {
    private String model;
    private String number;
    private String vin;
    private String type;    //e.g. corssover, hatchback, sportcar
    private String color;
    private String tank_placement;  //e.g. right/left/bottom side
    private String engine_capacity;
    private String type_of_engine; //e.g. hybrid/electricity/fuel
    private String gearbox; //e.g. mechanic/automatic/robot/


    public Car() {
    }

    public Car(String model, String number, String vin, String type, String color,
               String tank_placement, String engine_capacity, String type_of_engine, String gearbox) {
        this.model = model;
        this.number = number;
        this.vin = vin;
        this.type = type;
        this.color = color;
        this.tank_placement = tank_placement;
        this.engine_capacity = engine_capacity;
        this.type_of_engine = type_of_engine;
        this.gearbox = gearbox;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getEngine_capacity() {
        return engine_capacity;
    }

    public void setEngine_capacity(String engine_capacity) {
        this.engine_capacity = engine_capacity;
    }

    @Override
    public String getTank_placement() {
        return tank_placement;
    }

    @Override
    public void setTank_placement(String tank_placement) {
        this.tank_placement = tank_placement;
    }


    @Override
    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    @Override
    public String getType_of_engine() {
        return type_of_engine;
    }

    @Override
    public void setType_of_engine(String type_of_engine) {
        this.type_of_engine = type_of_engine;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", vin='" + vin + '\'' +
                ", type=" + type + '\'' +
                ", color=" + color + '\'' +
                ", tank placement=" + tank_placement + '\'' +
                ", engine capacity=" + engine_capacity +
                '}';
    }

}
