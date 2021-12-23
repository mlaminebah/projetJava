package model;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * Tâche
 */
public class Task  {

	// TODO : Q1.1) et Q2.2) 
	private static Integer num = 0;

	// Elles possèdent une description
	private String description;
	
	// Elles possèdent une priorité
	private Priorities priority;

	public Task(String description, Priorities priority) /* TODO */{
		//this.num = num;
		this.description = description;
		this.priority = priority;
		// TODO
        this.num ++;
	}

	/*
	 * Représentation d'une tâche sous forme de chaine
	 */
	@Override
	public String toString() {
		return description + " (" + priority.getText() + ")";
	}

	/*
	 * Donne la description d'une règle
	 */
	public String getDescription() {
		return description;
	}

    //Question 2 : Compte tenu de l'encapsulation des données nous avons rajouté des getters pour:
    // priority et num
    public Priorities getPriorities () {
        return this.priority;
    }
    public int getNum () {
        return this.num;
    }
	/*@Override
	public int compareTo (Task task) {
		if (this.getPriorities().getValue() < task.getPriorities().getValue()) return 1;
		else if (this.getPriorities().getValue() > task.getPriorities().getValue()) return -1;
		else return 1;
	}
	@Override
	public boolean equals (Object other) {
		if (other instanceof Task) {
			Task task = (Task) other;
			return task.getPriorities().getValue() == this.getPriorities().getValue();
		}
		return false;
	}*/
}
