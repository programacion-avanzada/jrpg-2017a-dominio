package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BatallonPersonajes  {

	private LinkedList <Personaje> equipo;
	private String alianza;
	private int exp1;
	private LinkedList<Item> items;
	
	
	
	
	public BatallonPersonajes(LinkedList <Personaje> aliados)//de pjs
	{
		this.equipo=aliados;
		this.alianza=this.equipo.get(0).getClan().nombre;
		this.exp1=0;
		this.items = new LinkedList <Item>();
	}
	
	public void despuesDeBatallar()
	{
		
		int cant_sobrevivientes=this.equipo.size();
		Iterator <Personaje> it =this.equipo.iterator();
		exp1/=cant_sobrevivientes;
		System.out.println("CANT. SOBREVIVIENTES: "+cant_sobrevivientes);
		while(it.hasNext())
		{	
			System.out.println("EXPERIENCIA QUE LE VOY A DAR: "+exp1);
			it.next().ganarExperiencia(exp1);
		}
		if(items.size()>0)
			this.repartirItems();
		
	}
	
	public void repartirItems()
	{
		int j;
		Iterator <Personaje> it = this.equipo.iterator();
		while(it.hasNext())
		{
			if(it.next().getItemsGuardados().size()>=20)
				it.remove();
		}
		if(this.equipo.size()==0 || items.size()==0)
			return;
		
		
		if(items.size()==this.equipo.size())
		{
			for(int i=0;i<items.size();i++)
				this.equipo.get(i).guardarItem(items.get(i));
		}
		
		if(items.size()<this.equipo.size())
		{
			System.out.println("oaaaaa");
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
				if(j>=this.equipo.size())
					j=0;
			}
		}
		
	}
	
	public void batallarContraPersonajes(BatallonPersonajes pjsEnemigos)
	{
		int exp1=0,exp2=0;
		LinkedList <Item> items1 = new LinkedList <Item>();
		LinkedList <Item> items2 = new LinkedList <Item>();
		int turno1=0,turno2=0;
		int opcion;
		int victima;
		
		this.establecerEstrategia();
		pjsEnemigos.establecerEstrategia();
		
		while(this.equipo.size()>0 && pjsEnemigos.equipo.size()>0)
		{
		/*	if(!this.equipo.get(turno1).estaVivo())
			{
				items1.add(this.equipo.get(turno1).otorgarItem());
				exp1 +=this.equipo.get(turno1).otorgarExp();
				this.equipo.remove(turno1);
			}*/
			if(this.equipo.size()>0)
			{
				if(turno1==this.equipo.size())
					turno1=0;
			opcion=this.equipo.get(turno1).elegirOpcion();
			this.realizarTurno(turno1, opcion, pjsEnemigos);
			turno1++;
			}
		
			if(pjsEnemigos.equipo.size()>0)
			{
				if(turno2==pjsEnemigos.equipo.size())
					turno2=0;
			opcion=pjsEnemigos.equipo.get(turno2).elegirOpcion();
			pjsEnemigos.realizarTurno(turno2, opcion, this);
			turno2++;
			}
			/*System.out.println("TURNO 1= "+turno1+" TURNO 2= "+turno2);
			if(turno1>=this.equipo.size())
				{
				turno1=0;
				System.out.println("RESETEO TURNO 1");
				}
			if(turno2>=pjsEnemigos.equipo.size())
				{
				turno2=0;
				System.out.println("RESETEO TURNO 2");

				}*/
			
		}
		
		if(this.equipo.size()>0)
			{this.despuesDeBatallar();
			System.out.println("GANO EL PRIMERO");
			}
		else
			{pjsEnemigos.despuesDeBatallar();
			System.out.println("GANO EL SEGUNDO");

			}
	}
	
	
	
	public void batallarContraNPCs(BatallonNPC npcsEnemigos)
	{
		
		this.establecerEstrategia();
		
		
		while(this.equipo.size()>0 && npcsEnemigos.equipo.size()>0)
		{
			
		}

	}
	
