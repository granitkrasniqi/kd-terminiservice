package com.karteladentare.kdterminiservice.service;

import com.karteladentare.kdterminiservice.domain.Termini;
import com.karteladentare.kdterminiservice.events.source.SimpleSourceBean;
import com.karteladentare.kdterminiservice.exceptions.TerminiNotFoundException;
import com.karteladentare.kdterminiservice.repository.TerminiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminiServiceImpl implements TerminiService {

    private TerminiRepository terminiRepository;

    private SimpleSourceBean simpleSourceBean;

    @Autowired
    public TerminiServiceImpl(TerminiRepository terminiRepository,SimpleSourceBean simpleSourceBean) {
        this.terminiRepository = terminiRepository;
        this.simpleSourceBean = simpleSourceBean;
    }

    @Override
    public List<Termini> ktheTeGjithTerminet() {
        return terminiRepository.findAll();
    }

    @Override
    public Termini shtoTerminin(Termini termini) {
        Termini terminiSaved = terminiRepository.save(termini);
        simpleSourceBean.publishTerminiChange("SAVE", terminiSaved.getId().toString());

        return terminiSaved;
    }

    @Override
    public Termini perditesoTerminin(Termini termini) throws TerminiNotFoundException {
        Optional<Termini> terminiOptional = terminiRepository.findById(termini.getId());

        if(terminiOptional.isPresent()) {
            return terminiRepository.save(termini);
        } else {
            throw new TerminiNotFoundException("Termini nuk egziston");
        }
    }

    @Override
    public void fshijTerminin(Long terminiId) throws TerminiNotFoundException {
        Optional<Termini> terminiOptional = terminiRepository.findById(terminiId);

        if(terminiOptional.isPresent()) {
            terminiRepository.delete(terminiOptional.get());
        } else {
            throw new TerminiNotFoundException("Termini me id: " + terminiId +
                                    " nuk egziston");
        }
    }

    @Override
    public Termini ktheTerminin(Long terminiId) throws TerminiNotFoundException {
        Optional<Termini> terminiOptional = terminiRepository.findById(terminiId);

        if(terminiOptional.isPresent()) {
            return terminiOptional.get();
        } else {
            throw new TerminiNotFoundException("Termini me id: " + terminiId +
                    " nuk egziston");
        }
    }

    @Override
    public List<Termini> KtheTerminetPacientId(Long pacientiId) {
        return terminiRepository.findAllByPacientiId(pacientiId);
    }
}
