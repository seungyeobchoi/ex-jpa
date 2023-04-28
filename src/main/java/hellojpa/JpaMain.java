package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        //이 위치에 코드 작성
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            /*
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);
            */

            Member findMember = em.find(Member.class, 1L);
            /*System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());*/

            findMember.setName("HelloJPA");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        emf.close();

    }
}
