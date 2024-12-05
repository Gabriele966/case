package service;

import repository.ImmobileRepository;
import java.util.List;

public class ImmobileService {
    private ImmobileRepository immobileRepository = new ImmobileRepository();

    public List<String> listaVillaGiardino(){return immobileRepository.listaVillaGiardino();}

    public List<String> listaAppartamentiNovantaSei(){return immobileRepository.appartNovantaSei();}


}
