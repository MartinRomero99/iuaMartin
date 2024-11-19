package aObjetos.aoPersonas.clases;

import java.util.Scanner;

public class Persona {
   private String nombre;
   private String dni;
   private int edad;

  
   public Persona() {
      nombre = "******";
      dni = "******";
      edad = 0;
   }

   public Persona(String nom, String d, int e) {
      nombre = nom;
      dni = d;
      edad = e;
   }

   public void AsignarDatos(Scanner datos) {
      /*------------------------------------------- */
      /* Ingresamos los datos de la persona */
      /*------------------------------------------- */
      System.out.print("Ingrese el Nombre de la persona: ");
      this.nombre = datos.nextLine();
      System.out.print("Ingrese el DNI de la persona: ");
      this.dni = datos.nextLine();
      System.out.print("Ingrese la Edad de la persona: ");
      this.edad = Integer.parseInt(datos.nextLine());
   }

   /*-------------------------------*/
   public String MostrarDatos() {
      String datos = "Nombre: " + nombre + " DNI: " + dni + " Edad: " + edad;
      return datos;
   }

   public void imprimirDatos() {
      System.out.println("\tNombre: " + nombre + "\n\tDNI: " + dni + "\n\tEdad: " + edad);

   }

   /*-------------------------------*/
   /* GETTERS Y SETTERS */
   /*-------------------------------*/
   public int getEdad() {
      return edad;
   }

   public String getDni() {
      return dni;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setDni(String dni) {
      this.dni = dni;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }
}
