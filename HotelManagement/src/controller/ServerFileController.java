/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Server;

/**
 *
 * @author TuanTA
 */
public class ServerFileController {

    public static void writeFile(Server server) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serverInfo.dat")));
            out.writeObject(server);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(ServerFileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerFileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Server readFile() {
        ObjectInputStream in = null;
        Server server = null;
        try {
            File f = new File("serverInfo.dat");
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serverInfo.dat")));
            server = (Server) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ServerFileController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ServerFileController.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return server;
    }
}