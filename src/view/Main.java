package view;

import model.Annessi;
import model.Proprietario;
import service.AnnessiService;
import service.ImmobileService;
import service.ProprietarioService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selezionare il tipo di operazione che si desidera effettuare:");
        System.out.println("1) Contare il nuemro di Box presenti nel DB:");
        System.out.println("2) Lista dei proprietari di ville con il giardino:");
        System.out.println("3) Ottenere la superfice posseduta da ogni proprietario:");
        System.out.println("4) Lista dei proprietari di una villa");
        System.out.println("5) Lista appartamenti dopo il 1996");
        int selta = scanner.nextInt();


        switch (selta) {
            case 1:
                nBox();
                break;
            case 2:
                villeGiardino();
                break;
            case 3:
                superficePropietario();
                break;
            case 4:
                proprietariDiVille();
                break;
            case 5:
                appartamentiNovantaSei();
                break;
                default:
                    System.out.println("Richiesta non valida");
        }
    }

    private static void appartamentiNovantaSei() {
        ImmobileService oImmobileService = new ImmobileService();
        List<String> immNovSei = new ArrayList<>();
        immNovSei = oImmobileService.listaAppartamentiNovantaSei();
        for (int i = 0; i < immNovSei.size(); i++) {
            System.out.println(immNovSei.get(i));
        }
    }

    private static void proprietariDiVille() {
        ProprietarioService oProprietarioService = new ProprietarioService();
        List<String> prop = new ArrayList<>();
        prop = oProprietarioService.proprietariVilla();
        for(int i = 0; i < prop.size(); i++){
            System.out.println(prop.get(i));
        }

    }

    public static void nBox() {
        AnnessiService oAnnessiService = new AnnessiService();
        int box = oAnnessiService.numeroBox();
        System.out.println("ecco il numero dei box: ");
        System.out.println(box);
    }

    public static void villeGiardino() {
        ImmobileService oImmobileService = new ImmobileService();
        List<String> ls = oImmobileService.listaVillaGiardino();
        for(int i = 0; i < ls.size(); i++){
            System.out.println(ls.get(i));
        }
    }

    public static void superficePropietario() {
        ProprietarioService oProprietarioService = new ProprietarioService();
        Map<Proprietario, Integer> map = oProprietarioService.getSuperfice();

        for(Map.Entry<Proprietario, Integer> entry : map.entrySet()){

            System.out.println("Proprietario: " + entry.getKey().getNome() +" "+entry.getKey().getCognome() +" Metri Posseduti: " +entry.getValue());
        }
    }

}