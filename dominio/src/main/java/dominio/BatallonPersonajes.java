package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BatallonPersonajes {

	private LinkedList<Personaje> equipo;
	private String alianza;
	private int experienciaGanada;
	private LinkedList<Item> itemsGanados;

	public BatallonPersonajes(LinkedList<Personaje> aliados) {
		this.equipo = aliados;
		if (this.equipo.get(0).getClan() != null)
			this.alianza = this.equipo.get(0).getClan().nombre;
		this.experienciaGanada = 0;
		this.itemsGanados = new LinkedList<Item>();
	}

	public void despuesDeBatallar() {
		int cantidadDeSobrevivientes = this.equipo.size();
		Iterator<Personaje> it = this.equipo.iterator();
		experienciaGanada /= cantidadDeSobrevivientes;
		while (it.hasNext())
			it.next().ganarExperiencia(experienciaGanada);
		if (itemsGanados.size() > 0)
			this.repartirItems();
	}

	public void repartirItems() {
		int j;
		Iterator<Personaje> it = this.equipo.iterator();
		while (it.hasNext()) {
			if (it.next().getItemsGuardados().size() >= 20)
				it.remove();
		}
		if (this.equipo.size() == 0 || itemsGanados.size() == 0)
			return;

		if (itemsGanados.size() == this.equipo.size()) {
			for (int i = 0; i < itemsGanados.size(); i++)
				this.equipo.get(i).guardarItem(itemsGanados.get(i));
		}

		if (itemsGanados.size() < this.equipo.size()) {
			Random rnd = new Random();
			for (int i = 0; i < itemsGanados.size(); i++) {
				j = rnd.nextInt(this.equipo.size());
				this.equipo.get(j).guardarItem(itemsGanados.get(i));
			}
		}

		if (itemsGanados.size() > this.equipo.size()) {
			j = 0;
			for (int i = 0; i < itemsGanados.size(); i++) {
				while (j <= this.equipo.size() && !this.equipo.get(j).guardarItem(itemsGanados.get(i)))
					j++;
				j++;
				if (j >= this.equipo.size())
					j = 0;
			}
		}

	}

	public void batallarContraPersonajes(BatallonPersonajes pjsEnemigos) {
		int turno1 = 0, turno2 = 0;
		int opcion;
		this.establecerEstrategia();
		pjsEnemigos.establecerEstrategia();

		while (this.equipo.size() > 0 && pjsEnemigos.equipo.size() > 0) {

			if (this.equipo.size() > 0) {
				if (turno1 == this.equipo.size())
					turno1 = 0;
				opcion = this.equipo.get(turno1).elegirOpcion();
				this.realizarTurno(turno1, opcion, pjsEnemigos);
				turno1++;
			}

			if (pjsEnemigos.equipo.size() > 0) {
				if (turno2 == pjsEnemigos.equipo.size())
					turno2 = 0;
				opcion = pjsEnemigos.equipo.get(turno2).elegirOpcion();
				pjsEnemigos.realizarTurno(turno2, opcion, this);
				turno2++;
			}

			if (turno1 >= this.equipo.size())
				turno1 = 0;
			if (turno2 >= pjsEnemigos.equipo.size())
				turno2 = 0;
		}

		if (this.equipo.size() > 0) {
			this.despuesDeBatallar();
			System.out.println("GANO EL PRIMERO");
		} else {
			pjsEnemigos.despuesDeBatallar();
			System.out.println("GANO EL SEGUNDO");
		}
	}

	public void batallarContraNPCs(BatallonNPC npcsEnemigos) {

		int turno1 = 0, turno2 = 0;
		int opcion;
		Random rnd = new Random();
		int victima_del_npc;

		this.establecerEstrategia();

		while (this.equipo.size() > 0 && npcsEnemigos.getEquipo().size() > 0) {

			if (this.equipo.size() > 0) {
				if (turno1 == this.equipo.size())
					turno1 = 0;
				opcion = this.equipo.get(turno1).elegirOpcion();
				this.realizarTurnoVsNPC(turno1, opcion, npcsEnemigos);
				turno1++;
			}

			if (npcsEnemigos.equipo.size() > 0) {
				if (turno2 == npcsEnemigos.equipo.size())
					turno2 = 0;
				victima_del_npc = rnd.nextInt(this.getEquipo().size());
				System.out.println(npcsEnemigos.getEquipo().get(turno2).getNombre() + " ataca a "
						+ (this.getEquipo().get(victima_del_npc).getNombre()));
				npcsEnemigos.getEquipo().get(turno2).atacar(this.getEquipo().get(victima_del_npc));
				if (!this.getEquipo().get(victima_del_npc).estaVivo()) {
					System.out.println(this.getEquipo().get(victima_del_npc).getNombre() + " ha muerto!");
					this.getEquipo().remove(victima_del_npc);
				}
				turno2++;
			}
			
			if (turno1 >= this.equipo.size()) 
				turno1 = 0;
			if (turno2 >= npcsEnemigos.equipo.size()) 
				turno2 = 0;
			}

		if (this.equipo.size() > 0) {
			this.despuesDeBatallar();
			System.out.println("GANO EL PRIMERO");
		} else
			System.out.println("GANARON LOS NPCs");

	}

	public void establecerEstrategia() {

	}

	public void accion(LinkedList<Item> items) {

	}

	public void realizarTurno(int turno1, int opcion, BatallonPersonajes pjsEnemigos) {
		int victima;
		switch (opcion) {
		case 1:
			victima = this.elegirPjVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).atacar(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).otorgarItem());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
			break;
		case 2:
			victima = this.elegirPjVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).habilidadCasta1(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).otorgarItem());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
			break;
		case 3:
			if (this.equipo.get(turno1).getCasta() instanceof Hechicero) {
				victima = this.elegirPjBeneficiado();// lo va a curar
				victima -= 1;
				this.equipo.get(turno1).habilidadCasta2(this.equipo.get(victima));

			} else
				this.equipo.get(turno1).habilidadCasta2(null);
			break;
		case 4:
			victima = this.elegirPjVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).habilidadCasta3(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).otorgarItem());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
			break;
		case 5:
			if (this.equipo.get(turno1) instanceof Humano) {
				victima = this.elegirPjBeneficiado();// lo va a incentivar
				victima -= 1;
				this.equipo.get(turno1).habilidadRaza1(this.equipo.get(victima));
			} else {
				victima = this.elegirPjVictima(pjsEnemigos);
				victima -= 1;
				this.equipo.get(turno1).habilidadRaza1(pjsEnemigos.equipo.get(victima));
				if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
					itemsGanados.add(pjsEnemigos.equipo.get(victima).otorgarItem());
					experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
					System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
					pjsEnemigos.equipo.remove(victima);
				}

			}
			break;
		case 6:
			victima = this.elegirPjVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).habilidadRaza2(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).otorgarItem());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
		}

	}

	public int elegirPjVictima(BatallonPersonajes enemigos) {
		Scanner sc = new Scanner(System.in);
		String aux = "";
		System.out.println("\nBatallon enemigo:");
		for (int i = 0; i < enemigos.getEquipo().size(); i++)
			aux += enemigos.getEquipo().get(i).getNombre() + "  ";
		System.out.println(aux);
		return sc.nextInt();
	}

	public int elegirPjBeneficiado() {
		Scanner sc = new Scanner(System.in);
		String aux = "";
		System.out.println("Batallon aliado:");
		for (int i = 0; i < this.equipo.size(); i++)
			aux += this.equipo.get(i).getNombre() + "  ";
		System.out.println(aux);
		return sc.nextInt();
	}

	public LinkedList<Personaje> getEquipo() {
		return equipo;
	}

	public void setEquipo(LinkedList<Personaje> equipo) {
		this.equipo = equipo;
	}

	/*
	 * public boolean matoAlEnemigo(BatallonPersonajes pjsEnemigos, int victima)
	 * { if(!pjsEnemigos.equipo.get(victima).estaVivo()) {
	 * items.add(pjsEnemigos.equipo.get(victima).otorgarItem()); exp1 +=
	 * pjsEnemigos.equipo.get(victima).otorgarExp();
	 * System.out.println(pjsEnemigos.equipo.get(victima).getNombre()
	 * +" ha muerto!\n"); return true; } return false; }
	 */
	public void realizarTurnoVsNPC(int turno1, int opcion, BatallonNPC pjsEnemigos) {
		int victima;
		switch (opcion) {
		case 1:
			victima = this.elegirNPCVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).atacar(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).dropearItemAleatorio());// otrogarItem()
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
			break;
		case 2:
			victima = this.elegirNPCVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).habilidadCasta1(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).dropearItemAleatorio());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
			break;
		case 3:
			if (this.equipo.get(turno1).getCasta() instanceof Hechicero) {
				victima = this.elegirPjBeneficiado();// lo va a curar
				victima -= 1;
				this.equipo.get(turno1).habilidadCasta2(this.equipo.get(victima));

			} else
				this.equipo.get(turno1).habilidadCasta2(null);
			break;
		case 4:
			victima = this.elegirNPCVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).habilidadCasta3(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).dropearItemAleatorio());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
			break;
		case 5:
			if (this.equipo.get(turno1) instanceof Humano) {
				victima = this.elegirPjBeneficiado();// lo va a incentivar
				victima -= 1;
				this.equipo.get(turno1).habilidadRaza1(this.equipo.get(victima));
			} else {
				victima = this.elegirNPCVictima(pjsEnemigos);
				victima -= 1;
				this.equipo.get(turno1).habilidadRaza1(pjsEnemigos.equipo.get(victima));
				if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
					itemsGanados.add(pjsEnemigos.equipo.get(victima).dropearItemAleatorio());
					experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
					System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
					pjsEnemigos.equipo.remove(victima);
				}

			}
			break;
		case 6:
			victima = this.elegirNPCVictima(pjsEnemigos);
			victima -= 1;
			this.equipo.get(turno1).habilidadRaza2(pjsEnemigos.equipo.get(victima));
			if (!pjsEnemigos.equipo.get(victima).estaVivo()) {
				itemsGanados.add(pjsEnemigos.equipo.get(victima).dropearItemAleatorio());
				experienciaGanada += pjsEnemigos.equipo.get(victima).otorgarExp();
				System.out.println(pjsEnemigos.equipo.get(victima).getNombre() + " ha muerto!\n");
				pjsEnemigos.equipo.remove(victima);
			}
		}

	}

	public int elegirNPCVictima(BatallonNPC enemigos) {
		Scanner sc = new Scanner(System.in);
		String aux = "";
		System.out.println("\nBatallon enemigo:");
		for (int i = 0; i < enemigos.getEquipo().size(); i++)
			aux += enemigos.getEquipo().get(i).getNombre() + "  ";
		System.out.println(aux);
		return sc.nextInt();
	}
}
