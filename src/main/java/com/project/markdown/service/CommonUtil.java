package com.project.markdown.service;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CommonUtil {

    private final static String LOCAL_PATH = "static/md/";

    public String markdown(String filename) throws IOException {
        Parser parser = Parser.builder().build();
        Node doc = parser.parse(getMarkdownValueFormLocal(filename));
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(doc);

    }

    public String getMarkdownValueFormLocal(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        ClassPathResource classPathResource = new ClassPathResource(LOCAL_PATH + filename);

        BufferedReader br = Files.newBufferedReader(Paths.get(classPathResource.getURI()));
        br.lines().forEach(line -> sb.append(line).append("\n"));

        return sb.toString();
    }
}
