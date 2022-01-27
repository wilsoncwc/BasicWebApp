package com.develogical;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QueryProcessor {

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
            String[] splits = query.split(":");
            List<String> items = Arrays.asList(splits[1].split("\\s*,\\s*"));
            List<Integer> numbers = new ArrayList<>();
            for (String item : items) {
                String nospace = item.replaceAll("\\s+","");
                numbers.add(Integer.parseInt(nospace));
            }
            System.out.println(numbers);
            return Collections.max(numbers).toString();
        }
        return "";
    }
}
