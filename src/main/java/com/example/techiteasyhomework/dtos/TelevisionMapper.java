package com.example.techiteasyhomework.dtos;

import com.example.techiteasyhomework.models.Television;

public class TelevisionMapper {

    public static Television fromInputDtoToModel(TelevisionInputDto televisionInputDto) {
        var t = new Television();
        t.setType(televisionInputDto.getType());
        t.setName(televisionInputDto.getName());
        t.setBrand(televisionInputDto.getBrand());
        t.setPrice(televisionInputDto.getPrice());
        t.setAvailableSize(televisionInputDto.getAvailableSize());
        t.setRefreshRate(televisionInputDto.getRefreshRate());
        t.setScreenType(televisionInputDto.getScreenType());
        t.setScreenQuality(televisionInputDto.getScreenQuality());
        t.setSmartTv(televisionInputDto.isSmartTv());
        t.setWifi(televisionInputDto.isWifi());
        t.setVoiceControl(televisionInputDto.isVoiceControl());
        t.setHdr(televisionInputDto.isHdr());
        t.setBluetooth(televisionInputDto.isBluetooth());
        t.setAmbiLight(televisionInputDto.isAmbiLight());
        t.setOriginalStock(televisionInputDto.getOriginalStock());
        t.setSold(televisionInputDto.getSold());

        return t;
    }

    public static TelevisionOutputDto fromModelToDto(Television television) {
        TelevisionOutputDto televisionDto = new TelevisionOutputDto();
        televisionDto.setId(television.getId());
        televisionDto.setType(television.getType());
        televisionDto.setName(television.getName());
        televisionDto.setBrand(television.getBrand());
        televisionDto.setPrice(television.getPrice());
        televisionDto.setAvailableSize(television.getAvailableSize());
        televisionDto.setRefreshRate(television.getRefreshRate());
        televisionDto.setScreenType(television.getScreenType());
        televisionDto.setScreenQuality(television.getScreenQuality());
        televisionDto.setSmartTv(television.isSmartTv());
        televisionDto.setWifi(television.isWifi());
        televisionDto.setVoiceControl(television.isVoiceControl());
        televisionDto.setHdr(television.isHdr());
        televisionDto.setBluetooth(television.isBluetooth());
        televisionDto.setAmbiLight(television.isAmbiLight());
        televisionDto.setOriginalStock(television.getOriginalStock());
        televisionDto.setSold(television.getSold());

        return televisionDto;
    }
}
