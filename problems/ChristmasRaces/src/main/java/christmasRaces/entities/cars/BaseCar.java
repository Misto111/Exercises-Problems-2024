package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {

        if (model == null || model.trim().length() < 4) {
            String exceptionMessage = String.format(ExceptionMessages.INVALID_MODEL, model, 4);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.model = model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    private void setHorsePower(int horsePower) {
        this.checkHorsePower(horsePower);
        this.horsePower = horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }

    protected abstract void checkHorsePower(int horsePower);
}
