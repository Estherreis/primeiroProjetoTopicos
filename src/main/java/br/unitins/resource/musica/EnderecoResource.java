package br.unitins.resource.musica;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.musica.Endereco;
import br.unitins.repository.EnderecoRepository;

@Path("/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    private EnderecoRepository repository;

    @GET
    @Path("/all")
    public List<Endereco> getAll() {
        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Endereco getById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Path("/{nome}")
    public List<Endereco> getByNome(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

    @POST
    @Transactional
    public Endereco create(Endereco endereco) {
        repository.persist(endereco);
        return endereco;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Endereco update(@PathParam("id") Long id, Endereco endereco) {

        Endereco entity = repository.findById(id);

        if (endereco.getCep() != null) { 
            entity.setCep(endereco.getCep());
        }
        if (endereco.getBairro() != null) { 
            entity.setBairro(endereco.getBairro());
        }
        if (endereco.getLogradouro() != null) { 
            entity.setLogradouro(endereco.getLogradouro());
        }
        if (endereco.getNumero() != null) { 
            entity.setNumero(endereco.getNumero());
        }
        if (endereco.getComplemento() != null) { 
            entity.setComplemento(endereco.getComplemento());
        }

        return entity;
    }

    @DELETE
    public Boolean delete(@PathParam("id") Long id){

        return repository.deleteById(id);
    }

}
