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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sdu.androidlab.isurvey.Data.Data;
import sdu.androidlab.isurvey.Database.annotation.Column;
import sdu.androidlab.isurvey.Database.annotation.Table;

/**
 * @author zhenzxie
 */
public class SqlHelper {
	
	public static final String TAG = "SqlHelper";
	static ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	public boolean insert(Data data) {
	
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
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(connection, statement);
		}
	}

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
	
	public boolean updata(Data oldData, Data newData) {
	
		if (oldData == null || newData == null) {
			System.out.println(TAG + " Invalid paramaters");
			return false;
		}
		
		Class<? extends Data> cl = oldData.getClass();
		Field[] fields = cl.getDeclaredFields();
		Table annotation = oldData.getClass().getAnnotation(Table.class);
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
			setValues(fields, newData, statement, 1);
			setValuesNotNull(fields, oldData, statement, index);
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(connection, statement);
		}

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
					callback.onUpdataComplete();
				} catch (SQLException e) {
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement);
				}
			}

		};
		execute(runnable);
	}
	
	public boolean delete(Data data) {
	
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
		
		builder = new StringBuilder("delete from ");
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
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(connection, statement);
		}

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
					callback.onDeleteComplete();
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
				resultSet.next();
				int count = resultSet.getInt(1);
				if (count >= 1)
					return true;
				else
					return false;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionManager.close(connection, statement, resultSet);
		}
	}
	
	public void query(final Class<? extends Data> cl, final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				if (cl == null || callback == null) {
					System.out.println(TAG + " Invalid paramaters");
					return;
				}
				
				Table annotation = cl.getAnnotation(Table.class);
				String table = annotation.name();
				
				StringBuilder builder = null;
				String sql = null;
				Connection connection = ConnectionManager.getConnection();
				Statement statement = null;
				ResultSet resultSet = null;
				
				builder = new StringBuilder("select * from ");
				builder.append(table);
				builder.append(" ;");
				sql = builder.toString();
				System.out.println(TAG + "  " + sql);

				try {
					statement = connection.createStatement();
					boolean temp = statement.execute(sql);
					List<Data> dataList = new ArrayList<Data>();
					Data data = null;
					if (temp) {
						resultSet = statement.getResultSet();
						if (resultSet.first()) {
							do {
								try {
									data = cl.newInstance();
									if (data.fillData(resultSet)) {
										dataList.add(data);
									}
								} catch (InstantiationException
										| IllegalAccessException e) {
									e.printStackTrace();
									callback.onError(new SqlError(e));
								}
							} while (resultSet.next());
						}
					}
					callback.onQueryComplete(dataList);
				} catch (SQLException e) {
					e.printStackTrace();
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement, resultSet);
				}
			}
		};
		execute(runnable);
	}

	public void query(final Data data, final Field[] fis,
			final SqlCallback callback) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				if (data == null || fis == null || callback == null) {
					System.out.println(TAG + " Invalid paramaters");
					return;
				}
				
				Class<? extends Data> cl = data.getClass();
				Field[] fields = fis;
				Table annotation = data.getClass().getAnnotation(Table.class);
				String table = annotation.name();
				
				StringBuilder builder = null;
				String sql = null;
				Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = null;
				ResultSet resultSet = null;
				
				builder = new StringBuilder("select * from ");
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
					boolean temp = statement.execute();
					List<Data> dataList = new ArrayList<Data>();
					Data data = null;
					if (temp) {
						resultSet = statement.getResultSet();
						if (resultSet.first()) {
							do {
								try {
									data = cl.newInstance();
									if (data.fillData(resultSet)) {
										dataList.add(data);
									}
								} catch (InstantiationException
										| IllegalAccessException e) {
									e.printStackTrace();
									callback.onError(new SqlError(e));
								}
							} while (resultSet.next());
						}
					}
					callback.onQueryComplete(dataList);
				} catch (SQLException e) {
					e.printStackTrace();
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement, resultSet);
				}
			}
		};
		execute(runnable);
	}

	@Deprecated
	public void query(final Data data, final SqlCallback callback) {
	
		Class<? extends Data> cl = data.getClass();
		Field[] fields = cl.getDeclaredFields();
		query(data, fields, callback);
	}
	
	/**
	 * multi table query
	 * 
	 * @param sql
	 *            为 select 语句
	 * @param callback
	 *            回调接口
	 * @param keys
	 *            长度和顺序和sql中的投影的列一致
	 * 
	 */
	public void queryMultiTableComplete(final String sql,
			final SqlCallback callback, final String[] keys) {
	
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
			
				if (sql == null || callback == null || keys == null) {
					System.out.println(TAG + " Invalid paramaters");
					return;
				}
				
				Connection connection = ConnectionManager.getConnection();
				Statement statement = null;
				ResultSet resultSet = null;
				List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
				HashMap<String, Object> map = null;
				
				try {
					statement = connection.createStatement();
					boolean temp = statement.execute(sql);
					if (temp) {
						resultSet = statement.getResultSet();
						if (resultSet.first()) {
							do {
								map = new HashMap<String, Object>();
								int i = 1;
								for (String key : keys) {
									map.put(key, resultSet.getObject(i++));
								}
							} while (resultSet.next());
						}
					}
					callback.onQueryMultiTableComplete(list);
				} catch (SQLException e) {
					e.printStackTrace();
					callback.onError(new SqlError(e));
				} finally {
					ConnectionManager.close(connection, statement, resultSet);
				}
			}
		};
		execute(runnable);
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
	
	private void setValuesNotNull(Field[] fields, Data data,
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