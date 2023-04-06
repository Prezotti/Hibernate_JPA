package testes;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
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
