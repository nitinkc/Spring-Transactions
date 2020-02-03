package com.learn.transaction.myAdmissionServiceJDBC.service;

import com.learn.transaction.myAdmissionService.entity.Society;
import com.learn.transaction.myAdmissionServiceJDBC.dao.SocietyDao;
import com.learn.transaction.myAdmissionServiceJDBC.dao.SocietyDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
@Transactional(propagation = Propagation.NEVER)
public class SocietyServiceJDBC {
    @Autowired
    private SocietyDaoImpl societyRepository;

    public void saveSociety(Society society){
        societyRepository.save(society);
    }

    public void deleteSociety(Society society){
        societyRepository.delete(society);
    }
}
