/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ucesce;

import domain.GeneralEntity;
import domain.Ucesce;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class VratiUcescaZaIzabranoTakmicenjeSO extends AbstractGenericOperation {

    private List<GeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Ucesce)) {
            throw new Exception("Invalid parameter type!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.vratiSaUslovom((GeneralEntity) entity);
    }

    public List<GeneralEntity> getList() {
        return list;
    }

}
