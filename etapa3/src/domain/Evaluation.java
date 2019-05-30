package domain;

public class Evaluation {
	
	private int score = 0;
	private boolean done;
	
	public boolean isDone()
	{
		return done;
	}
	
	public void setScore(int sc)
	{
		score = sc;
		done = true;
	}

	public int getScore()
	{
		return score;
	}
	
	public Evaluation()
	{
		
	}
	
	public Evaluation(EvaluationGroup group, Product product, User reviewer)
	{
		
	}
}
