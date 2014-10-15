package net.twonky.demo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ListTrimTest extends TestCase {

    private static String line = "one,two, three,four , five ";

    private static List<String> expectedNonTrimmedResult = new ArrayList<String>() {{
            add("one"); add("two"); add(" three"); add("four "); add(" five ");
        }};

    private static List<String> expectedResult = new ArrayList<String>() {{
            add("one"); add("two"); add("three"); add("four"); add("five");
        }};


    public void testSimpleSplitNoElementTrimming() {
        assertTrue(expectedNonTrimmedResult.equals(ListTrim.simpleSplitNoElementTrimming(line)));
    }

	public void testPlainJavaSplitAndTrim() {
        assertTrue(expectedResult.equals(ListTrim.plainJavaSplitAndTrim(line)));
	}

	public void testPlainJavaUsingMethod() {
        assertTrue(expectedResult.equals(ListTrim.plainJavaUsingMethod(line)));
	}

	public void testApacheCollectionsTrimUingTransformer() {
        assertTrue(expectedResult.equals(ListTrim.apacheCollectionTrimUsingTransformer(line)));
	}

	public void testApacheCollectionsTrimUingPredefinedTransformer() {
        assertTrue(expectedResult.equals(ListTrim.apacheCollectionsTrimUingPredefinedTransformer(line)));
	}

	public void testGoogleGuavaTrimUsingLists() {
        assertTrue(expectedResult.equals(ListTrim.googleGuavaTrimUsingLists(line)));
	}

	public void testGoogleGuavaTrimUsingListsAndPredefinedFunction() {
        assertTrue(expectedResult.equals(ListTrim.googleGuavaTrimUsingListsAndPredefinedFunction(line)));
	}

	public void testJava8ClosureCollectingStreamIntoList() {
        assertTrue(expectedResult.equals(ListTrim.java8ClosureCollectingStreamIntoList(line)));
	}

	public void testRegexTrimOnTrimmedInputNoNeedToTrimElements() {
        assertTrue(expectedResult.equals(ListTrim.regexTrimOnTrimmedInputNoNeedToTrimElements(line)));
	}

}
