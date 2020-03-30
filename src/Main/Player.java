package Main;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<Domino> hand = new ArrayList<Domino>();
	public boolean isCPU = true;
	
	public List<Domino> getHand() {return this.hand;}
	
}
