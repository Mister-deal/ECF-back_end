package org.example.Controller;

import org.example.Services.ClasseService;
import org.example.Services.EnseignantService;
import org.example.Services.EtablissementService;
import org.example.Services.MatièreService;

import java.util.Scanner;

public class Ihm {

    private final ClasseService classeService;
    private final EnseignantService enseignantService;
    private final EtablissementService etablissementService;
    private final MatièreService matièreService;
    private final Scanner scanner;


    public Ihm(ClasseService classeService, EnseignantService enseignantService, EtablissementService etablissementService, MatièreService matièreService, Scanner scanner) {
        this.classeService = classeService;
        this.enseignantService = enseignantService;
        this.etablissementService = etablissementService;
        this.matièreService = matièreService;
        this.scanner = scanner;
    }
}
