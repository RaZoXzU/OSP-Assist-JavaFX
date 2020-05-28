package osp.DB.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import osp.Models.Member;

import javax.persistence.*;
import java.util.List;

public class MemberDAO {

    public static Member selectMemberById(Integer idMember){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

            Member member = new Member();
            List<Member> listMember = entityManager.createQuery("FROM Members WHERE id=" + idMember).getResultList();
            for (int i = 0; i < listMember.size(); i++) {
                member = listMember.get(i);
            }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return member;
    }

    public static ObservableList<Member> getMembersList(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Member> listMember = entityManager.createQuery("FROM Members").getResultList();
        ObservableList<Member> memberObservableList = FXCollections.observableList(listMember);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return memberObservableList;
    }

    public static void insertMember(Member member){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(member);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}