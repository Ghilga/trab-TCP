package action;

import domain.EvaluationGroup;

public abstract class ApplicationAction {

	private EvaluationGroup evalGroup;

	private boolean ready;

	public ApplicationAction(EvaluationGroup evalGroup) {

	}

	public void isReady() {

	}

	public abstract void execute();

}
