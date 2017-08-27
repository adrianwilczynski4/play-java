package dao;

import model.Cabinet;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface CabinetDAO {

    Cabinet getCabinetById(int id);

    List<Cabinet> getCabinetsList();
    void AddCabinet(Cabinet cabinet);
    void RemoveCabinet(int cabinetId);
    void RemoveAllCabinets();

}