public void establecerEstrategia(){
		
	}
	
	public void accion(LinkedList <Item> items)
	{
		
	}
	
	public void realizarTurno(int turno1,int opcion,BatallonPersonajes pjsEnemigos)
	{
		int victima;
		switch (opcion)
		{
		case 1: victima = this.elegirPjVictima(pjsEnemigos);
				victima-=1;
				this.equipo.get(turno1).atacar(pjsEnemigos.equipo.get(victima));
				if(!pjsEnemigos.equipo.get(victima).estaVivo())
					{
						items.add(pjsEnemigos.equipo.get(victima).otorgarItem());
						exp1 += pjsEnemigos.equipo.get(victima).otorgarExp();
						System.out.println(pjsEnemigos.equipo.get(victima).getNombre()+" ha muerto!\n");
						pjsEnemigos.equipo.remove(victima);
					}
				break;
		case 2:  victima = this.elegirPjVictima(pjsEnemigos);
				 victima-=1;
				 this.equipo.get(turno1).habilidadCasta1(pjsEnemigos.equipo.get(victima));
				 if(!pjsEnemigos.equipo.get(victima).estaVivo())
					{
						items.add(pjsEnemigos.equipo.get(victima).otorgarItem());
						exp1 +=pjsEnemigos.equipo.get(victima).otorgarExp();
						System.out.println(pjsEnemigos.equipo.get(victima).getNombre()+" ha muerto!\n");
						pjsEnemigos.equipo.remove(victima);
					}
				break;
		case 3: if	( this.equipo.get(turno1).getCasta() instanceof Hechicero)
					{
					victima = this.elegirPjBeneficiado();//lo va a curar
					victima-=1;
					this.equipo.get(turno1).habilidadCasta2(this.equipo.get(victima));
					
					}
				else
					this.equipo.get(turno1).habilidadCasta2(null);
				break;
		case 4: victima = this.elegirPjVictima(pjsEnemigos);
				victima-=1;
				this.equipo.get(turno1).habilidadCasta3(pjsEnemigos.equipo.get(victima));
				if(!pjsEnemigos.equipo.get(victima).estaVivo())
				{
					items.add(pjsEnemigos.equipo.get(victima).otorgarItem());
					exp1 +=pjsEnemigos.equipo.get(victima).otorgarExp();
					System.out.println(pjsEnemigos.equipo.get(victima).getNombre()+" ha muerto!\n");
					pjsEnemigos.equipo.remove(victima);
				}
			break;
		case 5: if(this.equipo.get(turno1) instanceof Humano)
		{
			victima = this.elegirPjBeneficiado();//lo va a incentivar
			victima-=1;
			this.equipo.get(turno1).habilidadRaza1(this.equipo.get(victima));
		}
		else
		{
			victima = this.elegirPjVictima(pjsEnemigos);
			victima-=1;
			this.equipo.get(turno1).habilidadRaza1(pjsEnemigos.equipo.get(victima));
			if(!pjsEnemigos.equipo.get(victima).estaVivo())
			{
				items.add(pjsEnemigos.equipo.get(victima).otorgarItem());
				exp1 +=pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre()+" ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
		
		}
		break;	
		case 6:victima = this.elegirPjVictima(pjsEnemigos);
		victima-=1;
		this.equipo.get(turno1).habilidadRaza2(pjsEnemigos.equipo.get(victima));
		if(!pjsEnemigos.equipo.get(victima).estaVivo())
		{
			items.add(pjsEnemigos.equipo.get(victima).otorgarItem());
			exp1 +=pjsEnemigos.equipo.get(victima).otorgarExp();
			System.out.println(pjsEnemigos.equipo.get(victima).getNombre()+" ha muerto!\n");
			pjsEnemigos.equipo.remove(victima);
		}
		}
		
	}
	
	public int elegirPjVictima(BatallonPersonajes enemigos)
	{
		Scanner sc = new Scanner(System.in);
		String aux="";
		System.out.println("\nBatallon enemigo:");
		for(int i=0;i<enemigos.equipo.size();i++)
			aux+=enemigos.equipo.get(i).getNombre()+"  ";
		System.out.println(aux);
		return sc.nextInt();
	}
	
	public int elegirPjBeneficiado()
	{
		Scanner sc = new Scanner(System.in);
		String aux="";
		System.out.println("Batallon aliado:");
		for(int i=0;i<this.equipo.size();i++)
			aux+=this.equipo.get(i).getNombre()+"  ";
		System.out.println(aux);
		return sc.nextInt();
	}
	
}
