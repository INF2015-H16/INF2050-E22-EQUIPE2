/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarefactoring1;
/**
 *
 * @author zzaier
 */
public class Warehouse {
    String idOffice;
    Integer nbDesks;
    Integer nbSquareFeet;

 	public String getIdOffice() {
		return idOffice;
	}

	public void setIdOffice(String idOffice) {
		this.idOffice = idOffice;
	}

	public Integer getNbDesks() {
		return nbDesks;
	}

	public void setNbDesks(Integer nbDesks) {
		this.nbDesks = nbDesks;
	}

	public Integer getNbSquareFeet() {
		return nbSquareFeet;
	}

	public void setNbSquareFeet(Integer nbSquareFeet) {
		this.nbSquareFeet = nbSquareFeet;
	}
}
