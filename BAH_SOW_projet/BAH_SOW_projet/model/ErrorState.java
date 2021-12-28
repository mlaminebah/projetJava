package model;
/*  BAH Mamadou Lamine,SOW Papa Laye
	Réponse à la question 4
*/

public class ErrorState implements State {
    private String etat = "ERREUR";

    public String getEtat () {
        return this.etat;
    }

    @Override
    public void handle (ModelTodoList model) {
        System.out.println (this.getEtat()+"-->");
        model.setState(new EditingState());
    }
}
