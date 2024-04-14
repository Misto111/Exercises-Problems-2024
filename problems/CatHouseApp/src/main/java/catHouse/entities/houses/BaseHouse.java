package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House{

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy : toys) {
            sum += toy.getSoftness();
        }

        return sum;
    }

    @Override
    public void addCat(Cat cat) {

        if (this.getCats().size() >= this.capacity) {
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.getCats().add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.getCats().remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {

        this.getToys().add(toy);
    }

    @Override
    public void feeding() {

        for (Cat cat : this.getCats()) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s %s%n", this.getName(), this.getClass().getSimpleName()));
        stringBuilder.append("Cats:");
        if (this.getCats().isEmpty()){
            stringBuilder.append("none");
        }else {
            stringBuilder.append(this.getCats().stream().map(Cat::getName).collect(Collectors.joining(" ")).trim());
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(String.format("Toys: %d Softness %d", this.getToys().size(), this.sumSoftness()));

        return stringBuilder.toString();
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;

    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.cats.size();
    }
}
