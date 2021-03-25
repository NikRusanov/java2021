package com.rusanov;

public class Main {

    public static void main(String[] args) {
        Text text = new Text("src/main/resources/vim1.txt");
        System.out.println(text.calculateAdjectivesStatistic(5, 20));

    }
}
