package upmc.train.model;

import java.util.ArrayList;

public class PartRoad
{
	protected ArrayList<Canton> cantons = new ArrayList<Canton>() ;
	protected int actuel = 0 ;
	
	
	
	public void addCanton(Canton canton)
	{
		this.cantons.add(canton);
		if (this.cantons.size() == 1)
			this.actuel = 0 ;
	}
	
	public void setCantonActuel(Canton c)
	{
		if (this.cantons.contains(c))
		{
			this.actuel = this.cantons.indexOf(c) ;
			
		}
	}
	
	
	protected int getNumeroCantonSuivant()
	{
		int canton;
		if (this.actuel == this.cantons.size() - 1)
			canton = 0 ;
		else 
			canton = this.actuel + 1 ;
		return canton ;
	}
	public Canton getNextCanton()
	{
		return this.cantons.get(actuel) ;
	}

	public Canton getCantonActuel() {
		return this.cantons.get(this.actuel) ;
	}

	
	public Canton gotoNextCanton()
	{
		Canton c = this.cantons.get(this.actuel) ;
		this.actuel = this.getNumeroCantonSuivant() ;
		return c ;
	}	
	
	public boolean isFinish()
	{
		
		return true ;
	}
}
