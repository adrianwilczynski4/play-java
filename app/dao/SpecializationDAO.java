package dao;

import model.Specialization;

import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface SpecializationDAO {

    List<Specialization> getAllSpecializations(); //TODO

  //  List<Specialization> getSpecializationsForDoctor(int doctorsId);

    void AddSpecialization(Specialization specialization); //TODO

    void DeleteSpecialization(int specializationId); //TODO

    void DeleteAllSpecializations(); //TODO


}