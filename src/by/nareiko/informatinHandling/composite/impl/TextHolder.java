package by.nareiko.informatinHandling.composite.impl;

import by.nareiko.informatinHandling.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextHolder implements TextComposite {
    private List<TextComposite> composites = new ArrayList<>();

    public void  addComposite(TextComposite composite){
        composites.add(composite);
    }

    public void removeComposite(TextComposite composite){
        composites.remove(composite);
    }

    @Override
    public List<String> parse(String text) {
        for (TextComposite elem:composites
             ) {
            elem.parse(text);
        }
        return null;
    }
}
