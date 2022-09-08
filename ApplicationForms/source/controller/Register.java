package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import dto.Applicants;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Applicants application = new Applicants(request.getParameter("fname"),
									request.getParameter("lname"),
									new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob")),
									Long.valueOf(request.getParameter("contact")),
									request.getParameter("email"), 
									request.getParameter("address"),
									request.getParameter("course"),
									request.getParameter("reference"));
			
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(Applicants.class);
			
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			SessionFactory factory = config.buildSessionFactory(registry);
			
			Session session = factory.openSession();
			
			Transaction transaction = session.beginTransaction();
				
			CriteriaBuilder cb = factory.getCriteriaBuilder();
			
			CriteriaQuery<Applicants> c = cb.createQuery(Applicants.class);
			Root<Applicants> root = c.from(Applicants.class);
			
			c.select(root).where(cb.and(
						cb.equal(root.get("fname"), application.getFname()),
						cb.equal(root.get("lname"), application.getLname()),
						cb.equal(root.get("dob"), application.getDob()),
						cb.equal(root.get("contact"), application.getContact()),
						cb.equal(root.get("email"), application.getEmail()),
						cb.equal(root.get("address"), application.getAddress()),
						cb.equal(root.get("course"), application.getCourse()),
						cb.equal(root.get("reference"), application.getReference())
					));

			Query<Applicants> query = session.createQuery(c);
			if(query.list().isEmpty() || query.list() == null)
			{
				session.persist(application);
				response.getWriter().print("<h1>Successfully applied....<br>Please wait for our response through email.</hr>");
			}
			else
			{
				response.getWriter().print("<h1>Already applied....<br>Please wait for our response through email.</hr>");
			}
			
			transaction.commit();
			session.close();

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
