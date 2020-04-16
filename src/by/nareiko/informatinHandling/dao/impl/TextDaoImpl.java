package by.nareiko.informatinHandling.dao.impl;

import by.nareiko.informatinHandling.dao.TextDao;
import by.nareiko.informatinHandling.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextDaoImpl implements TextDao {

    private static final String FILE_NAME = "src/by/nareiko/informatinHandling/resourses/resource";
    static Logger logger = LogManager.getLogger();
    @Override
    public String read(String filePath) throws DaoException {
        if (filePath == null || filePath.isEmpty()){
            filePath = FILE_NAME;
        }
        Path path = Paths.get(filePath);
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        }catch (IOException e){
            logger.log(Level.FATAL, "file: " + filePath + " is empty");
            throw  new DaoException("Mistake during reding!");
        }
        String text = "";
        for (int i = 0; i < lines.size(); i++) {
           text.concat(lines.get(i));
        }

        return text;
    }
}
