/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ucesce;

import domain.GeneralEntity;
import domain.Ucesce;
import java.util.ArrayList;
import so.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class SacuvajUcesceSO extends AbstractGenericOperation{
    
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof ArrayList)) {
            throw new Exception("Invalid parameter type!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.kreirajListuObjekataSaKljucem((ArrayList<GeneralEntity>) entity);
    }
}
