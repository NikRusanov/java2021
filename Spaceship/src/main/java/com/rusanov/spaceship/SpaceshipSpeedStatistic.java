package com.rusanov.spaceship;

import java.util.List;

public class SpaceshipSpeedStatistic {

    private final List<Spaceship> spaceships;

    public SpaceshipSpeedStatistic(List<Spaceship> spaceships) {
        this.spaceships = spaceships;
    }

    public double getAverageSpeed() {
        double speed = 0.0;
        if(spaceships == null || spaceships.isEmpty()) {
            return speed;
        }
        int spaceshipCount = spaceships.size();
        for(Spaceship spaceship : spaceships) {
            speed += spaceship.getSpeed()/ (double) spaceshipCount;
        }
        return speed;
    }


    public int getMinimumSpeed() {
        if(spaceships == null || spaceships.isEmpty()) {
            return 0;
        }
        return spaceships.stream()
                .mapToInt((spaceship) ->  Math.abs(spaceship.getSpeed()) )
                .min().getAsInt();
    }


//bigInt
//    public BigDecimal getAverageSpeed() {
//        BigDecimal speed = new BigDecimal("0.0");
//        if(spaceships == null || spaceships.isEmpty()) {
//            return speed;
//        }
//        int spaceshipCount = spaceships.size();
//        for(Spaceship spaceship : spaceships) {
//            BigDecimal avgSingleShip = BigDecimal.valueOf(spaceship.getSpeed());
//            avgSingleShip = avgSingleShip.divide(BigDecimal.valueOf(spaceshipCount), RoundingMode.HALF_UP);
//            speed = speed.add(avgSingleShip);
//        }
//        return speed;
//    }
}
