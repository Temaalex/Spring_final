package ru.homework.lesson20.boot.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import ru.homework.lesson20.boot.dto.AviaDto;

import ru.homework.lesson20.boot.service.interfaces.AviaService;
import ru.homework.lesson20.boot.service.interfaces.Mapper;

import java.util.Collection;
import java.util.stream.Collectors;


@RequestMapping("/api/v1/avia")
@RestController
public class AviaControllers {
    private AviaService aviaService;
    private Mapper mapper;

    @Autowired
    public AviaControllers(AviaService aviaService, Mapper mapper) {
        this.aviaService = aviaService;
        this.mapper = mapper;
    }
    @GetMapping
    public Collection<AviaDto> getAllOpera(){
        return aviaService.getAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public AviaDto getAvia(@PathVariable("id") Long id){
        return mapper.toDto(aviaService.seeOne(id));
    }
    @PostMapping("/add")
    public void addAvia(@RequestBody AviaDto aviaDto){
        aviaService.addAvia(mapper.toDomain(aviaDto));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAvia(@PathVariable("id") Long id){
        aviaService.deleteAvia(id);
    }
    @PutMapping("/update/{id}")
    public void updateAvia(@RequestBody AviaDto aviaDto, @PathVariable("id") Long id){
        aviaService.updateAvia(mapper.toDomain(aviaDto));
    }
    @PostMapping("/updateTitle/{title}/{id}")
    public void changeTitle(@PathVariable("title") String title, @PathVariable Long id){
        aviaService.changeTitle(title, id);
    }

}
