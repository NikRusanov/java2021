package com.rusanov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {
    private final String path;


    private static final List<String> wordEndings;
    private long countOfAdjectives;
    private final Map<String, Integer> adjectivesCount = new HashMap<>();
    static {
        //прилагательные, причастия, деепричастия и прочие Андреи с Василиями
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



    public Text(String path) {
        this.path = path;
    }


    public String calculateAdjectivesStatistic(int minLength, int maxLength) {
        double frequency = calculateFrequency(minLength, maxLength);
        return "Частота: " + frequency + "\nЧастота по популярности: \n" +
                getTopAdjectives(10);

    }

    public String getTopAdjectives(int count) {
        StringBuilder sb = new StringBuilder();
        adjectivesCount
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(count)
                .forEach(element -> {
                    sb.append(element.getKey());
                    sb.append(": ").append(element.getValue());
                    sb.append("\n");
                });
        return sb.toString();
    }


    private   double calculateFrequency(int minLength, int maxLength) {
        List<String> words = getWords();
        long countOfWords = words.size();
        if(words.isEmpty()) {
            return 0;
        }
        words.stream()
                .filter(s -> s.length() >= minLength && s.length() <= maxLength)
                .forEach(this::calculateAdjectives);

        return countOfAdjectives/(double)countOfWords;
    }

    private void calculateAdjectives(String word) {
        for (var ends: wordEndings) {
            if(word.endsWith(ends)) {
                incrementInMap(word);
                countOfAdjectives++;
            }
        }
    }

    private void incrementInMap(String word) {
        Integer count  = 0;
        if (adjectivesCount.containsKey(word)) {
            count = adjectivesCount.get(word);
        }
        adjectivesCount.put(word, ++count);

    }

    private List<String> getWords()  {
        List<String> words = new ArrayList<>();
        try(Stream<String> lineStream = Files.newBufferedReader(Path.of(path)).lines()) {
            words = filterWords(lineStream);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return words;
    }

    private List<String> filterWords(Stream<String> lineStream) {
        return lineStream.map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .map(s ->  s.replaceAll("(?U)[\\pP]", ""))
                .filter(s -> !s.isBlank() && !s.matches("^\\d+$"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }


}
