package by.nareiko.ih.parser.impl;

import by.nareiko.ih.composite.Component;
import by.nareiko.ih.composite.impl.Composite;
import by.nareiko.ih.composite.impl.Type;
import by.nareiko.ih.parser.Parser;

public class ParagraphParser implements Parser {
    private static ParagraphParser instance;
    private static final String PARAGRAPH_REGEX = "\\s{4}";
    private  SentenceParser sentenceParser;
    private Component componentSentence;
    private Component componentText;

    public static ParagraphParser getInstance(){
        if (instance == null){
            instance  = new ParagraphParser();
        }
        return instance;
    }
    @Override
    public Component parse(String value) {
        componentText = new Composite(Type.TEXT);
        String[] paragraphs = value.split(PARAGRAPH_REGEX);
        for (String element : paragraphs) {
             sentenceParser = SentenceParser.getInstance();
            componentSentence = sentenceParser.parse(element);
            componentText.add(componentSentence);
        }
        return componentText;
    }
}
