package br.com.alura.loja.resource;


import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import com.thoughtworks.xstream.XStream;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("carrinhos")
public class CarrinhoResource {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") long id) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        return carrinho.toXML();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response adiciona(String conteudo) {
        Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
        new CarrinhoDAO().adiciona(carrinho);
        URI uri = URI.create("/carrrinhos/" + carrinho.getId());
        return Response.created(uri).build();
    }

    @Path("{id}/produtos/{produtoId}")
    @DELETE
    public Response removeProduto(@PathParam("id") long id, @PathParam("produtoId") long produtoId) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        carrinho.remove(produtoId);
        return Response.ok().build();
    }

    @Path("{id}/produtos/{produtoId}")
    @PUT
    public Response alteraProduto(@PathParam("id") long id, @PathParam("produtoId") long produtoId, String conteudo) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        Produto produto = (Produto) new XStream().fromXML(conteudo);
        carrinho.troca(produto);
        return Response.ok().build();
    }
}