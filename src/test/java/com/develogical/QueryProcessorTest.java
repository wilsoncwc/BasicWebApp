package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutImperial() throws Exception {
        assertThat(queryProcessor.process("Imperial"),
                containsString("university"));
    }

    @Test
    public void knowsAboutGNNs() throws Exception {
        assertThat(queryProcessor.process("GNN"),
                containsString("Graph neural networks"));
    }

    
    @Test
    public void knowsAboutBiggestNumber() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 674, 388, 27, 93"),
                containsString("674"));
    }
    
    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
