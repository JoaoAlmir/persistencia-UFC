package br.ufc.quixada.dao;

import java.time.LocalDate;
import java.util.List;

import br.ufc.quixada.entity.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoJPADAO extends GenericJPADAO<Produto> implements ProdutoDAO {

    public ProdutoJPADAO() {
        super(Produto.class);
    }

    public void delete(int id) {
        delete(new Produto(id));
    }

    public Produto find(int id) {
        return find(Integer.valueOf(id));
    }

    public Produto findCod(String cod) {
        EntityManager em = JPAUtil.getEntityManager();
        Produto produto = em.createQuery("select p from Produto p where p.codigo = :codigo",
                Produto.class).setParameter("codigo", cod).getSingleResult();
        JPAUtil.closeEntityManager();
        return produto;
    }

    // public List<Produto> findByNome(String nome) {
    // EntityManager em = JPAUtil.getEntityManager();
    // List<Produto> produtos = em.createQuery("select p from Produto p where
    // upper(p.nome) like upper(:nome)",
    // Produto.class).setParameter("nome", "%" + nome + "%").getResultList();
    // JPAUtil.closeEntityManager();
    // return produtos;
    // }

    public List<Produto> findDesc(String desc) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Produto> produtos = em
                .createQuery("select p from Produto p where upper(p.descricao) like upper(:descricao)",
                        Produto.class)
                .setParameter("descricao", "%" + desc + "%").getResultList();
        JPAUtil.closeEntityManager();
        return produtos;
    }

    public List<Produto> findLeq(double preco) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Produto> produtos = em
                .createQuery("select p from Produto p where (p.preco) <= (:preco)",
                        Produto.class)
                .setParameter("preco",preco).getResultList();
        JPAUtil.closeEntityManager();
        return produtos;
    }

    public List<Produto> findInterval(LocalDate data1, LocalDate data2) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Produto> produtos = em
                .createQuery("select p from Produto p where p.data <= :data2 and p.data >= :data1",
                        Produto.class)
                .setParameter("data1",data1)
                .setParameter("data2", data2).getResultList();
        
        JPAUtil.closeEntityManager();
        return produtos;
    }

}
