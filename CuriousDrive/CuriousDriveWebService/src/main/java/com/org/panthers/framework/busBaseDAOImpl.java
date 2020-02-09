package com.org.panthers.framework;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.JDBCConnectionException;

import com.org.panthers.business.busConstant;
import com.org.panthers.framework.busParameter;
import com.org.panthers.framework.busUtil;

import net.casper.data.model.CDataGridException;
import net.casper.data.model.CDataRowSet;

public class busBaseDAOImpl<E extends Serializable> {

	public void insert(E t) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();

		} catch (JDBCConnectionException jbdcConnectionException)
		{
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException) , busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			busUtil.loadSessionFactory();
			this.insert(t);
		}
		catch (Exception e) {
			e.printStackTrace();
			
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(e) , busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			session.getTransaction().rollback();
		
		} finally {
			
			session.close();
		}
	}

	public void delete(Class<E> e, int id) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		try {
			session.beginTransaction();
			Object object = get(id, e);
			if (object != null) {
				session.delete(object);
			}
			session.getTransaction().commit();
		} catch (JDBCConnectionException jbdcConnectionException)
		{
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException) , busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			busUtil.loadSessionFactory();
			this.delete(e, id);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(ex) , busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			session.getTransaction().rollback();
		
		} finally {
			
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<E> getAll(Class<E> c) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		List<E> t = null;
		try {

			session.beginTransaction();
			t = session.createCriteria(c).list();
			session.getTransaction().commit();

		} catch (JDBCConnectionException jbdcConnectionException)
		{
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException) , busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			busUtil.loadSessionFactory();
			this.getAll(c);
		}
		catch (Exception e) {
			e.printStackTrace();
			
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(e) , busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			session.getTransaction().rollback();
		
		} finally {
			
			session.close();
		}
		return t;
	}

	public void update(E t) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(t);
			session.getTransaction().commit();
		} catch (JDBCConnectionException jbdcConnectionException) {
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			busUtil.loadSessionFactory();
			this.update(t);
		} catch (Exception e) {
			e.printStackTrace();

			new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			session.getTransaction().rollback();

		} finally {

			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public E get(int id, Class<E> c) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		E t = null;
		try {
			session.beginTransaction();
			t = (E) session.get(c, id);
			session.getTransaction().commit();
		} catch (JDBCConnectionException jbdcConnectionException) {
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			busUtil.loadSessionFactory();
			this.get(id, c);
		} catch (Exception e) {
			e.printStackTrace();

			new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			session.getTransaction().rollback();

		} finally {

			session.close();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<E> select(Class<E> c, String astrEntity, List<busParameter> alstParameters) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		List<E> t = null;
		try {
			session.beginTransaction();
			String strQuery = null;
			int lintFlag = 0;

			for (busParameter lbusParameter : alstParameters) {

				String key = lbusParameter.getKey();
				if (lintFlag == 0)
					strQuery = "from " + astrEntity + " where " + key + " = :" + key;
				else
					strQuery = strQuery + " and " + key + " = :" + key;
				lintFlag = 1;
			}

			System.out.println(strQuery);

			Query lQuery = session.createQuery(strQuery);

			for (busParameter lbusParameter : alstParameters) {

				if (lbusParameter.getDataType().equals(busConstant.DataTypeInteger))
					lQuery.setInteger(lbusParameter.getKey(), Integer.parseInt(lbusParameter.getValue()));

				if (lbusParameter.getDataType().equals(busConstant.DataTypeString))
					lQuery.setString(lbusParameter.getKey(), lbusParameter.getValue());
			}

			t = lQuery.list();
			session.getTransaction().commit();
		} catch (JDBCConnectionException jbdcConnectionException) {
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			busUtil.loadSessionFactory();
			this.select(c, astrEntity, alstParameters);
		} catch (Exception e) {
			e.printStackTrace();

			new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return t;
	}

	@SuppressWarnings("unchecked")
	public E selectFirstOrDefault(Class<E> c, String astrEntity, List<busParameter> alstParameters) {

		if (busUtil.iSessionFactory == null)
			busUtil.loadSessionFactory();

		Session session = busUtil.iSessionFactory.openSession();

		List<E> t = null;
		try {
			session.beginTransaction();
			String strQuery = null;
			int lintFlag = 0;

			for (busParameter lbusParameter : alstParameters) {

				String key = lbusParameter.getKey();
				if (lintFlag == 0)
					strQuery = "from " + astrEntity + " where " + key + " = :" + key;
				else
					strQuery = strQuery + " and " + key + " = :" + key;
				lintFlag = 1;
			}

			System.out.println(strQuery);
			Query lQuery = session.createQuery(strQuery);

			for (busParameter lbusParameter : alstParameters) {

				if (lbusParameter.getDataType().equals(busConstant.DataTypeInteger))
					lQuery.setInteger(lbusParameter.getKey(), Integer.parseInt(lbusParameter.getValue()));

				if (lbusParameter.getDataType().equals(busConstant.DataTypeString))
					lQuery.setString(lbusParameter.getKey(), lbusParameter.getValue());
			}

			t = lQuery.list();
			session.getTransaction().commit();

		} catch (JDBCConnectionException jbdcConnectionException) {
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			busUtil.loadSessionFactory();
			this.selectFirstOrDefault(c, astrEntity, alstParameters);
		} catch (Exception e) {
			e.printStackTrace();

			new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());

			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		if (t != null && t.size() > 0)
			return t.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<E> getDataObjectCollectionFromDataSet(CDataRowSet ldataRowSet, Class<E> c){
		
		try {
			
			List<Object> objList = new ArrayList<Object>();
			
			while(ldataRowSet.next()) 
			{
				Object obj = Class.forName(c.getName()).newInstance();	
				
				for(Field field: c.getFields())
				{
					try
					{
						Column lColumn = field.getAnnotation(Column.class);
						
						if(lColumn != null)
						{
							Object objDBValue = null;
							String strInt = "int";
							
							if(field.getType().getName().equals(strInt))
							{
								objDBValue = ldataRowSet.getInt(lColumn.name());
							}
							else if(field.getType().getName().equals("java.lang.String"))
							{
								objDBValue = ldataRowSet.getString(lColumn.name());
							}
							else if(field.getType().getName().equals("java.util.Date"))
							{
								objDBValue = ldataRowSet.getDate(lColumn.name());	
							}
							else if(field.getType().getName().equals("java.util.Byte"))
							{
								objDBValue = ldataRowSet.getByte(lColumn.name());
							}
							else
							{
								System.out.println(field.getType().getName() + " has not been handled in the method. Please make changes in core functions");
							}
							
							field.setAccessible(true);
							field.set(obj, objDBValue);
						}
					}
					catch(CDataGridException ex)
					{
						continue;
					}
					
				}
				objList.add(obj);
			}
			return (List<E>) objList;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
	}
	
}