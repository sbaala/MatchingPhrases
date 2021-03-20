package com.squareshift.app;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import com.google.common.io.Resources;

public class Sample {

public static void main(String args[]) throws URISyntaxException {
	
    Sample app = new Sample();
    
    URL url = Resources.getResource("data/dictionary.conf");
    System.out.println(url.getPath());

}

private File getFileFromResource(String fileName) throws URISyntaxException{

    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource(fileName);
    if (resource == null) {
        throw new IllegalArgumentException("file not found! " + fileName);
    } else {

        // failed if files have whitespaces or special characters
        //return new File(resource.getFile());

        return new File(resource.toURI());
    }

}

private static void printFile(File file) {

    List<String> lines;
    try {
        lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
