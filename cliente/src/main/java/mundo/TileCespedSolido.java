package mundo; 
 
import recursos.Recursos; 
 
public class TileCespedSolido extends Tile { 
 
  public TileCespedSolido( int id) { 
    super(Recursos.cesped, id); 
  } 
   
  @Override 
  public boolean esSolido() { 
    return true; 
  } 

} 
