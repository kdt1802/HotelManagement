/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author TuanTA
 */
public class Server implements Serializable{
    private String server;
    private String serverUser;
    private String serverPassword;

    public Server(String server, String serverUser, String serverPassword) {
        this.server = server;
        this.serverUser = serverUser;
        this.serverPassword = serverPassword;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServerUser() {
        return serverUser;
    }

    public void setServerUser(String serverUser) {
        this.serverUser = serverUser;
    }

    public String getServerPassword() {
        return serverPassword;
    }

    public void setServerPassword(String serverPassword) {
        this.serverPassword = serverPassword;
    }
    
}
