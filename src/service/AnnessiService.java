package service;

import repository.AnnessiRepository;

public class AnnessiService {
    AnnessiRepository oAnnessiRepository = new AnnessiRepository();

    public int numeroBox(){return oAnnessiRepository.nBox();}
}
