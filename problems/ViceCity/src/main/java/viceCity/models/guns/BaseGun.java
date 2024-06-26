package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun{

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;


    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NAME_NULL);
        }

        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0){

            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }

        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets < 0){
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }

        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getBulletsPerBarrel() {
        return 0;
    }

    @Override
    public boolean canFire() {

        return this.totalBullets > 0 || this.bulletsPerBarrel > 0;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

}
