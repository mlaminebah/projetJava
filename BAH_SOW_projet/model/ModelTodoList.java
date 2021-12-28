package model;

/*  BAH Mamadou Lamine,SOW Papa Laye*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import view.Observer;

//Question 3
public class ModelTodoList implements TodoList,Observable/* TODO */ {

	// Liste de priorité de tâches
	private PriorityQueue<Task> tasks;

	// Description de la tâche en cours d'édition
	private String description;

	// Priorité de la tâche en cours d'édition
	private Priorities priority;

	// La tâche actuellement réalisée (null si aucune)
	private Task currentTask;

	//Question 3
	private List<Observer> observers;

	// TODO
	private int numTask;

	//Question 4:
	private State state;
	private Action action;


	/*
	 * Constructeur du modèle
	 */
	public ModelTodoList() {
		// On initialise la liste des tâches en indiquant
		// - La capacité initiale de 31 (elle augmentera automatiquement si besoin)
		// - La comparaison appliquée entre deux tâches
		tasks = new PriorityQueue<Task>(31);
		//tasks = new PriorityQueue<Task>(31);
		priority = Priorities.MEDIUM;
		//Question 3 .
		observers = new ArrayList<>();
		//Question 4
		this.state = new EditingState ();
	}

	/*
	 * Donne la taille de la liste des tâches à faire
	 */
	public int size() {
		return tasks.size();
	}

	/*
	 * Modifie la description de la tâche en cours d'édition
	 */
	public void setDescription(String description) {
		this.description = description;
		System.out.println("Model: description: " + this.getDescription());
	}

	/*
	 * Modifie la priorité de la tâche en cours d'édition
	 */
	public void setPriority(Priorities priority) {
		this.priority = priority;
		System.out.println("Model: priority: " + this.priority);
	}

	/*
	 * Ajoute la tâche en cours d'édition à la liste des tâches à faire
	 */
	private void push(Task task) throws TaskException /* TODO */ {
		
		tasks.add(task);
		// TODO
		//Question 3
		this.notifyAllObservers();
	}
	public void push() throws TaskException /* TODO */ {
		// Question 5
		Task t = new Task(getDescription(), priority,this.size()); 
		if (tasks.contains(t)) throw new TaskException(description, "ALREADY_EXIST");
		else
			push (t);
		System.out.println("Model: push(): " + size());
	}

	/*
	 * Supprime la tâche la plus prioritaire de la liste de tâches Cette tâche est
	 * la tâche courante
	 */
	@Override
	public void pop() {
		System.out.println("Model: pop(): " + tasks.peek().getDescription());
		currentTask = tasks.poll();
		this.notifyAllObservers();
	}

	/*
	 * Récupère la liste des tâches
	 */
	// TODO Q3.3) 
	public PriorityQueue<Task> getTasks() {
        PriorityQueue<Task> taches = tasks;
		return taches;
	}

	/*
	 * Donne la priorité de la tâche en cours d'édition
	 */
	public Priorities getPriority() {
		return priority;
	}

	/*
	 * Donne la tâche actuellement réalisée
	 */
	public Task getCurrentTask() {
		return currentTask;
	}

	/*
	 * Fournit la tâche actuellement réalisée
	 */
	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}

	/*
	 * Donne la description de la tâche en cours d'édition
	 */
	public String getDescription() {
		return description;
	}
	//Pour la question 3
	@Override
	public void notifyAllObservers () {
		for (Observer obs: observers) {
			obs.update(this);
		}
	}
	@Override
    public void addObserver (Observer p) {
		observers.add(p);
	}

	//Question 4 :
	public Action getAction () {
		return this.action;
	}
	public State getState () {
		return this.state;
	}
	public void setState (State state) {
		this.state = state;
	}
	public void setAction (Action action) {
		if (action != null) {
			this.action = action;
			this.state.handle(this);
			this.notifyAllObservers();
		}
	}
}
