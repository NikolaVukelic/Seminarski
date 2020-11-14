/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.user;

import domain.GeneralEntity;
import domain.User;
import so.AbstractGenericOperation;

/**
 *
 * @author Kuzner
 */
public class PrijavljivanjeSO extends AbstractGenericOperation {

    private GeneralEntity entity1;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof User)) {
            throw new Exception("Invalid parameter type!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        entity1 = databaseBroker.prijavljivanje((User) entity);
    }

    public GeneralEntity getEntity() {
        return entity1;
    }

}
