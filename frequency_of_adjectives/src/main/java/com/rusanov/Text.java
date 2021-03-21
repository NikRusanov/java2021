package com.rusanov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {
    private final String path;


    private static final List<String> wordEndings;
    static {
        //прилагательные, причастия, деепричастия
        wordEndings = new ArrayList<>();
        wordEndings.add("ой");
        wordEndings.add("ый");
        wordEndings.add("ий");
        wordEndings.add("ая");
        wordEndings.add("яя");
        wordEndings.add("ое");
        wordEndings.add("ее");
        wordEndings.add("ого");
        wordEndings.add("его");
        wordEndings.add("ей");
        wordEndings.add("ую");
        wordEndings.add("юю");
        wordEndings.add("ым");
        wordEndings.add("им");
        wordEndings.add("ом");
        wordEndings.add("ем");
    }
    private long countOfAdjectives;

    public Text(String path) {
        this.path = path;
    }




    public  double calculateFrequency(int minLength, int maxLength) {
        List<String> words = getWords();
        long countOfWords = words.size();
        if(words.isEmpty()) {
            return 0;
        }
        words.stream()
                .filter(s -> s.length() >= minLength && s.length() <= maxLength)
                .forEach(this::calculateAdjectives);
        return countOfAdjectives/(double)countOfWords*100;
    }

    private void calculateAdjectives(String s) {
        for (var ends: wordEndings) {
            if(s.endsWith(ends)) {
                countOfAdjectives++;
            }
        }
    }

    private List<String> getWords()  {
        List<String> words = new ArrayList<>();
        try(Stream<String> lineStream = Files.newBufferedReader(Path.of(path)).lines()) {
            words = filterWords(lineStream);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
     //   words.forEach(System.out::println);
        return words;
    }

    private List<String> filterWords(Stream<String> lineStream) {
        return lineStream.map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .map(s ->  s.replaceAll("(?U)[\\pP]", ""))
                .filter(s -> !s.isBlank() && !s.matches("^\\d+$"))
                .collect(Collectors.toList());
    }


}
