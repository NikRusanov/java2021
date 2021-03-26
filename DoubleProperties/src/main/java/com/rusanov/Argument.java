package com.rusanov;

public class Argument implements Comparable<Argument> {
    String name;
    Double value;

    public Argument(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + "->" + value;
    }


    @Override
    public int compareTo(Argument o) {
        return  value.compareTo(o.getValue());
    }


}
