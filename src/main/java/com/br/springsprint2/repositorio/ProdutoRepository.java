package com.br.springsprint2.repositorio;

import java.util.List;

import com.br.springsprint2.dominio.Pedido;
import com.br.springsprint2.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findOneByIdProduto(Integer id);
}
