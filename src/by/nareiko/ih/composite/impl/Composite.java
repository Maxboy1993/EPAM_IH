package by.nareiko.ih.composite.impl;

import by.nareiko.ih.composite.Component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private static final char WORD_DELIMETER = ' ';
    private static final String PARAGRAPH_DELIMETER = "\n    ";
    private List<Component> components = new ArrayList<>();
    private Type type;

    public Composite(Type type){
        this.type = type;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public Component getComponent(int index) {
        return components.get(index);
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public List<Component> getComponents(String text) {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return components.equals(((Composite) o).components) &&
                type == ((Composite) o).type;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result += prime*result + components.hashCode();
        result += prime*result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringComponents = new StringBuilder();
        for (Component elem : components){
            switch (elem.getType()){
                case PARAGRAPH: stringComponents.append(PARAGRAPH_DELIMETER);
                break;
                case LEXEME: stringComponents.append(WORD_DELIMETER);
                break;
            }
            stringComponents.append(elem.toString());
        }
        return stringComponents.toString();
    }
}
