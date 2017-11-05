/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Service_Controller;
import java.sql.ResultSet;

/**
 *
 * @author sev_user
 */
public class ServiceBLL {

    Service_Controller mServiceCtl = new Service_Controller();

    public int updateService(Service service) {
        return mServiceCtl.updateServive(service);
    }

    public int addService(Service addService) {
        return mServiceCtl.addService(addService);
    }

    public ResultSet getServiceAvailable() {
        return mServiceCtl.getServiceAvailable();
    }

    public int deleteService(int serviceID) {
        return mServiceCtl.deleteService(serviceID);
    }

    public ResultSet getServiceByName(String serviceName) {
        return mServiceCtl.getServiceByName(serviceName);
    }

    public int updateService(int serviceID, int newUnit, int newStatus) {
        return mServiceCtl.updateService(serviceID, newUnit, newStatus);
    }

    public ResultSet getAllService() {
        return mServiceCtl.getAllService();
    }

}
