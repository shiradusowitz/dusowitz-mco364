package dusowitz.mco364.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ToDoService {

	@GET("/todos")
	Call<List<Todo>> listTodos();
}