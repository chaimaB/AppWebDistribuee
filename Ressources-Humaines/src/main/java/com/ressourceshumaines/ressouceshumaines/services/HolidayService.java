package com.ressourceshumaines.ressouceshumaines.services;

import com.netflix.discovery.converters.Auto;
import com.ressourceshumaines.ressouceshumaines.entities.Holiday;
import com.ressourceshumaines.ressouceshumaines.repositories.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private UserService userService;

    public Holiday addHoliday(Holiday holiday, String idUser) {
        holiday.setUser(userService.getUserById(idUser));
        return holidayRepository.save(holiday);
    }

    public Holiday getOneHoliday( int id) {
        return holidayRepository.getOne(id);
    }

    public Holiday updateHoliday(int id, Holiday newHoliday) {
        if (holidayRepository.findById(id).isPresent()) {
            Holiday existingHoliday = holidayRepository.findById(id).get();
            existingHoliday.setStartDate(newHoliday.getStartDate());
            existingHoliday.setEndDate(newHoliday.getStartDate());

            return holidayRepository.save(existingHoliday);
        } else
            return null;
    }
}
