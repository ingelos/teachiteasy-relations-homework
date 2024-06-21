package com.example.techiteasyhomework.services;

import com.example.techiteasyhomework.dtos.TelevisionInputDto;
import com.example.techiteasyhomework.dtos.TelevisionMapper;
import com.example.techiteasyhomework.dtos.TelevisionOutputDto;
import com.example.techiteasyhomework.exceptions.RecordNotFoundException;
import com.example.techiteasyhomework.models.Television;
import com.example.techiteasyhomework.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = televisionRepository.save(TelevisionMapper.fromInputDtoToModel(televisionInputDto));
        return TelevisionMapper.fromModelToDto(t);
    }

    public List<TelevisionOutputDto> getAllTelevisions() {
        List<Television> allTelevisions = televisionRepository.findAll();
        List<TelevisionOutputDto> televisionDtoList = new ArrayList<>();
        for (Television t : allTelevisions) {
            televisionDtoList.add(TelevisionMapper.fromModelToDto(t));
        }
        return televisionDtoList;
    }

    public TelevisionOutputDto getTelevisionById(Long id) {
        Optional<Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {
            return TelevisionMapper.fromModelToDto(t.get());
        } else {
            throw new RecordNotFoundException(("No television found with id: " + id));
        }
    }

    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    public TelevisionOutputDto updateTelevision(Long id, TelevisionInputDto updatedTelevision) {
        Optional<Television> t = televisionRepository.findById(id);
        if (t.isPresent()) {

            Television television1 = t.get();
            television1.setType(updatedTelevision.getType());
            television1.setName(updatedTelevision.getName());
            television1.setBrand(updatedTelevision.getBrand());
            television1.setPrice(updatedTelevision.getPrice());


            television1.setAvailableSize(updatedTelevision.getAvailableSize());
            television1.setRefreshRate(updatedTelevision.getRefreshRate());
            television1.setScreenType(updatedTelevision.getScreenType());
            television1.setScreenQuality(updatedTelevision.getScreenQuality());
            television1.setSmartTv(updatedTelevision.isSmartTv());
            television1.setWifi(updatedTelevision.isWifi());
            television1.setVoiceControl(updatedTelevision.isVoiceControl());
            television1.setHdr(updatedTelevision.isHdr());
            television1.setBluetooth(updatedTelevision.isBluetooth());
            television1.setAmbiLight(updatedTelevision.isAmbiLight());
            television1.setOriginalStock(updatedTelevision.getOriginalStock());
            television1.setSold(updatedTelevision.getSold());

            Television returnTelevision = televisionRepository.save(television1);
            return TelevisionMapper.fromModelToDto(returnTelevision);
        }
        else {
            throw new RecordNotFoundException("Geen televisie gevonden met id: " + id);
        }
    }
}
