package services.Impl;

import model.Cabinet;
import services.CabinetService;
import play.db.jpa.Transactional;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public class CabinetServiceImpl implements CabinetService {
    @Transactional(readOnly = true)
    public Cabinet getCabinetById(int id) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<Cabinet> getCabinetsList() {
        return null;
    }

    @Transactional
    public void AddCabinet(Cabinet cabinet) {

    }

    @Transactional
    public void RemoveCabinet(int cabinetId) {

    }

    @Transactional
    public void RemoveAllCabinets() {

    }
}
