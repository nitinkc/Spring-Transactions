package com.learn.transaction.myAdmissionService.service;

import com.learn.transaction.myAdmissionService.dao.HostelRepository;
import com.learn.transaction.myAdmissionService.entity.Hostel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
public class HostelService {
    @Autowired
    private HostelRepository hostelRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveHostel(Hostel hostel){
        hostelRepository.save(hostel);
    }

    public void deleteHotel(Hostel hostel){
            hostelRepository.delete(hostel);
    }
}
