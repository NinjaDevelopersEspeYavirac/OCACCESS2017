/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ocaccess.service;

import ec.edu.espe.ocaccess.dao.DAOServices;
import ec.edu.espe.ocaccess.dao.QueryParameter;
import ec.edu.espe.ocaccess.logger.L;
import ec.edu.espe.ocaccess.model.Nomina;
import ec.edu.espe.ocaccess.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

/**
 *
 * @author marlo
 */
public class NominaService {
    private final static L log = new L(NominaService.class);
    
    public static Nomina FindByCedula(String nominaCod) {
        Nomina findmNomina = null;
        try {
            DAOServices ds = new DAOServices(HibernateUtil.
                     getSessionFactory().getCurrentSession());
            QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
            query_1.setColumnName("nominaCod");
            query_1.setWhereClause("=");
            query_1.setValue(nominaCod);
            List parameList = new ArrayList();
            parameList.add(query_1);
            List < Nomina > listClients = ds.customQuery(parameList, Nomina.class);
                        if (!listClients.isEmpty()) {
                findmNomina = listClients.get(0);
                            }
        } catch (HibernateException ex) {
            log.level.info("FindByCedula : " + ex.getMessage());
        }

        return findmNomina;
    }
}
