package viceCity.models.players;

import viceCity.common.ExceptionMessages;
import viceCity.models.guns.Gun;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player {

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;


    public BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }

        this.name = name;
    }

    private void setLifePoints(int lifePoints) {

        if (lifePoints < 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }

        this.lifePoints = lifePoints;
    }

    private void setGunRepository(Repository<Gun> gunRepository) {


        this.gunRepository = gunRepository;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getLifePoints() {
        return 0;
    }

    @Override
    public boolean isAlive() {

        return this.lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return null;
    }

    @Override
    public void takeLifePoints(int points) {
//        this.lifePoints -= points;
//        if (this.lifePoints < 0) {
//            this.lifePoints = 0;
//        }
        this.lifePoints = Math.max(0, this.lifePoints - points);



    }
}
