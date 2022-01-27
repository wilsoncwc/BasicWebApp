package com.develogical;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class QueryProcessor {
    
    private List<Integer> getNumbersAfterColon(String query) {
        String[] splits = query.split(":");
        List<String> items = Arrays.asList(splits[1].split("\\s*,\\s*"));
        List<Integer> numbers = new ArrayList<>();
        for (String item : items) {
            String nospace = item.replaceAll("\\s+","");
            try {
                numbers.add(Integer.parseInt(nospace));
            } catch(NumberFormatException e) {
                // Do nothing    
            }
        }
        System.out.println(numbers);
        return numbers;
    }

    private boolean isPrime(int number) {
        return number > 1 
          && IntStream.rangeClosed(2, (int) Math.sqrt(number))
          .noneMatch(n -> (number % n == 0));
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }
        if (query.toLowerCase().contains("gnn")) {
            return "Graph neural networks (GNNs) are neural models that capture the dependence of graphs via message passing between nodes.";
        }
        if (query.toLowerCase().contains("largest")) {
            List<Integer> numbers = getNumbersAfterColon(query);
            return Collections.max(numbers).toString();
        }

        if (query.toLowerCase().contains("plus")) {
            List<String> splits = Arrays.asList(query.split(" "));
            int plusIndex = splits.indexOf("plus");
            int num1 = Integer.parseInt(splits.get(plusIndex - 1));
            int num2 = Integer.parseInt(splits.get(plusIndex + 1));
            return "" + (num1 + num2);
        }

        if (query.toLowerCase().contains("minus")) {
            List<String> splits = Arrays.asList(query.split(" "));
            int plusIndex = splits.indexOf("minus");
            int num1 = Integer.parseInt(splits.get(plusIndex - 1));
            int num2 = Integer.parseInt(splits.get(plusIndex + 1));
            return "" + (num1 - num2);
        }

        if (query.toLowerCase().contains("square and a cube")) {
            List<Integer> numbers = getNumbersAfterColon(query);
            for (Integer i : numbers) {
                double sqrt = Math.sqrt(i);
                if (sqrt % 1 == 0) {
                    double cuberoot = Math.cbrt(i);
                    if (cuberoot % 1 == 0 ) {
                        return i.toString();
                    }
                }
            }
            return "none";
        }
        if (query.toLowerCase().contains("square and a cube")) {
            List<Integer> numbers = getNumbersAfterColon(query);
            for (Integer i : numbers) {
                double sqrt = Math.sqrt(i);
                if (sqrt % 1 == 0) {
                    double cuberoot = Math.cbrt(i);
                    if (cuberoot % 1 == 0 ) {
                        return i.toString();
                    }
                }
            }
            return "none";
        }

        if (query.toLowerCase().contains("primes")) {
            List<Integer> numbers = getNumbersAfterColon(query);
            for (Integer i : numbers) {
                if (isPrime(i)) {
                    return i.toString();
                }
            }
        }

        if (query.toLowerCase().contains("james bond")) {
            return "Sean Connery";
        }
        return "";
    }
}
