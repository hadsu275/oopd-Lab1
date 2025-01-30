import java.awt.*;

public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected String modelName;// The car model name
    private Color color;
    protected double x;    // this two instans object for move class
    protected  double y;
    protected String direction;
    //private final static double trimFactor = 1.25;

    public Car(int nrDoors, double enginePower, String modelName, Color color) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        this.stopEngine();
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public String getModelName(){
        return modelName;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);

    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    public void gas(double amount){
        if (amount > 1 || amount < 0){
            throw new IllegalArgumentException("currentSpeed får inte vara i intervall [0, 1]");

        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if (amount > 1 || amount < 0) {
            throw new IllegalArgumentException("currentSpeed får inte vara i intervall [0, 1]");
        }
        decrementSpeed(amount);
    }

    @Override
    public void move() {
        if (direction.equals("North")) {
            y = y + currentSpeed;
        }
        if (direction.equals("West")){
            x = x - currentSpeed;
        }
        if (direction.equals("East")){
            x = x + currentSpeed;
        }
        if (direction.equals("South")){
            y = y - currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        switch (direction){
            case "North" -> direction = "West";
            case "West" -> direction = "South";
            case "South" -> direction = "East";
            case "East" -> direction = "North";
        }
    }
    @Override
    public void turnRight() {
        switch (direction){
            case "North" -> direction = "East";
            case "East" -> direction = "South";
            case "South" -> direction = "West";
            case "West" -> direction = "North";
        }
    }
}