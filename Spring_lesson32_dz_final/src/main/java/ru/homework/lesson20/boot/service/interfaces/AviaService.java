package ru.homework.lesson20.boot.service.interfaces;


import ru.homework.lesson20.boot.domain.Avia;

import java.util.Collection;

public interface AviaService {

    Collection<Avia> getAll();
    Avia seeOne(Long id);
    void addAvia(Avia avia);
    void deleteAvia(Long id);
    Avia updateAvia(Avia avia);
    void changeTitle(String title, long id);
}
