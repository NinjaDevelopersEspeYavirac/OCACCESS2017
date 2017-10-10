/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ocaccess.controller;

import ec.edu.espe.ocaccess.logger.L;
import ec.edu.espe.ocaccess.model.Nomina;
import ec.edu.espe.ocaccess.service.NominaService;
import ec.edu.espe.ocaccess.util.HibernateSessionHandler;
import ec.edu.espe.ocaccess.util.HibernateUtil;

/**
 *
 * @author marlo
 */
public class NominaController {
    
    private final static L log = new L(NominaController.class);
    static {
        HibernateUtil.init();
    }
    public static Nomina FindByCedula(String nominaCod) {
        Nomina findmNomina = null;
        HibernateSessionHandler hss = new HibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (nominaCod != null) {
                findmNomina = NominaService.FindByCedula(nominaCod);
            }
        } catch (Exception ex) {
            log.level.error("FindUserLogin : " + ex.getMessage());
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return findmNomina;

    
    }
    
}
