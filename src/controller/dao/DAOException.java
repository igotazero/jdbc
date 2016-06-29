package controller.dao;

/**
 * Created by Andrei_Zanozin on 6/29/2016.
 */
public class DAOException extends Exception {
        public DAOException(String message, Throwable cause) {
            super(message,cause);
        }
        public DAOException(String message) {
            super(message);
        }
        public DAOException() {
            super();
        }
}