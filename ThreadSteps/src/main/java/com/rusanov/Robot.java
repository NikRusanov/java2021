package com.rusanov;

public class Robot {
    private static Object lock = new Object();
    private final Step leftStep = new Step("left step", lock);
    private final Step rightStep = new Step("right step", lock);

    public void go() {
        leftStep.start();
        rightStep.start();
    }
}
