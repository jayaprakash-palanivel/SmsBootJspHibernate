package com.techymeet.sms.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techymeet.sms.vo.StudentVo;


@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	
	
	@Override
	public int saveOrUpdate(StudentVo studentVo) {
		Session session = getSession();
		session.saveOrUpdate(studentVo);
		
		if (0 < studentVo.getStudentId()) {
			return studentVo.getStudentId();
		}
		return 0;
	}

	@Override
	public StudentVo findById(int studentId) {
		

		Session session=getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<StudentVo> criteriaQuery = criteriaBuilder.createQuery(StudentVo.class);
		Root<StudentVo> studentRoot = criteriaQuery.from(StudentVo.class);
		criteriaQuery.select(studentRoot);
		criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("studentId"), studentId));
		
		//or
	//	Predicate predicate=criteriaBuilder.equal(studentRoot.get("studentId"), studentId);
	//	criteriaQuery.where(predicate);
		
		StudentVo StudentVo = session.createQuery(criteriaQuery).getSingleResult();
		if(null!=StudentVo) {
			return StudentVo;
			
		}
		
		return null;
	}

	@Override
	public List<StudentVo> findAll() {
		Session session=getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<StudentVo> criteriaQuery = criteriaBuilder.createQuery(StudentVo.class);
		Root<StudentVo> studentRoot = criteriaQuery.from(StudentVo.class);
		criteriaQuery.select(studentRoot);
		Predicate predicate=criteriaBuilder.equal(studentRoot.get("isDelete"), false);
		criteriaQuery.where(predicate);
		List<StudentVo> studentList = session.createQuery(criteriaQuery).getResultList();
		if(null!=studentList&& 0<studentList.size()) {
			return studentList;
			
		}
		
		return null;
	}

	@Override
	public boolean delete(int studentId) {
		Session session=getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaUpdate<StudentVo> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(StudentVo.class);
		Root<StudentVo> studentRoot = criteriaUpdate.from(StudentVo.class);
		criteriaUpdate.set(studentRoot.get("isDelete"), true).where(criteriaBuilder.equal(studentRoot.get("studentId"),studentId ));
		int id=session.createQuery(criteriaUpdate).executeUpdate();
		if(0<id) {
			return true;
		}
		return false;
	}

	@Override
	public StudentVo findByStudentEmail(String email) {
		Session session=getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<StudentVo> criteriaQuery = criteriaBuilder.createQuery(StudentVo.class);
		Root<StudentVo> studentRoot = criteriaQuery.from(StudentVo.class);
		criteriaQuery.select(studentRoot);
		criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("studentEmail"), email));
		StudentVo StudentVo = session.createQuery(criteriaQuery).getSingleResult();
		if(null!=StudentVo) {
			return StudentVo;
			
		}
		return null;
	}

	@Override
	public StudentVo findByMobileNumber(long mobile) {
		Session session=getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<StudentVo> criteriaQuery = criteriaBuilder.createQuery(StudentVo.class);
		Root<StudentVo> studentRoot = criteriaQuery.from(StudentVo.class);
		criteriaQuery.select(studentRoot);
		criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("mobileNumber"), mobile));
		StudentVo StudentVo = session.createQuery(criteriaQuery).getSingleResult();
		if(null!=StudentVo) {
			return StudentVo;			
		}
		
		return null;
	}

	@Override
	public StudentVo findByStudentName(String name) {
		Session session=getSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<StudentVo> criteriaQuery = criteriaBuilder.createQuery(StudentVo.class);
		Root<StudentVo> studentRoot = criteriaQuery.from(StudentVo.class);
		criteriaQuery.select(studentRoot);
		criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("studentName"), name));
		StudentVo StudentVo = session.createQuery(criteriaQuery).getSingleResult();
		if(null!=StudentVo) {
			return StudentVo;
			
		}
		
		return null;
	}

	

}
