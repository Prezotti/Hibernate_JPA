package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args) {
        //cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());
        List<Produto> produtos = produtoDao.buscarTodos();
        produtos.forEach(prod -> System.out.println(prod.getNome()));

    }

    public static void cadastrarProduto(){
        Categoria celulares = new Categoria("celulares");

        Produto celular = new Produto("IPhone 14 PRO", "Muito melhor", new BigDecimal("1000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
