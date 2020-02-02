package com.learn.transaction.myAdmissionService.daoService;

import com.learn.transaction.myAdmissionService.entity.Department;
import com.learn.transaction.myAdmissionService.entity.Hostel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nitin on Saturday, February/01/2020 at 3:39 PM
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class HostelService {
    @Autowired
    private HostelRepository hostelRepository;

    public void saveHostel(Hostel hostel){
        hostelRepository.save(hostel);
    }

    public void deleteHotel(Hostel hostel){
            hostelRepository.delete(hostel);
    }
}
