package model;
/*  BAH Mamadou Lamine,SOW Papa Laye*/
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * Tâche
 */
public class Task implements Comparable <Task> {

	// TODO : Q1.1) et Q2.2) 
	private static int num = 0;
	private int size;
	// Elles possèdent une description
	private String description;
	
	// Elles possèdent une priorité
	private Priorities priority;
	public Task(String description, Priorities priority,int size) throws TaskException {
		//Question 5 :  
		if (priority == null || description.length() == 0)
			throw new TaskException (description,"BAD_DESCRIPTION"); //Question 5 : 
		else if (description.length() < 4) {
			throw new TaskException(description, "TOO_SHORT_DESCRIPTION_TEXT"); //Question 5 : 
		} else if (priority.getValue() < 1) 
			throw new TaskException(description, "TOO_LOW_PRIORITY"); //Question 5 : 
		else if (priority.getValue() > 4)
			throw new TaskException(description, "TOO_HIGH_PRIORITY"); //Question 5 : 
		else {
			this.num ++;//Question 1.1 : Création automatique de num pour chaque tache (variable de classe)
			this.description = description;
			this.priority = priority;
			this.size = size;
		}
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
    public int getPriority () {
        return this.priority.getValue();
    }
    public int getNum () {
        return this.num;
    }
	@Override
	public int compareTo (Task task) {
		if (task == null) return -1;
		int d = this.getPriority() - task.getPriority();
		if (d != 0) return d; 
		return this.size - task.size;
	}
	//Question 5  il est nécessaire de rédifinir les méthodes equals et hasCode pour pouvoir lever l'exception lorsque 
	//deux tâches sont identiques
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Task)) return false;
		Task p = (Task) obj;
		
		return p.getDescription().equals(this.getDescription());
	}
}
