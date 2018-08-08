package app.dao;

import app.model.Blood;

import java.util.List;


public interface BloodDAO {

    List<Blood> getAllBloods();

    Blood getCompleteBloodCount(int id);

    Blood addCompleteBloodCount(Blood blood);

    void updateCompleteBloodCount(Blood blood);

    void deleteCompleteBloodCount(int id);


}
