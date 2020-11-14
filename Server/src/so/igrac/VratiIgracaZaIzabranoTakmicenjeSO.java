/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.igrac;

import domain.GeneralEntity;
import domain.Igrac;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class VratiIgracaZaIzabranoTakmicenjeSO extends AbstractGenericOperation {

    private List<GeneralEntity> list;
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Igrac)) {
            throw new Exception("Invalid parameter type!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = databaseBroker.vratiSaUslovom((Igrac) entity);
    }

    public List<GeneralEntity> getList() {
        return list;
    }
}
