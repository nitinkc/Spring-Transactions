package com.learn.transaction.myAdmissionServiceJDBC.service;

import com.learn.transaction.myAdmissionService.entity.Hostel;
import com.learn.transaction.myAdmissionServiceJDBC.dao.HostelDao;
import com.learn.transaction.myAdmissionServiceJDBC.dao.HostelDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
@Transactional(propagation = Propagation.NEVER)
public class HostelServiceJDBC {
    @Autowired
    private HostelDaoImpl hostelRepository;

    public void saveHostel(Hostel hostel){
        hostelRepository.save(hostel);
    }

    public void deleteHotel(Hostel hostel){
            hostelRepository.delete(hostel);
    }
}
