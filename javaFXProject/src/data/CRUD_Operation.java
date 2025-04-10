package data;

import java.util.ArrayList;

public interface CRUD_Operation<S, T> {

	// C: Create
	void save(S entity);

	// R: Read
	ArrayList<S> fetch();

	// U: Update
	void update(S entity);

	// D: Delete
	void delete(T id);
	
	//Auntenticador
	boolean authenticate(T id);
	
	// S: SoftDelete
	void softDelete(T id);

}