package app.service;

import app.dao.BloodDAO;
import app.model.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("bloodService")
public class BloodService {
    @Autowired
    BloodDAO bloodDAO;

    @Transactional
    public List<Blood> getAllBloods() {

        return bloodDAO.getAllBloods();
    }

    @Transactional
    public Blood getBlood(int id) {

        return bloodDAO.getCompleteBloodCount(id);
    }

    @Transactional
    public void addBlood(Blood blood) {
        bloodDAO.addCompleteBloodCount(blood);
    }

    @Transactional
    public void updateBlood(Blood blood) {
        bloodDAO.updateCompleteBloodCount(blood);

    }

    @Transactional
    public void deleteBlood(int id) {
        bloodDAO.deleteCompleteBloodCount(id);

    }

}
