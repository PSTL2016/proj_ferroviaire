package upmc.train.controller.model;

import java.util.Random;

import upmc.train.model.Canton;
import upmc.train.model.Train;

public class AttenteTrain extends Thread
{
	private Train train ;
	private int delaiEnSeconde = 2 ;
	private Canton nextGare ;
	private IControleurStrategie strategie ;
	public AttenteTrain(Train t, Canton nextGare, IControleurStrategie strategie)
	{
		this.train = t ;
		this.strategie = strategie ;
		this.nextGare = nextGare ;
		Random r = new Random() ;
		delaiEnSeconde += r.nextInt(2) ;
		
	}
	
	public void run()
	{
		
		try {
			Thread.sleep(this.delaiEnSeconde * 1000) ;
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		strategie.redemarreTrain(train, nextGare);
		
		
	}

}
