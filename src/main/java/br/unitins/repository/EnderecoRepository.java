package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.musica.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {
    
    public List<Endereco> findByNome(String bairro){
        return find("bairro like ?1", '%'+bairro+'%').list();
    }

}