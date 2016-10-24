package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class BatallonPersonajes  {

	LinkedList <Personaje> equipo;
	String alianza;
	
	public LinkedList <Personaje> armarBatallonPjs(Personaje p)
	{
		
		LinkedList <Personaje> batallon_amigo = new LinkedList();
		Iterator <Personaje> it = p.getClan().getAliados().iterator(); 
		while(it.hasNext())
		{
			if(it.next().distanciaCon(p)<=10)
				batallon_amigo.add(it.next());
		}
		return batallon_amigo;
	}
	
	
	public BatallonPersonajes(LinkedList <Personaje> aliados)//de pjs
	{
		this.equipo=aliados;
		this.alianza=this.equipo.get(0).getClan().nombre;
	}
	
	public void despuesDeBatallar(int exp,LinkedList<Item> itemsParaRepartir)
	{
		
		int cant_sobrevivientes=this.equipo.size();
		Iterator <Personaje> it =equipo.iterator();
		exp/=cant_sobrevivientes;
		while(it.hasNext())
			it.next().ganarExperiencia(exp);
		if(itemsParaRepartir.size()>0)
			this.repartirItems(itemsParaRepartir);
		
	}
	
	public void repartirItems(LinkedList<Item> items)
	{
		int j;
		if(items.size()==this.equipo.size())
		{
			for(int i=0;i<items.size();i++)
					{
						j=i;
						while(!this.equipo.get(j).guardarItem(items.get(i)) && j<this.equipo.size())
							j++;
						if(j==this.equipo.size())	
							return;
					}
		}
		if(items.size()<this.equipo.size())
		{
			Random rnd = new Random();
			int cant_veces=this.equipo.size()*2,controlador=0;
			for(int i=0;i< items.size();i++)
			{
				j=rnd.nextInt(this.equipo.size());
				while(!this.equipo.get(j).guardarItem(items.get(i)) && controlador<cant_veces)
						{
							j=rnd.nextInt(this.equipo.size());
							controlador++;
						}
			}
		}
		///FALTA REPARTIR SI HAY MAS ITEMS QUE PJS
	}
	
	public void batallarContraPersonajes(BatallonPersonajes pjsEnemigos)
	{
		
	}
	
	public void batallarContraNPCs(BatallonNPC npcsEnemigos)
	{
		
	}
	
	
}
