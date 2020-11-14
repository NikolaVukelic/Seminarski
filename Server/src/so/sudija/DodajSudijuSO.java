/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sudija;

import domain.Sudija;
import so.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class DodajSudijuSO extends AbstractGenericOperation{
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Sudija)) {
            throw new Exception("Invalid parameter type!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.kreirajObjekatSaKljucem((Sudija) entity);
    }
}
