package controller;

import model.Action;
import model.Code;
import model.ModelTodoList;
import model.Priorities;
import model.TaskException;
import view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonEventHandler implements EventHandler<ActionEvent> {

	private ModelTodoList model;
	private View view;
	
	public ButtonEventHandler(ModelTodoList model) {
		this.model = model;
	}

	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		/*
		 * On récupère l'objet qui a émis cet événement actionEvent Il s'agit d'un
		 * bouton identifié grâce à getId(). Selon cet identifiant, on modifie le modèle
		 * en conséquence.
		 * 
		 * Si rien ne matche, on affiche l'identifiant du bouton non prévu.
		 * 
		 */
		Button button = (Button) actionEvent.getSource();
		switch (button.getId()) {

		// Bouton "Traiter une tâche..."
		case "proceeds_btn":
			model.pop();
			model.setAction(Action.PROCEEDS);//Question 4: Etat traitement puis retour à l'état initial
			view.update(model);
			view.showModalWindow("Tâche à réaliser", model.getCurrentTask().getDescription(), "Tâche terminée");
			break;

		// Bouton "Ajouter la tâche..."
		case "adds_btn":
			model.setAction(Action.ADDS); //Question 4 :  aller vers l'état erreur
			if (model.getDescription() == null)
				view.showModalWindow("ERROR", Code.NOT_DEFINED.toString(), "OK");
			else if (model.getPriority() == null) 
				view.showModalWindow("ERROR", Code.NOT_DEFINED.toString(), "OK");
			else if (model.getPriority().getValue() < Priorities.HIGH.getValue())
				view.showModalWindow("ERROR", Code.BAD_PRIORITY.toString(), "OK");
			else if (model.getDescription().length() < 4)
				view.showModalWindow("ERROR", Code.TOO_SHORT_DESCRIPTION_TEXT.toString(), "OK");
			else  {
				try {
					model.push();
				} catch (TaskException e) {
					model.setAction (Action.ERROR);
					System.out.println (e.error());
				}
			}
				
			// On met à jour la vue
			view.update(model);
			break;

		// Bouton "Tâche réalisée"
		case "dialog_btn":
			
			view.hideModalWindow();
			break;

		// Bouton inconnu
		default:
			model.setAction (Action.ERROR); //Question 4 : aller dans l'état erreur puis revenir automatiquement vers l'état initial
			System.err.println("button.getId(): " + button.getId());
		}
	}

}
