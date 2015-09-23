/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.domain.exception;

/**
 *
 * @author dell
 */
public class AppDaoException extends Exception {

    /**
     * Creates a new instance of
     * <code>LmsDaoException</code> without detail message.
     */
    public AppDaoException() {
    }

    /**
     * Constructs an instance of
     * <code>LmsDaoException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public AppDaoException(String msg) {
        super("Exception occured at dao layer : "+msg);
    }
}
