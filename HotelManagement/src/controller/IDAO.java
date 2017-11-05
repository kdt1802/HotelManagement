/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TuanTA
 * @param <T>
 */
public abstract class IDAO<T> {
    Connection conn;
    Statement stm;
    PreparedStatement preStm;
    ResultSet rs;
    
    public abstract ResultSet getAll();
    public abstract ResultSet getByName(String name);
    public abstract int  insert(T obj);
    public abstract int  update(T obj);
    public abstract int delete(int id);
}
