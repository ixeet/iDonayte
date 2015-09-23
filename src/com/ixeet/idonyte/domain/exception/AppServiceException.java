/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ixeet.idonyte.domain.exception;

/**
 *
 * @author dell
 */
public class AppServiceException extends Exception {

    /**
     * Creates a new instance of
     * <code>LmsDaoException</code> without detail message.
     */
    public AppServiceException() {
    }

    /**
     * Constructs an instance of
     * <code>LmsDaoException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public AppServiceException(String msg) {
        super("Exception occured at service layer : "+msg);
    }
}
