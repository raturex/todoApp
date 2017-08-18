package com.arolitec.todo.model;

public class TodoItem implements Comparable<TodoItem>{
	private String description;
	private boolean completed=false;
	private Long id;
	
	public TodoItem(){}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem that = (TodoItem) o;

        if(completed != that.completed) return false;
        if(id != null? !id.equals(that.id) : that.id!= null) return false;
        if(description != null? !description.equals(that.description) : that.description != null) return false;

        return true;
    }



    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode(): 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }


    @Override
    public int compareTo(TodoItem otherTask){
        return id.compareTo(otherTask.getId());
    }

    @Override
    public String toString(){
        return id + ": " + description + " [completed: " + completed + "]";
    }
	
	
	
	

}
