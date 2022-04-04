package aplicacionl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Participante;
import clases.proyecto;


public class consola 
{
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		
        AplicacionPrincipal p1= new AplicacionPrincipal();
        String usuarioActual="";
        ArrayList<Participante> usuarios=new ArrayList<>();
        ArrayList<proyecto> proyectosS=new ArrayList<>();
		usuarios = p1.cargarUsuarios(usuarios);
		proyectosS = p1.cargarProyectos(proyectosS);
		System.out.println("bienvenidos");
		System.out.println("1. tiene cuenta: ");
		System.out.println("2. crear cuenta");
		Scanner opciones= new Scanner(System.in);
		System.out.println("ingrese la opcion que prefiera: ");
		String opciones1 = opciones.nextLine();
		
		if (opciones1.equals("1")) {
		
			System.out.println("ingrese su nombre de usuario: ");
			String opcionesnombre = opciones.nextLine();
			
			System.out.println("ingrese su contraseña: ");
			String opcionescontraseña = opciones.nextLine();
			
			for (int i=0;i<usuarios.size();i++){
                if (usuarios.get(i).getUserName().equals(opcionesnombre)){
                    if (usuarios.get(i).getContraseña().equals(opcionescontraseña)){
                        System.out.println("Bienvenido "+usuarios.get(i).getNombre());
                        usuarioActual=usuarios.get(i).getUserName();
                    }}}
			p1.menuProyect(usuarioActual, proyectosS, usuarios);

			
		}else{p1.registrarUsuario(usuarios);
           
    }
	}

	
}
