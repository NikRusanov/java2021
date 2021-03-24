package com.rusanov.shaceship;

import com.rusanov.spaceship.Spaceship;
import com.rusanov.spaceship.SpaceshipSpeedStatistic;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SpacesShipStatisticTest {

    private static Double DOUBLE_DELTA = 0.001;
    @Test
    public void bigSpeedTest() {
        List<Spaceship> spaceships = new ArrayList<>(){{
            add(new Spaceship(Integer.MAX_VALUE));
            add(new Spaceship(Integer.MAX_VALUE));
            add(new Spaceship(Integer.MAX_VALUE));
        }};

        SpaceshipSpeedStatistic statistic = new SpaceshipSpeedStatistic(spaceships);
        assertEquals(Integer.MAX_VALUE, statistic.getAverageSpeed(), 0.001);
    }

    @Test
    public void emptyListShipTest() {
        List<Spaceship> spaceships = null;
        SpaceshipSpeedStatistic statistic = new SpaceshipSpeedStatistic(spaceships);
        assertEquals(0.0, statistic.getAverageSpeed(), 0.001);
    }

    @Test
    public void averageSpeedTest() {
        List<Spaceship> spaceships = new ArrayList<>(){{
            add(new Spaceship(10));
            add(new Spaceship(5));
            add(new Spaceship(2));
        }};

        SpaceshipSpeedStatistic statistic = new SpaceshipSpeedStatistic(spaceships);
        assertEquals(5.666, statistic.getAverageSpeed(), DOUBLE_DELTA);
    }

    @Test
    public void minimumSpeedTest() {
        List<Spaceship> spaceships = new ArrayList<>(){{
            add(new Spaceship(10));
            add(new Spaceship(5));
            add(new Spaceship(-2));
        }};

        SpaceshipSpeedStatistic statistic = new SpaceshipSpeedStatistic(spaceships);
        assertEquals(2, statistic.getMinimumSpeed());

    }}
