package by.nareiko.informatinHandling.dao;

import by.nareiko.informatinHandling.exception.DaoException;

import java.util.List;

public interface TextDao {
    String read (String filePath) throws DaoException;
}
