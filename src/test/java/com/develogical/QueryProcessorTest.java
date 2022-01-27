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

        assertThat(queryProcessor.process("which of the following numbers is the largest: 24, 738"),
        containsString("738"));
    }

    @Test
    public void knowsAboutPrimes() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 572, 131, 74, 99"), containsString("131"));
    }

    @Test
    public void knowsAboutFibo() throws Exception {
        assertThat(queryProcessor.process("what is the 4th number in the Fibonacci sequence"), containsString("3"));
    }

    @Test
    public void knowsAboutAddingNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 206 plus 202"),
                containsString("408"));
    }

    @Test
    public void knowsAboutSubtractingNumbers() throws Exception {
        assertThat(queryProcessor.process("what is 10 minus 13"),
                containsString("-3"));
    }

    @Test
    public void knowsAboutSquareAndCubeNumbers() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 324, 280"),
                containsString("none"));
    }

    @Test
    public void knowsAboutJamesBond() throws Exception {
        assertThat(queryProcessor.process("who played James Bond in the film Dr No"),
                containsString("Sean Connery"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }
}
