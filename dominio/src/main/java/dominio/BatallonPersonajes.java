package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null, "Ha ganado el equipo 1");
		} else {
			pjsEnemigos.despuesDeBatallar();
			JOptionPane.showMessageDialog(null, "Ha ganado el equipo 2");
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
				npcsEnemigos.getEquipo().get(turno2).atacar(this.getEquipo().get(victima_del_npc));
				if (!this.getEquipo().get(victima_del_npc).estaVivo()) 
					this.getEquipo().remove(victima_del_npc);
				turno2++;
			}
			
			if (turno1 >= this.equipo.size()) 
				turno1 = 0;
			if (turno2 >= npcsEnemigos.equipo.size()) 
				turno2 = 0;
			}

		if (this.equipo.size() > 0) {
			this.despuesDeBatallar();
			JOptionPane.showMessageDialog(null, "Ha ganado el equipo 1");
		} else
			JOptionPane.showMessageDialog(null, "Ha ganado el equipo de NPC");
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
				pjsEnemigos.equipo.remove(victima);
			}
		}

	}

	public int elegirPjVictima(BatallonPersonajes enemigos) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la victima: "));
	}

	public int elegirPjBeneficiado() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el beneficiado: "));
	}

	public LinkedList<Personaje> getEquipo() {
		return equipo;
	}

	public void setEquipo(LinkedList<Personaje> equipo) {
		this.equipo = equipo;
	}

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
				pjsEnemigos.equipo.remove(victima);
			}
		}

	}

	public int elegirNPCVictima(BatallonNPC enemigos) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el NPC victima: "));
	}
}
