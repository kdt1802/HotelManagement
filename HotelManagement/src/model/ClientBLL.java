/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Client_Controller;

/**
 *
 * @author sev_user
 */
public class ClientBLL {

    Client_Controller clientCtrl = new Client_Controller();

    public Client getClientById(int ID) {
        return clientCtrl.getClientById(ID);
    }

    public String getNameById(int ID) {
        return clientCtrl.getNameById(ID);
    }

    public String getPhoneByID(int ID) {
        return clientCtrl.getPhoneByID(ID);
    }

    public int getLatestClientID() {
        return clientCtrl.getLatestClientID();
    }

    public int addNewClient(Client client) {
        return clientCtrl.addNewClient(client);
    }

    public int updateClient(Client client) {
        return clientCtrl.updateClient(client);
    }

    public int deleteByID(int ID) {
        return clientCtrl.deleteByID(ID);
    }

}
