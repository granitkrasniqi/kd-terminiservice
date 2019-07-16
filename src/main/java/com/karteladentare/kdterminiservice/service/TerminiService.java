package com.karteladentare.kdterminiservice.service;

import com.karteladentare.kdterminiservice.domain.Termini;
import com.karteladentare.kdterminiservice.exceptions.TerminiNotFoundException;

import java.util.List;

public interface TerminiService {
    /**
     * Kthen te gjithe Terminet
     * @return Te gjitha terminet ne database
     */
    List<Termini> ktheTeGjithTerminet();

//    List<Pacienti> ktheTeGjithPacientetSipasAktiv(boolean aktiv);

    Termini shtoTerminin(Termini termini);

    Termini perditesoTerminin(Termini termini)
            throws TerminiNotFoundException;

    void fshijTerminin(Long terminiId) throws TerminiNotFoundException;

    Termini ktheTerminin(Long terminiId) throws TerminiNotFoundException;

    List<Termini> KtheTerminetPacientId(Long pacientiId);
}
