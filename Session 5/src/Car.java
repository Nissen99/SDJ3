public class Car {

    private int weight;
    private int numberOfDoors;
    private String modelNumber;


    public Car(int weight, int numberOfDoors, String modelNumber) {
        this.weight = weight;
        this.numberOfDoors = numberOfDoors;
        this.modelNumber = modelNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }


}
