package com.github.binodnme.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author Binod Shrestha <binodshrestha@lftechnology.com> on 5/18/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("./template.mustache");


        mustache.execute(new PrintWriter(System.out), new Example()).flush();
    }

    private static class Example {
        List<Person> persons = Arrays.asList(new Person("name1", "address1"),
                new Person("name2", "address2"),
                new Person("name3", "address3"));
    }

}
