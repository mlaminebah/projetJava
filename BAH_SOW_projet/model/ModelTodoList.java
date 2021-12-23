package model;

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

	/*
	 * Constructeur du modèle
	 */
	public ModelTodoList() {
		// On initialise la liste des tâches en indiquant
		// - La capacité initiale de 31 (elle augmentera automatiquement si besoin)
		// - La comparaison appliquée entre deux tâches
		tasks = new PriorityQueue<Task>(31, new Comparator<Task>() {
			@Override
			public int compare(Task task1, Task task2) {
                //Question 2) 
                if (task1.getPriorities().getValue() < task2.getPriorities().getValue()) return -1;
				else if (task1.getPriorities().getValue() > task2.getPriorities().getValue()) return 1;
				return 0;
			}
		});
		//tasks = new PriorityQueue<Task>(31);
		priority = Priorities.MEDIUM;
		//Question 3 .
		observers = new ArrayList<>();
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
	private void push(Task task) /* TODO */ {
		
		//System.out.println ("iiicii "+task.getNum());*/
		tasks.add(task);
		// TODO
		//this.notifyAllObservers();
	}
	public void push() /* TODO */ {
		// TODO
		push(new Task(getDescription(), priority));
		System.out.println("Model: push(): " + size());
		/*if (tasks != null) {
			this.numTask = tasks.peek().getNum();
			System.out.println ("ajout");
		}*/
		//Question 3
		this.notifyAllObservers();
	}

	/*
	 * Supprime la tâche la plus prioritaire de la liste de tâches Cette tâche est
	 * la tâche courante
	 */
	@Override
	public void pop() {
		System.out.println("Model: pop(): " + this);
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
}
