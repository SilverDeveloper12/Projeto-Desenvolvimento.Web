package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class PessoaService {

    private AtomicInteger contador = new AtomicInteger(0);

    private Map<String, Pessoa> mapPessoas = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        mapPessoas.put("fulano", new Pessoa(contador.incrementAndGet(),
                "fulano", "Fulano da Silva",
                "fulano@email.com", "(11) 99999-1234", LocalDate.parse("2000-10-20")));
        mapPessoas.put("ciclano", new Pessoa(contador.incrementAndGet(),
                "ciclano", "Ciclano da Silva",
                "ciclano@email.com", "(11) 98888-5678", LocalDate.parse("1999-05-10")));
        mapPessoas.put("beltrana", new Pessoa(contador.incrementAndGet(),
                "beltrana", "Beltrana da Silva",
                "beltrana@email.com", "(11) 97777-9012", LocalDate.parse("2001-02-23")));
        mapPessoas.put("zinogre", new Pessoa(contador.incrementAndGet(),
                "zinogre", "Zinogre de Yukumo",
                "zinogre@yukomemail.com", "(11) 97999-1234", LocalDate.parse("2010-10-20")));
    }

    public List<Pessoa> obterPessoas() {
        return new ArrayList<>(mapPessoas.values());
    }
    public Optional<Pessoa> obterPessoa(String username) {
        return Optional.ofNullable(mapPessoas.get(username));
    }

}
