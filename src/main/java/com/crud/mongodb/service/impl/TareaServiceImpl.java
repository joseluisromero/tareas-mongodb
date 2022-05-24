package com.crud.mongodb.service.impl;

import com.crud.mongodb.model.Tarea;
import com.crud.mongodb.repository.TareaRepository;
import com.crud.mongodb.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> getAll() {
        return tareaRepository.findAll();
    }

    @Override
    public List<Tarea> findByCreated(Date initDate, Date endDate) {

        initDate=convertToDateViaInstant(convertToLocalDateTimeViaInstant(initDate).withHour(0).withMinute(0).minusSeconds(0).minusNanos(0));
        endDate=convertToDateViaInstant(convertToLocalDateTimeViaInstant(endDate).withHour(23).withMinute(59).minusSeconds(59).minusNanos(0));
        return tareaRepository.findByCreatedBetweenhgf(initDate, endDate);
    }
    private  LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }

    @Override
    public Tarea save(Tarea tarea) {
        tarea.setCreated(new Date());
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea findByName(String tarea) {
        return tareaRepository.findByNombre(tarea);
    }

    @Override
    public boolean deleteTarea(String id) {
        boolean res = false;
        try {

            Optional<Tarea> exis = tareaRepository.findById(id);
            if (exis.isPresent()) {
                tareaRepository.delete(exis.get());
                res = true;
            } else {
                res = false;
            }


        } catch (Exception e) {
            res = false;
        }
        return res;
    }
}
