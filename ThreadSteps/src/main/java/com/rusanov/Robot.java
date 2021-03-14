package com.rusanov;

public class Robot {
    private final Step leftStep = new Step("left step");
    private final Step rightStep = new Step("right step");

    public void go() {
        leftStep.start();
        rightStep.start();
    }
}
