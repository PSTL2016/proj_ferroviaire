package upmc.train.model;

import java.util.ArrayList;

import upmc.train.constantes.IConstantes.EAction;
import upmc.train.model.communication.NetMonitor;
import upmc.train.model.exception.NoSuchTrain;
import upmc.train.model.server.NetMonitorDecoder;

public class CircuitSimulator implements Runnable
{

	private boolean isRunning = false; 
	private ArrayList<Train> trains = new ArrayList<Train>() ;
	@SuppressWarnings("unused")
	private NetMonitor communication ;
	private IStrategieValidator validator  = null ;
	
	public void setIsRunning(boolean val)
	{
		this.isRunning = val ;
	}
	
	public boolean isRunning()
	{
		return this.isRunning ;
	}
	
	public CircuitSimulator(NetMonitorDecoder decoder, NetMonitor com ) 
	{
		this.communication = com ;
	}
	private Train getTrainyAdresse(String adresse) throws NoSuchTrain
	{
		for(Train t : trains)
		{
			if (t.getAdresse().equals(adresse))
			{
				return t;
			}
		}
		throw new NoSuchTrain() ;
	}
	
	public void addTrain(Train t)
	{
		if (!isRunning)
			this.trains.add(t);
	}
	

	public void setMessageLocomotive(String idLoco, EAction action) throws NoSuchTrain
	{
		this.getTrainyAdresse(idLoco).setAction(action);
	}
	
	@Override
	public void run() {
		this.isRunning = true ;
		while(isRunning)
		{
			for(Train t : trains)
			{
				t.simulate() ;
			}
		}
		
	}

	public IStrategieValidator getValidator() {
		return validator;
	}

	public void setValidator(IStrategieValidator validator) {
		this.validator = validator;
	}
	
}
