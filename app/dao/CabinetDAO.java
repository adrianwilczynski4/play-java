package dao;

import model.Cabinet;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface CabinetDAO {

    Cabinet getCabinetById(int id);//TODO

    List<Cabinet> getCabinetsList();//TODO
    void AddCabinet(Cabinet cabinet);//TODO
    void RemoveCabinet(int cabinetId);//TODO
    void RemoveAllCabinets();//TODO

}
