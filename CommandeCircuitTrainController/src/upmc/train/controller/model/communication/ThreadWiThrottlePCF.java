/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.train.controller.model.communication;

import upmc.train.constantes.IConstantes.EDirection;
import upmc.train.controller.PCFEncoder;
import upmc.train.model.communication.ThreadWiThrottle;

/**
 *
 * @author brunolesueur
 * 
 * Cette classe permet de cr�er un client reseaux vers un serveur WiThrottle et permet
 * donc de controler les trains
 * 
 */
public class ThreadWiThrottlePCF extends ThreadWiThrottle
{
  
    private PCFEncoder encoder;
	private String adresseLoco ;
    
    synchronized public void  setMessage(String msg)
    {
    }
    
    public void  setEncoder(PCFEncoder encoder)
    {
    	this.encoder = encoder ;
    }
    
    public void stopWT()
    {
       /* this.setMessage("Q");
        output.flush() 
        ;*/
    }
    
    public void emergencyStop()
    {	
    		this.setSpeed(0);
    }
 
    public void setSpeed(int speed)
    {
    	String action = "" ;
    	if (speed == 0)
    		action = "stop" ;
    	else
    		action = "start" ;
    	if (encoder != null)
    		encoder.encodeChangeTrain(this.adresseLoco, action);
    }
    
    public void setDirection(EDirection direction)
    {
    	String action = "" ;
    	action = "stop" ;
    	String sDirection = "forward" ;
    	if (direction == EDirection.BACKWARD)
    		sDirection = "backward" ;
    	encoder.encodeChangeTrainDirection(this.adresseLoco, action,sDirection);
    }
    
    
    public void setDirection(int speed, EDirection direction)
    {
    	String action = "" ;
    	if (speed == 0)
    		action = "stop" ;
    	else
    		action = "start" ;
    	String sDirection = "forward" ;
    	if (direction == EDirection.BACKWARD)
    		sDirection = "backward" ;
    	encoder.encodeChangeTrainDirection(this.adresseLoco, action,sDirection);
    }
    public ThreadWiThrottlePCF(String adresse, int port, String adresseLoco)
    {
    	super() ;
    	this.adresseLoco = adresseLoco ;
 
    }
    public void startCommand()
    {
    
    }
    public void init(String adresse, int port, int adresseLoco)
    {
       
    }
    
    public void run()
    {
   
    }

    
}
