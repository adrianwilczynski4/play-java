package services;

import model.PossibleVisits;
import model.Room;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */

public interface PossibleVisitsService {

    List<Room> getAllPossibleVisitsForDoctor(int Doctorsid);//TODO
    void addPossibleVisit (PossibleVisits possibleVisit);//TODO
    void removePossibleVisit(int visitId);//TODO

    void bookPossibleVisit(int visitId);//TODO
}
