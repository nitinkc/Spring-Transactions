package com.learn.transaction.myAdmissionService.daoService;

import com.learn.transaction.myAdmissionService.entity.Hostel;
import com.learn.transaction.myAdmissionService.entity.Society;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SocietyService {
    @Autowired
    private SocietyRepository societyRepository;

    public void saveSociety(Society society){
        societyRepository.save(society);
    }

    public void deleteSociety(Society society){
        societyRepository.delete(society);
    }
}
