package net.twonky.demo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.stream.Collectors;

public class ListTrim {

    private static String line = "one,two, three, four , five ";

    // 1.

    static List<String> simpleSplitNoElementTrimming(String line) {
        return Arrays.asList(line.split(","));
    }

    // 2.

    static List<String> plainJavaSplitAndTrim(String line) {
        List<String> list = new ArrayList<String>();
        for (String s : Arrays.asList(line.split(","))) {
            list.add(s.trim());
        }
        return list;
    }

    // 3.

    private static List<String> trimElements(List<String> list) {
        List<String> trimmed = new ArrayList<String>();
        for (String s : list) trimmed.add(s.trim());
        return trimmed;
    }

    static List<String> plainJavaUsingMethod(String line) {
        return trimElements(Arrays.asList(line.split(",")));
    }

    // 4.

    static List<String> apacheCollectionTrimUsingTransformer(String line) {
        return (List<String>)
            CollectionUtils.collect(Arrays.asList(line.split(",")), new Transformer<String,String>() {
                    public String transform(String s) {
                        return s.trim();
                    }
                });
    }

    // 5.

    private static Transformer<String,String> trimTransformer = new Transformer<String,String>() {
        public String transform(String s) {
            return s.trim();
        }};

    static List<String> apacheCollectionsTrimUingPredefinedTransformer(String line) {
        return (List<String>)CollectionUtils.collect(Arrays.asList(line.split(",")), trimTransformer);
    }

    // 6.

    static List<String> googleGuavaTrimUsingLists(String line) {
        return
            Lists.transform(Arrays.asList(line.split(",")), new Function<String, String>() {
                    public String apply(String in) {
                        return in.trim();
                    }
                });
    }

    // 7.

    private static Function<String,String> trimFunction = new Function<String, String>() {
        public String apply(String in) {
            return in.trim();
        }
    };

    static List<String> googleGuavaTrimUsingListsAndPredefinedFunction(String line) {
        return Lists.transform(Arrays.asList(line.split(",")), trimFunction);
    }

    // 8.

    static List<String> java8ClosureCollectingStreamIntoList(String line) {
        return Arrays.asList(line.split(",")).stream().map(String::trim).collect(Collectors.toList());
    }

    // 9.

    static List<String> regexTrimOnTrimmedInputNoNeedToTrimElements(String line) {
        return Arrays.asList(line.trim().split("\\s*,\\s*"));
    }

    public static void main(String[] args) {
        System.out.println(simpleSplitNoElementTrimming(line));
        System.out.println(plainJavaSplitAndTrim(line));
        System.out.println(plainJavaUsingMethod(line));
        System.out.println(apacheCollectionTrimUsingTransformer(line));
        System.out.println(apacheCollectionsTrimUingPredefinedTransformer(line));
        System.out.println(googleGuavaTrimUsingLists(line));
        System.out.println(googleGuavaTrimUsingListsAndPredefinedFunction(line));
        System.out.println(java8ClosureCollectingStreamIntoList(line));
        System.out.println(regexTrimOnTrimmedInputNoNeedToTrimElements(line));
    }
}
