package model;
/*  BAH Mamadou Lamine,SOW Papa Laye
	Réponse à la question 4
*/

public class EditingState implements State {
    
    private String etat = "EDITERTACHE";

    public String getEtat () {
        return this.etat;
    }

    @Override
    public void handle (ModelTodoList model) {
        System.out.println (this.getEtat()+"-->");//pour voir les états de l'automate pour chaque action
        switch (model.getAction()) {
            case PROCEEDS:model.setState (new ProceedsState());break;
            case ERROR:model.setState(new ErrorState());break;
            case ADDS:model.setState(new EditingState());break;
            default: break;
        }
    }
}
