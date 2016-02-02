package upmc.train.model;

import upmc.train.constantes.IConstantes.EColor;
import upmc.train.model.communication.NetMonitor;
import upmc.train.model.exception.AlreadySetException;


public class Light 
{
	private String numero ;
	private EColor color ;
	private NetMonitor communication ;
	
	public String getNumero() 
	{
		return numero;
	}
	public Light(String numero, NetMonitor communication) 
	{
		this.numero = numero ;
		this.color = EColor.RED ;
		this.communication = communication ;
	}
	
	public void setColor(EColor color) throws AlreadySetException
	{
		if (this.color == color)
			throw new AlreadySetException() ;
		else
		{
			this.color = color ;
			if (communication != null)
				try
				{
					communication.changeFeu(Integer.parseInt(this.numero), this.color);
				}
				catch(Exception e)
				{
					
				}
		}
	}
	
	public void setColorWithoutCommunication(EColor color) throws AlreadySetException
	{
		if (this.color == color)
			throw new AlreadySetException() ;
		else
		{
			this.color = color ;
		}
	}
	
	public String getColorAsString()
	{
		if (this.color == EColor.RED)
			return "red" ;
		else
			return "green" ;
					
	}
	
	
}
