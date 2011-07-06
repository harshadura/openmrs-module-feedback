/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */


package org.openmrs.module.feedback.db.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.SessionFactory;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.feedback.Feedback;
import org.openmrs.module.feedback.PredefinedSubject;
import org.openmrs.module.feedback.Severity;
import org.openmrs.module.feedback.Status;
import org.openmrs.module.feedback.db.FeedbackDAO;

public class HibernateFeedbackDAO implements FeedbackDAO {

	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Hibernate session factory
	 */
	private SessionFactory sessionFactory;
	
	public HibernateFeedbackDAO() { }
	
	/**
	 * Set session factory
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) { 
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @see org.openmrs.api.db.HelloWorldResponseService#getHelloWorldResponse(java.lang.Long)
	 */
        
        public Severity getSeverity(Integer SeverityId) {
		return (Severity) sessionFactory.getCurrentSession().get(Severity.class, SeverityId);
	}
        
        public Status getStatus(Integer StatusId) {
		return (Status) sessionFactory.getCurrentSession().get(Status.class, StatusId);
	}
        
        public PredefinedSubject getPredefinedSubject (Integer PredefinedSubjectId) {
		return (PredefinedSubject) sessionFactory.getCurrentSession().get(PredefinedSubject.class, PredefinedSubjectId);
	}
        
        public Feedback getFeedback (Integer FeedbackId) {
		return (Feedback) sessionFactory.getCurrentSession().get(Feedback.class, FeedbackId);
	}
        
	

        public void saveSeverity(Severity Severity) throws DAOException {
            sessionFactory.getCurrentSession().saveOrUpdate(Severity);
        }
        
        public void saveStatus(Status Status) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(Status);

        }
        public void saveFeedback(Feedback Feedback) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(Feedback);

        } 
        public void savePredefinedSubject (PredefinedSubject PredefinedSubject) throws DAOException {
            
            sessionFactory.getCurrentSession().saveOrUpdate(PredefinedSubject);

        }   

        
         public void updateSeverity(Severity Severity) throws DAOException {
                        sessionFactory.getCurrentSession().delete(Severity);
           
        }
	public void updateStatus(Status Status) throws DAOException {
                        sessionFactory.getCurrentSession().delete(Status);
           
        }
        public void updatePredefinedSubject (PredefinedSubject PredefinedSubject) throws DAOException {
                        sessionFactory.getCurrentSession().delete(PredefinedSubject);
           
        }
        public void updateFeedback (Feedback Feedback) throws DAOException {
                        sessionFactory.getCurrentSession().delete(Feedback);
           
        }
	
	@SuppressWarnings("unchecked")

        public List<Severity> getSeverities() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(Severity.class).list();
	}
        public List<Status> getStatuses() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(Status.class).list();
	}
        public List<PredefinedSubject> getPredefinedSubjects() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(PredefinedSubject.class).list();
	}
        
        public List<Feedback> getFeedbacks() throws DAOException {
		return sessionFactory.getCurrentSession().createCriteria(Feedback.class).list();
	}
        

        public void deletePredefinedSubject (PredefinedSubject PredefinedSubject) throws DAOException {
                        sessionFactory.getCurrentSession().delete(PredefinedSubject);           
        }

        public void deleteStatus (Status Status) throws DAOException {
                        sessionFactory.getCurrentSession().delete(Status);          
        }
        
        public void deleteSeverity (Severity Severity) throws DAOException {
                        sessionFactory.getCurrentSession().delete(Severity);          
        }
        
        public void deleteFeedback (Feedback Feedback) throws DAOException {
                        sessionFactory.getCurrentSession().delete(Feedback);          
        }

   
}
