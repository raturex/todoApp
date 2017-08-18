package com.arolitec.todo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arolitec.todo.model.TodoItem;

public class H2TaskRepository implements TodoRepository{
	@Override
	public TodoItem findById(Long id) {
		TodoItem todoItem=null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = createConnection();
            stmt = conn.prepareStatement("SELECT id, name, completed from TODOITEM where id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            

            if(rs.first()) {
                todoItem = new TodoItem();
                todoItem.setId(rs.getLong("id"));
                todoItem.setDescription(rs.getString("name"));
                todoItem.setCompleted(rs.getBoolean("completed"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
            closeResultSet(rs);
        }

        return todoItem;
	}

	@Override
	public List<TodoItem> findAll() {
		List<TodoItem> TodoItems = new ArrayList<TodoItem>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = createConnection();
            stmt = conn.prepareStatement("SELECT id, name, completed from TODOITEM");
            rs = stmt.executeQuery();

            while(rs.next()) {
                TodoItem TodoItem = new TodoItem();
                TodoItem.setId(rs.getLong("id"));
                TodoItem.setDescription(rs.getString("name"));
                TodoItem.setCompleted(rs.getBoolean("completed"));
                TodoItems.add(TodoItem);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
            closeResultSet(rs);
        }

        return TodoItems;
	}

	@Override
	public List<TodoItem> findAllCompleted() {
		List<TodoItem> completedTodoItems = new ArrayList<TodoItem>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = createConnection();
            stmt = conn.prepareStatement("SELECT id, name, completed from TODOITEM where completed = 1");
            rs = stmt.executeQuery();

            while(rs.next()) {
                TodoItem TodoItem = new TodoItem();
                TodoItem.setId(rs.getLong("id"));
                TodoItem.setDescription(rs.getString("name"));
                TodoItem.setCompleted(rs.getBoolean("completed"));
                completedTodoItems.add(TodoItem);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
            closeResultSet(rs);
        }

        return completedTodoItems;
	}

	@Override
	public List<TodoItem> findAllActive() {
		List<TodoItem> activeTodoItems = new ArrayList<TodoItem>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = createConnection();
            stmt = conn.prepareStatement("SELECT id, name, completed from TODOITEM where completed = 0");
            rs = stmt.executeQuery();

            while(rs.next()) {
                TodoItem TodoItem = new TodoItem();
                TodoItem.setId(rs.getLong("id"));
                TodoItem.setDescription(rs.getString("name"));
                TodoItem.setCompleted(rs.getBoolean("completed"));
                activeTodoItems.add(TodoItem);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn);
            closeStatement(stmt);
            closeResultSet(rs);
        }

        return activeTodoItems;
	}

	@Override
	public Long insert(TodoItem todo) {
		 Connection conn = null;
	     PreparedStatement stmt = null;
	     ResultSet rs = null;
	     Long newId = null;

	     try {
	          conn = createConnection();
	          stmt = conn.prepareStatement("INSERT INTO TODOITEM(name, completed) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
	          stmt.setString(1, todo.getDescription());
	          stmt.setBoolean(2, todo.isCompleted());
	          stmt.executeUpdate();

	          rs = stmt.getGeneratedKeys();

	          if(rs.next()) {
	               newId = rs.getLong(1);
	          }
	     }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	        finally {
	            closeConnection(conn);
	            closeStatement(stmt);
	            closeResultSet(rs);
	        }

	        return newId;
	}

	@Override
	public void update(TodoItem todo) {
		Connection conn = null;
	     PreparedStatement stmt = null;
	     ResultSet rs = null;

	     try {
	          conn = createConnection();
	          stmt = conn.prepareStatement("UPDATE TODOITEM SET name = ?, completed = ? WHERE id = ?");
	          stmt.setString(1, todo.getDescription());
	          stmt.setBoolean(2, todo.isCompleted());
	          stmt.setLong(3, todo.getId());
	          stmt.executeUpdate();
	          
	     }catch(Exception e) {
	            e.printStackTrace();
	     }finally {
	            closeConnection(conn);
	            closeStatement(stmt);
	            closeResultSet(rs);
	     }

	}

	@Override
	public void delete(TodoItem todo) {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	     try {
	          conn = createConnection();
	          stmt = conn.prepareStatement("DELETE FROM TODOITEM WHERE id = ?");
	          stmt.setLong(1, todo.getId());
	          stmt.executeUpdate();
	          
	     }catch(Exception e) {
	            e.printStackTrace();
	     }finally {
	            closeConnection(conn);
	            closeStatement(stmt);
	            closeResultSet(rs);
	     }
		
	}
	
	public void deleteAll(){
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	     try {
	          conn = createConnection();
	          stmt = conn.prepareStatement("DELETE FROM TODOITEM");
	          stmt.executeUpdate();
	          
	     }catch(Exception e) {
	            e.printStackTrace();
	     }finally {
	            closeConnection(conn);
	            closeStatement(stmt);
	            closeResultSet(rs);
	     }
	}
	
	 private Connection createConnection() throws ClassNotFoundException, SQLException {
	        Class.forName("org.h2.Driver");
	        return DriverManager.getConnection("jdbc:h2:tcp://127.0.1.1:8082/~/todo", "sa", "");
	 }

	    private void closeConnection(Connection connection) {
	        if(connection != null) {
	            try {
	                connection.close();
	            }
	            catch(SQLException e) {}
	        }
	    }

	    private void closeStatement(Statement statement) {
	        if(statement != null) {
	            try {
	                statement.close();
	            }
	            catch(SQLException e) {}
	        }
	    }

	    private void closeResultSet(ResultSet resultSet) {
	        if(resultSet != null) {
	            try {
	                resultSet.close();
	            }
	            catch(SQLException e) {}
	        }
	    }

}
