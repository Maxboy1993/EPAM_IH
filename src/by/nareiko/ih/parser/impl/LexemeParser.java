package by.nareiko.ih.parser.impl;

import by.nareiko.ih.composite.Component;
import by.nareiko.ih.composite.impl.Composite;
import by.nareiko.ih.composite.impl.Type;
import by.nareiko.ih.parser.Parser;

public class LexemeParser implements Parser {
    private static final String LEXEME_REGEX = " ";
    private static LexemeParser instance;
    private static SymbolParser symbolParser;
    private Component componentSentence;
    private Component component;

    public static LexemeParser getInstance() {
        if (instance == null){
            instance = new LexemeParser();
        }
        return instance;
    }

    @Override
    public Component parse(String value) {
        componentSentence = new Composite(Type.SENTENCE);
        String[] words = value.split(LEXEME_REGEX);
        for (String element : words) {
            symbolParser = SymbolParser.getInstance();
            component = symbolParser.parse(element);
            componentSentence.add(component);
        }
        return componentSentence;
    }
}
