/*
 * Util sdu.androidlab.isurvey.Database SqlHelper.java
 * 2012 2012-7-22 下午4:03:40
 * @author zhenzxie
 */
package sdu.androidlab.isurvey.Database;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * @author zhenzxie
 * 
 */
public class SqlHelper {
	
	public static final String TAG = "SqlHelper";
	static ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	public void insert(final Data data, final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				if (data == null || callback == null) {
					System.out.println(TAG + " Invalid paramaters");
					return;
				}
				
				Class<? extends Data> cl = data.getClass();
				Field[] fields = cl.getDeclaredFields();
				Table annotation = data.getClass().getAnnotation(Table.class);
				String table = annotation.name();
				
				StringBuilder builder = null;
				String sql = null;
				Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = null;
				
				builder = new StringBuilder("insert into ");
				builder.append(table);
				builder.append(" ( ");
				for (Field field : fields) {
					if (field.isAnnotationPresent(Column.class)) {
						Column column = field.getAnnotation(Column.class);
						builder.append(column.name());
						builder.append(",");
					}
				}
				builder.deleteCharAt(builder.length() - 1);
				builder.append(" ) ");
				builder.append("values( ");
				for (Field field : fields) {
					if (field.isAnnotationPresent(Column.class)) {
						builder.append("?,");
					}
				}
				builder.deleteCharAt(builder.length() - 1);
				builder.append(" );");
				sql = builder.toString();
				System.out.println(TAG + "  " + sql);
				try {
					statement = connection.prepareStatement(sql);
					setValues(fields, data, statement, 1);
					statement.execute();
					callback.onInsertComplete();
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement);
				}
			}
		};
		execute(runnable);
	}
	
	public void update(final Data oldData, final Data newData,
			final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				if (oldData == null || newData == null || callback == null) {
					System.out.println(TAG + " Invalid paramaters");
					return;
				}
				
				Class<? extends Data> cl = oldData.getClass();
				Field[] fields = cl.getDeclaredFields();
				Table annotation = oldData.getClass()
						.getAnnotation(Table.class);
				String table = annotation.name();
				
				StringBuilder builder = null;
				String sql = null;
				Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = null;
				int index = 0;
				builder = new StringBuilder("updata ");
				builder.append(table);
				builder.append(" set ");
				for (Field field : fields) {
					if (field.isAnnotationPresent(Column.class)) {
						Column column = field.getAnnotation(Column.class);
						builder.append(column.name());
						builder.append("=?,");
						index++;
					}
				}
				builder.deleteCharAt(builder.length() - 1);
				builder.append(" where ");
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.isAnnotationPresent(Column.class)) {
						Object obj = null;
						try {
							obj = field.get(oldData);
						} catch (IllegalArgumentException
								| IllegalAccessException e) {
							e.printStackTrace();
						}
						if (obj != null) {
							Column column = field.getAnnotation(Column.class);
							builder.append(column.name());
							builder.append("= ? and ");
						}
					}
				}
				builder.delete(builder.length() - 4, builder.length() - 1);
				builder.append(" ;");
				sql = builder.toString();
				System.out.println(TAG + "  " + sql);
				try {
					statement = connection.prepareStatement(sql);
					setValues(fields, newData, statement, 1);
					setValuesNotNull(fields, oldData, statement, index);
					statement.execute();
					callback.onInsertComplete();
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement);
				}
			}

		};
		execute(runnable);
	}
	
	public void delete(final Data data, final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				if (data == null || callback == null) {
					System.out.println(TAG + " Invalid paramaters");
					return;
				}
				
				Class<? extends Data> cl = data.getClass();
				Field[] fields = cl.getDeclaredFields();
				Table annotation = data.getClass().getAnnotation(Table.class);
				String table = annotation.name();
				
				StringBuilder builder = null;
				String sql = null;
				Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = null;
				
				builder = new StringBuilder("delete from ");
				builder.append(table);
				builder.append(" where ");
				for (Field field : fields) {
					if (field.isAnnotationPresent(Column.class)) {
						
						Object obj = null;
						try {
							obj = field.get(data);
						} catch (IllegalArgumentException
								| IllegalAccessException e) {
							e.printStackTrace();
						}
						if (obj != null) {
							Column column = field.getAnnotation(Column.class);
							builder.append(column.name());
							builder.append("= ? and ");
						}
					}
				}
				builder.delete(builder.length() - 4, builder.length() - 1);
				builder.append(" ;");

				sql = builder.toString();
				System.out.println(TAG + "  " + sql);
				try {
					statement = connection.prepareStatement(sql);
					setValuesNotNull(fields, data, statement, 1);
					statement.execute();
					callback.onInsertComplete();
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement);
				}
			}
		};
		execute(runnable);
	}
	
	public boolean isExist(Data data) {
	
		if (data == null) {
			System.out.println(TAG + " Invalid paramaters");
			return false;
		}
		
		Class<? extends Data> cl = data.getClass();
		Field[] fields = cl.getDeclaredFields();
		Table annotation = data.getClass().getAnnotation(Table.class);
		String table = annotation.name();
		
		StringBuilder builder = null;
		String sql = null;
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		builder = new StringBuilder("select count(*) from ");
		builder.append(table);
		builder.append(" where ");
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				
				Object obj = null;
				try {
					obj = field.get(data);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				if (obj != null) {
					Column column = field.getAnnotation(Column.class);
					builder.append(column.name());
					builder.append("= ? and ");
				}
			}
		}
		builder.delete(builder.length() - 4, builder.length() - 1);
		builder.append(" ;");
		sql = builder.toString();
		System.out.println(TAG + "  " + sql);
		try {
			statement = connection.prepareStatement(sql);
			setValuesNotNull(fields, data, statement, 1);
			boolean temp = statement.execute();
			if (temp) {
				resultSet = statement.getResultSet();
				int count = resultSet.getInt(1);
				if (count >= 1)
					return true;
				else
					return false;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			ConnectionManager.close(connection, statement, resultSet);
		}
	}

	public void execute(final String sql, final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				Connection connection = ConnectionManager.getConnection();
				Statement statement = null;
				ResultSet resultSet = null;
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					resultSet = statement.getResultSet();
					callback.onSqlExecuteComplete(resultSet);
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement, resultSet);
				}
			}
		};
		
		execute(runnable);
	}
	
	private void execute(Runnable runnable) {
	
		executorService.execute(runnable);
	}
	
	private void setValues(Field[] fields, Data data,
			PreparedStatement statement, int i) {
	
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				try {
					field.setAccessible(true);
					Class<?> fieldType = field.getType();
					if ((Integer.TYPE == fieldType)
							|| (Integer.class == fieldType)) {
						statement.setInt(i, field.getInt(data));
					} else if (String.class == fieldType) {
						statement.setString(i, field.get(data).toString());
					} else if ((Long.TYPE == fieldType)
							|| (Long.class == fieldType)) {
						statement.setLong(i, field.getLong(data));
					} else if ((Float.TYPE == fieldType)
							|| (Float.class == fieldType)) {
						statement.setFloat(i, field.getFloat(data));
					} else if ((Short.TYPE == fieldType)
							|| (Short.class == fieldType)) {
						statement.setShort(i, field.getShort(data));
					} else if ((Double.TYPE == fieldType)
							|| (Double.class == fieldType)) {
						statement.setDouble(i, field.getDouble(data));
					} else if (Date.class == fieldType) {
						statement.setDate(i, (Date) field.get(data));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}
		}
	}
	
	public void setValuesNotNull(Field[] fields, Data data,
			PreparedStatement statement, int i) {
	
		for (Field field : fields) {
			if (field.isAnnotationPresent(Column.class)) {
				try {
					field.setAccessible(true);
					Object obj = null;
					try {
						obj = field.get(data);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					if (obj != null) {
						Class<?> fieldType = field.getType();
						if ((Integer.TYPE == fieldType)
								|| (Integer.class == fieldType)) {
							statement.setInt(i, field.getInt(data));
						} else if (String.class == fieldType) {
							statement.setString(i, field.get(data).toString());
						} else if ((Long.TYPE == fieldType)
								|| (Long.class == fieldType)) {
							statement.setLong(i, field.getLong(data));
						} else if ((Float.TYPE == fieldType)
								|| (Float.class == fieldType)) {
							statement.setFloat(i, field.getFloat(data));
						} else if ((Short.TYPE == fieldType)
								|| (Short.class == fieldType)) {
							statement.setShort(i, field.getShort(data));
						} else if ((Double.TYPE == fieldType)
								|| (Double.class == fieldType)) {
							statement.setDouble(i, field.getDouble(data));
						} else if (Date.class == fieldType) {
							statement.setDate(i, (Date) field.get(data));
						}
						i++;
					}
				} catch (Exception e) {
					i++;
					e.printStackTrace();
				}
			}
		}
	}
}