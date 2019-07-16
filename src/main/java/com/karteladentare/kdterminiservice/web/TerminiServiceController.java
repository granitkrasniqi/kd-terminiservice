package com.karteladentare.kdterminiservice.web;

import com.karteladentare.kdterminiservice.domain.Termini;
import com.karteladentare.kdterminiservice.exceptions.TerminiNotFoundException;
import com.karteladentare.kdterminiservice.service.TerminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@CrossOrigin
@RequestMapping(path = "/v1/terminet")
public class TerminiServiceController {

    private TerminiService terminiService;

    @Autowired
    public TerminiServiceController(TerminiService terminiService) {
        this.terminiService = terminiService;
    }


    @GetMapping
    public Iterable<Termini> ktheTerminet() {
        return terminiService.ktheTeGjithTerminet();
    }

    @GetMapping("/{terminiId}")
    public Termini ktheTerminin(@PathVariable("terminiId") Long terminiId) {
        try {
            return terminiService.ktheTerminin(terminiId);
        } catch (TerminiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/pacienti/{pacientId}")
    public Iterable<Termini> ktheTerminetPacientId(@PathVariable("pacientId") Long pacientiId) {
        return terminiService.KtheTerminetPacientId(pacientiId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Termini shtoTerminin(@RequestBody Termini termini) {
        return terminiService.shtoTerminin(termini);
    }

    @DeleteMapping("/{terminiId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void fshijTermini(@PathVariable("terminiId") Long terminiId) {
        try {
            terminiService.fshijTerminin(terminiId);
        } catch (TerminiNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/test")
    public void createTermin() {
        Termini t = new Termini();
        t.setPacientiId(60L);
        t.setShenime("Hello World");
        t.setDataTerminit(LocalDate.now());
        t.setKohaFillimit(LocalTime.now());
        t.setKohaMbarimit(LocalTime.now().plusMinutes(30));
        terminiService.shtoTerminin(t);
    }

}
