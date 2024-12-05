package service;
import model.Proprietario;
import repository.ProprietarioRepository;

import java.sql.*;
import java.util.*;

public class ProprietarioService {
    ProprietarioRepository proprietarioRepository = new ProprietarioRepository();


    public Map<Proprietario, Integer> getSuperfice() {return proprietarioRepository.superficePosseduta();}
    public List<String> proprietariVilla(){return proprietarioRepository.possessoriVilla();}

}
