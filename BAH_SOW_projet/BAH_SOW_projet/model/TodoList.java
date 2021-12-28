package model;
/*  BAH Mamadou Lamine,SOW Papa Laye*/
/*
 * Liste de tâches à faire
 */
public interface TodoList {

	/*
	 * Ajoute la tâche en cours d'édition à la liste des tâches à faire
	 */
	void push() throws TaskException /* Question 5 */;

	/*
	 * Supprime la tâche la plus prioritaire de la liste de tâches.
	 * Cette tâche devient la tâche courante
	 */
	void pop();

	/*
	 * Nombre de tâches à faire
	 */
	int size();

}
