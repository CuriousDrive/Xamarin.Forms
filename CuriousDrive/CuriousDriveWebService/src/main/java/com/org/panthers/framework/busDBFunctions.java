package com.org.panthers.framework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import net.casper.data.model.CDataCacheContainer;
import net.casper.data.model.CDataCacheDBAdapter;
import net.casper.data.model.CDataRowSet;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.jdbc.ReturningWork;

import com.org.panthers.business.busConstant;

public class busDBFunctions {

	public <T> List<T> select(String astrQueryPath, List<busParameter> alstbusParameters, Class<T> actualT) {

		Session lSession = null;

		try {
			String strQuery = new busUtil().getStringFromFile(astrQueryPath);

			if (busUtil.iSessionFactory == null)
				busUtil.loadSessionFactory();

			lSession = busUtil.iSessionFactory.openSession();

			Query lQuery = lSession.createSQLQuery(strQuery);

			if (actualT != null) {
				((SQLQuery) lQuery).addEntity(actualT);
			}

			if (alstbusParameters != null) {
				for (busParameter lbusParameter : alstbusParameters) {

					if (lbusParameter.getDataType().equals(busConstant.DataTypeInteger))
						lQuery.setInteger(lbusParameter.getKey(), Integer.parseInt(lbusParameter.getValue()));

					if (lbusParameter.getDataType().equals(busConstant.DataTypeString))
						lQuery.setString(lbusParameter.getKey(), lbusParameter.getValue());
				}
			}

			@SuppressWarnings("unchecked")
			List<T> lResult = lQuery.list();
			return lResult;

		} catch (Exception ex) {
			new busAppLogger().log("Exception - " + busUtil.getStackTrace(ex), busConstant.SeveritySevere, new Object() {
			}.getClass().getEnclosingMethod().getName());
			return null;
		} finally {

			lSession.close();
		}
	}

	public CDataRowSet DBExecute(final String astrQueryPath, final List<busParameter> alstbusParameters, final String[] primaryKeys, final String astrQueryType) {

		Session lSession = null;
		
		try {

			final String strQuery = new busUtil().getStringFromFile(astrQueryPath);

			if (busUtil.iSessionFactory == null)
				busUtil.loadSessionFactory();

			lSession = busUtil.iSessionFactory.openSession();

			lSession.beginTransaction();
			final CDataRowSet resultSet = lSession.doReturningWork(new ReturningWork<CDataRowSet>() {

				@Override
				public CDataRowSet execute(Connection connection) throws SQLException {
					// TODO Auto-generated method stub
					try {
						PreparedStatement preparedStatement = connection.prepareStatement(strQuery);

						if (alstbusParameters != null && alstbusParameters.size() > 0) {
							int lintIndex = 0;
							for (busParameter lbusParameter : alstbusParameters) {

								lintIndex++;
								if (lbusParameter.getDataType().equals(busConstant.DataTypeInteger))
									preparedStatement.setInt(lintIndex, Integer.parseInt(lbusParameter.getValue()));

								if (lbusParameter.getDataType().equals(busConstant.DataTypeString))
									preparedStatement.setString(lintIndex, lbusParameter.getValue());
							}
						}

						ResultSet resultSet = null;
						
						if (astrQueryType.equals(busConstant.Select))
							resultSet = preparedStatement.executeQuery();
						else if (astrQueryType.equals(busConstant.Update))
							preparedStatement.executeUpdate();
						else if (astrQueryType.equals(busConstant.Delete))
							preparedStatement.execute();	
						
						CDataRowSet lCDataRowset = null;
						CDataCacheContainer container = null;

						if (resultSet != null) {
							container = CDataCacheDBAdapter.loadData(resultSet, null, primaryKeys, new HashMap<Object, Object>());
							lCDataRowset = container.getAll();
							preparedStatement.close();
							resultSet.close();
						}
						return lCDataRowset;

					} catch (JDBCConnectionException jbdcConnectionException) {
						new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException), busConstant.SeveritySevere, new Object() {
						}.getClass().getEnclosingMethod().getName());

						busUtil.loadSessionFactory();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
						}.getClass().getEnclosingMethod().getName());

						return null;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
						}.getClass().getEnclosingMethod().getName());
					}
						return null;
				}
			});
			
			lSession.getTransaction().commit();
			return resultSet;
			
		} catch (Exception ex) {
			
			return null;
		}
		finally
		{
			lSession.close();
		}
	}

	public int DBExecuteScalar(final String astrQueryPath, final List<busParameter> alstbusParameters, final String[] primaryKeys) {

		Session lSession = null;
		
		try {

			final String strQuery = new busUtil().getStringFromFile(astrQueryPath);

			if (busUtil.iSessionFactory == null)
				busUtil.loadSessionFactory();

			lSession = busUtil.iSessionFactory.openSession();

			lSession.beginTransaction();
			final CDataRowSet resultSet = lSession.doReturningWork(new ReturningWork<CDataRowSet>() {

				@Override
				public CDataRowSet execute(Connection connection) throws SQLException {
					// TODO Auto-generated method stub
					try {
						PreparedStatement preparedStatement = connection.prepareStatement(strQuery);

						if (alstbusParameters != null && alstbusParameters.size() > 0) {
							int lintIndex = 0;
							for (busParameter lbusParameter : alstbusParameters) {

								lintIndex++;
								if (lbusParameter.getDataType().equals(busConstant.DataTypeInteger))
									preparedStatement.setInt(lintIndex, Integer.parseInt(lbusParameter.getValue()));

								if (lbusParameter.getDataType().equals(busConstant.DataTypeString))
									preparedStatement.setString(lintIndex, lbusParameter.getValue());
							}
						}

						ResultSet resultSet = null;
						resultSet = preparedStatement.executeQuery();
						
						CDataRowSet lCDataRowset = null;
						CDataCacheContainer container = null;

						if (resultSet != null) {
							container = CDataCacheDBAdapter.loadData(resultSet, null, primaryKeys, new HashMap<Object, Object>());
							lCDataRowset = container.getAll();
							preparedStatement.close();
							resultSet.close();
						}
						return lCDataRowset;

					} catch (JDBCConnectionException jbdcConnectionException) {
						new busAppLogger().log("Exception - " + busUtil.getStackTrace(jbdcConnectionException), busConstant.SeveritySevere, new Object() {
						}.getClass().getEnclosingMethod().getName());

						busUtil.loadSessionFactory();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
						}.getClass().getEnclosingMethod().getName());

						return null;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						new busAppLogger().log("Exception - " + busUtil.getStackTrace(e), busConstant.SeveritySevere, new Object() {
						}.getClass().getEnclosingMethod().getName());
					}
						return null;
				}
			});
			
			lSession.getTransaction().commit();
			return resultSet.getAllRows().length;
			
		} catch (Exception ex) {
			
			return 0;
		}
		finally
		{
			lSession.close();
		}
	}

	
}
