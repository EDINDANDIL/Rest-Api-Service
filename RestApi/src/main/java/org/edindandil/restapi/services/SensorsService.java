package org.edindandil.restapi.services;

import org.edindandil.restapi.exceptions.SensorNotFoundException;
import org.edindandil.restapi.model.Sensor;
import org.edindandil.restapi.repositories.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorsService {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorsRepository.save(sensor);
    }

    public Optional<Sensor> findOneByName(String name) {
        return sensorsRepository.findByName(name);
    }

    public Sensor findOneByNameOrElseThrowException(String name) {
        return sensorsRepository.findByName(name).orElseThrow(SensorNotFoundException::new);
    }
}