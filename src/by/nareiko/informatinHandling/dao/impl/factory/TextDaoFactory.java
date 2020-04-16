package by.nareiko.informatinHandling.dao.impl.factory;

import by.nareiko.informatinHandling.dao.TextDao;
import by.nareiko.informatinHandling.dao.impl.TextDaoImpl;

public class TextDaoFactory {
    private static final TextDaoFactory instance = new TextDaoFactory();
    private TextDao textDao;
    private TextDaoFactory(){}

    public TextDao getTextDao(){
        if (textDao == null){
            textDao = new TextDaoImpl();
        }
        return textDao;
    }
}
