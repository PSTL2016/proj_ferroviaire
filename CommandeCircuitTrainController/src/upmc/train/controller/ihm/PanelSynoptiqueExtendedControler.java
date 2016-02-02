package upmc.train.controller.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import upmc.train.constantes.IConstantes.EColor;
import upmc.train.constantes.IConstantes.EDirection;
import upmc.train.controller.model.Controller;
import upmc.train.model.Light;


public class PanelSynoptiqueExtendedControler extends
		MouseAdapter
{
	protected PanelSynoptiqueExtended vue ;
	protected Controller model ;
	public void setModel(Controller model) {
		this.model = model;
	}
	private Node selectedNode ;
	
	public PanelSynoptiqueExtendedControler(PanelSynoptiqueExtended vue) 
	{
		super() ;
		this.vue = vue ;
		vue.addMouseListener(this);
	}
 
	public void mousePressed(MouseEvent evt)
	{
		Node n = ((PanelSynoptiqueExtended)vue).getNodeForPosition(evt.getX(), evt.getY()) ;
		if (n != null)
		{
			selectedNode = n ;
		}	
	}
	public void mouseReleased(MouseEvent evt)
	{
		if (selectedNode != null)
		{	
			((PanelSynoptiqueExtended)vue).setNewPosition(evt.getX(),evt.getY(), selectedNode) ;
		}

		selectedNode = null ;
	}
	public void mouseClicked(MouseEvent evt)
	{
		Light l = vue.getLightByPosition(evt.getX(), evt.getY()) ;
		if (l != null)
		{
			EColor color ;
			if (l.getColorAsString().equals("red"))
				color = EColor.GREEN ;
			else
				color = EColor.RED ;

			this.model.changeLight(l, color, EDirection.FORWARD);	
		}
		Node n = ((PanelSynoptiqueExtended)vue).getNodeForPosition(evt.getX(), evt.getY()) ;
		if (n != null)
		{
			if (n.getCanton().getAllNext(EDirection.FORWARD).size() > 1)
			{
				n.getCanton().switchAiguillage() ;
				this.model.changed(null);
			}
			if (n.getCanton().getAllPrevious(EDirection.FORWARD).size() > 1)
			{
				n.getCanton().switchAiguillage() ;
				this.model.changed(null);
			}			
		}
	}
	
}
