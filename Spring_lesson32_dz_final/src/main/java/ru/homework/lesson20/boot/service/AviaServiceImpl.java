package ru.homework.lesson20.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ru.homework.lesson20.boot.domain.Avia;
import ru.homework.lesson20.boot.repository.interfaces.AviaRepository;
import ru.homework.lesson20.boot.service.interfaces.AviaService;
import ru.homework.lesson20.boot.service.interfaces.Mapper;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AviaServiceImpl implements AviaService {
    private AviaRepository aviaRepository;
    private Mapper mapper;

    @Autowired
    public AviaServiceImpl(AviaRepository aviaRepository, Mapper mapper) {
        this.aviaRepository = aviaRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<Avia> getAll() {return aviaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());}

    @Override
    public Avia seeOne(Long id){return mapper.toDomain(aviaRepository.getById(id));}

    @Override
    public void addAvia(Avia avia) {aviaRepository.save(mapper.toEntity(avia));}

    @Override
    public void deleteAvia(Long id){aviaRepository.deleteById(id);}

    @Override
    public Avia updateAvia(Avia avia) {return mapper.toDomain(aviaRepository.save(mapper.toEntity(avia)));}

    @Override
    public void changeTitle(String title, long id){
        aviaRepository.changeTitleName(title, id);
    }



}