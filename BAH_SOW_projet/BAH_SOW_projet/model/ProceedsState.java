package model;
/*  BAH Mamadou Lamine,SOW Papa Laye
	Réponse à la question 4
*/

public class ProceedsState implements State {
    private String etat = "PROCEED";

    public String getEtat () {
        return this.etat;
    }

    @Override
    public void handle (ModelTodoList model) {
        System.out.println (this.getEtat()+"-->");//pour voir les états de l'automate pour chaque action
        model.setState(new EditingState ());
    }
}
