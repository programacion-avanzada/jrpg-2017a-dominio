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
		Iterator <Personaje> it = this.equipo.iterator();
		while(it.hasNext())
		{
			if(it.next().getItemsGuardados().size()>=20)
				it.remove();
		}
		if(this.equipo.size()==0)
			return;
		
		
		if(items.size()==this.equipo.size())
		{
			for(int i=0;i<items.size();i++)
				this.equipo.get(i).guardarItem(items.get(i));
		}
		
		if(items.size()<this.equipo.size())
		{
			Random rnd = new Random();
			for(int i=0;i<items.size();i++)
			{
				j=rnd.nextInt(this.equipo.size());
				this.equipo.get(j).guardarItem(items.get(i));
			}
		}
		
		if(items.size()>this.equipo.size())
		{
			j=0;
			for(int i=0;i<items.size();i++)
			{
				while(j<=this.equipo.size() && !this.equipo.get(j).guardarItem(items.get(i)) )
					j++;
				
				j++;
				if(j>this.equipo.size())
					j=0;
			}
		}
		
	}
	
	public void batallarContraPersonajes(BatallonPersonajes pjsEnemigos)
	{
		int exp1=0,exp2=0;
		LinkedList <Item> items1 = new LinkedList <Item>();
		LinkedList <Item> items2 = new LinkedList <Item>();
		
		this.establecerEstrategia();
		pjsEnemigos.establecerEstrategia();
		
		while(this.equipo.size()>0 && pjsEnemigos.equipo.size()>0)
		{
			this.accion();
			pjsEnemigos.accion();
		}
		
		if(this.equipo.size()>0)
			this.despuesDeBatallar(exp1, items1);
		else
			pjsEnemigos.despuesDeBatallar(exp2, items2);
	}
	
	public void batallarContraNPCs(BatallonNPC npcsEnemigos)
	{
		int exp1;
		LinkedList <Item> items1 = new LinkedList <Item>();
		this.establecerEstrategia();
		
		while(this.equipo.size()>0 && npcsEnemigos.equipo.size()>0)
		{
			this.accion();
			npcsEnemigos.accion();
		}

		
		
	}
	
public void establecerEstrategia(){
		
	}
	
	public void accion()
	{
		
	}
	
}
