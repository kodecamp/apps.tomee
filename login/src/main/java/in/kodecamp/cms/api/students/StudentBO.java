package in.kodecamp.cms.api.students;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import in.kodecamp.models.StudentEntity;

/**
 * StudentBO
 */
@Stateless
public class StudentBO {

  @PersistenceContext
  private EntityManager em;

  public StudentBO() {
    System.out.println("StudentBO : Constructor");
  }

  @PostConstruct
  public void init() {
    System.out.println("Hello");
    System.out.println("StudentBO : PostConstruct -> em : " + em);
  }

  public List<StudentEntity> getAll() {
    return em.createNamedQuery("StudentEntity.findAll", StudentEntity.class).getResultList();
  }

  public List<StudentEntity> getAllActive() {
    return em.createNamedQuery("StudentEntity.findAllActive", StudentEntity.class).getResultList();
  }

  public StudentEntity getBy(final long id) {

    return em.createNamedQuery("StudentEntity.findById", StudentEntity.class).setParameter("id", id).getSingleResult();
  }

  public StudentEntity createNew(final StudentEntity newStudent) {
    em.persist(newStudent);
    return newStudent;
  }

  public StudentEntity update(final StudentEntity newStudent) {
    StudentEntity updatedEntity = em.merge(newStudent);
    return updatedEntity;
  }

  public StudentEntity deleteBy(final long id) {
    StudentEntity se = this.getBy(id);
    se.setActive(false);
    StudentEntity inActivedEntity = em.merge(se);
    return inActivedEntity;
  }
}
