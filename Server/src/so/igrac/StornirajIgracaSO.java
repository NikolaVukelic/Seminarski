/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.igrac;

import domain.Igrac;
import so.AbstractGenericOperation;

/**
 *
 * @author Nikola
 */
public class StornirajIgracaSO extends AbstractGenericOperation {

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Igrac)) {
            throw new Exception("Invalid parameter type!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        databaseBroker.storniraj((Igrac) entity);
    }

}
