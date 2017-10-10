/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ocaccess.test;

import ec.edu.espe.ocaccess.controller.NominaController;
import ec.edu.espe.ocaccess.model.Nomina;

/**
 *
 * @author luis
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Nomina obj = NominaController.FindByCedula("1709203671");
        System.out.println(">>"+obj.toString());
                
        
    }
    
}
