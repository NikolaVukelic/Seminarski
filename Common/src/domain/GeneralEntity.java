/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Kuzner
 */
public interface GeneralEntity extends Serializable {

    public String getAtrValue();
    public String setAtrValue();
    public String getTableName();
    public String getWhereCondition();
    public List<GeneralEntity> getList(ResultSet rs) throws Exception;
    public void setPrimaryKey(int id);
    public List<GeneralEntity> vratiListu();
    public GeneralEntity getEntity(ResultSet rs) throws Exception;
    
}
