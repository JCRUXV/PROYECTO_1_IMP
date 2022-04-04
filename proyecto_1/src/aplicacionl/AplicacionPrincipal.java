package aplicacionl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import clases.Participante;
import clases.RegistroActividad;
import clases.Tiempo;
import clases.proyecto;

public class AplicacionPrincipal 
 {
	
	
	        ArrayList<Participante> usuarios = new ArrayList<>();
	        public ArrayList<Participante> cargarUsuarios(ArrayList<Participante> usuarios) throws FileNotFoundException, IOException{
	            String currentDirectory = new File("").getAbsolutePath();
	            try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src//usuarios.csv//"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] values = line.split(",");
	                usuarios.add(new Participante(values[0], values[1], values[3],values[2]));
	            }
	            usuarios.remove(0);
	            return (ArrayList<Participante>) usuarios;
	        }
	        }
	            
	            
	            ArrayList<proyecto> ProyectosS = new ArrayList<>();
	            
	           public ArrayList<proyecto> cargarProyectos(ArrayList<proyecto> ProyectosS) throws FileNotFoundException, IOException, ParseException {
	                String currentDirectory = new File("").getAbsolutePath();
	                try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src//datosProyectos.csv//"))){
	                    String line;
	                while ((line = br.readLine()) != null) {
	                    String[] values = line.split(",");
	                   ProyectosS.add(new proyecto(values[0],values[1], values[2], values[3], new Participante(values[4], values[5], values[6], values[7])));
	                }
	                }
	                return (ArrayList<proyecto>) ProyectosS; 
	                
	                
	                
	                
	            }
	
	           
	           public void registrarUsuario(ArrayList<Participante> usuarios) throws IOException	
	           {
	        	   System.out.println("----REGISTRO DE USUARIO----");
	               Scanner nombreRegistro= new Scanner(System.in);
	               System.out.println("Por favor ingrese su nombre: ");
	               String nombreRegistroU= nombreRegistro.nextLine();
	               String usuarioDefinitivo="";
	               boolean RevisarUsuario=false;
	               ArrayList<String> usuariosRegistrados=new ArrayList<>();
	               ArrayList<String> correosRegistrados=new ArrayList<>();
	               for (int i=0;i<usuarios.size();i++){
	                   usuariosRegistrados.add(usuarios.get(i).getUserName());
	                   correosRegistrados.add(usuarios.get(i).getCorreo());
	               }
	               while (RevisarUsuario==false){
	                   Scanner nombreUsuarioRegistro= new Scanner(System.in);
	                   System.out.println("Ingrese el nombre de usuario deseado: ");
	                   String usuarioCompararRegistro= nombreUsuarioRegistro.nextLine();
	                   if (usuariosRegistrados.contains(usuarioCompararRegistro)){
	                       System.out.println("El usuario ya registrado");
	                   }else{
	                       usuarioDefinitivo=usuarioCompararRegistro;
	                       RevisarUsuario=true;
	                   }
	               }
	               boolean correoComparar=false;
	               String correoDefinitivo="";
	               while (correoComparar==false){
	                   Scanner correoRegistro= new Scanner(System.in);
	                   System.out.println("Por favor ngrese el correo: ");
	                   String correoUsuarioComparar=correoRegistro.nextLine();
	                   if (correosRegistrados.contains(correoUsuarioComparar)){
	                       System.out.println("El correo ya está registrado");
	                   }else{
	                    correoDefinitivo=correoUsuarioComparar;
	                    correoComparar=true;
	                }
	                
	            }
	            Scanner contrasenaRegistro= new Scanner(System.in);
	            System.out.println("Por favor ingrese su contraseña: ");
	            String contrasenaFinal=contrasenaRegistro.nextLine();
	            usuarios.add(new Participante(usuarioDefinitivo,correoDefinitivo,nombreRegistroU,contrasenaFinal));
	            String currentDirectory = new File("").getAbsolutePath();
	            FileWriter csvWriter;
	            csvWriter = new FileWriter(currentDirectory +"//src//usuarios.csv//");
	                    csvWriter.append("nombre");
	                    csvWriter.append(",");
	                    csvWriter.append("Correo");
	                    csvWriter.append(",");
	                    csvWriter.append("Contraseña");
	                    csvWriter.append(",");
	                    csvWriter.append("Nombre de usuario");
	                    csvWriter.append("\n");
	                    for (Participante rowData : usuarios) {
	                       
	                        csvWriter.append(String.join(",", rowData.getNombre()+","));
	                        csvWriter.append(String.join(",", rowData.getCorreo()+","));
	                        csvWriter.append(String.join(",", rowData.getContraseña()+","));
	                        csvWriter.append(String.join(",", rowData.getUserName()));
	                        
	                    csvWriter.append("\n");
	                    }
	                    csvWriter.flush();
	                    csvWriter.close();
	                    System.out.println("El usuario ya se encuentra registrado,por favor vuelva a cargar la aplicacion");
	            
	        }
	           public void menuProyect(String usuarioActual,ArrayList<proyecto> proyectosS,ArrayList<Participante> usuarios) throws ParseException, IOException {
	        	   Scanner opcionesConsola= new Scanner(System.in);
                   boolean opciones2Boolean=false;
		

                   while (opciones2Boolean==false){
                       System.out.println("----OPCIONES DE LA APLICACION----");
                       System.out.println("1. Crear nuevo proyecto");
                       System.out.println("2. Abrir proyecto existente");
                       System.out.println("3. Salir");
                       String opcionesConsolaS=opcionesConsola.nextLine();
                       if (opcionesConsolaS.equals("1")){
                           creacionProyecto(usuarios, usuarioActual,proyectosS);
                       }else if (opcionesConsolaS.equals("3")){
                           opciones2Boolean=true;
	           }Scanner opcionesConsola2= new Scanner(System.in);
               boolean opciones3Boolean=false;
               while (opciones3Boolean==false){
               System.out.println("----OPCIONES PARA EL PROYECTO----");
               System.out.println("1.Modificar datos del proyecto");
               System.out.println("2.Agregar Participantes");
               System.out.println("3.Menu de actividades");
               System.out.println("4.Reporte de participante");
               System.out.println("5.Salir");
               String opcionesConsolaS2=opcionesConsola2.nextLine();
               if (opcionesConsolaS2.equals("1")){
                   Scanner proyectoACambiar= new Scanner(System.in);
                   System.out.println("por favor ingrese el nombre del proyecto que desea modificar: ");
                   String nombreProy=proyectoACambiar.nextLine();
                   proyecto pCambio= new proyecto("","", "","", null);
                   for (int i2=0;i2<proyectosS.size();i2++){
                       if (proyectosS.get(i2).getNombre().equals(nombreProy)){
                           pCambio=proyectosS.get(i2);
                       }
                   }
                   if (usuarioActual.equals(pCambio.getParticipanteJefe().getUserName())){
                       modificarDatosProyecto(pCambio, proyectosS, usuarios);
                   }else{
                       System.out.println("Solo el/la participante lider puede modificar los datos del proyecto");
                   }
               }else if (opcionesConsolaS2.equals("5")){
                   opciones3Boolean=true;
               }else if (opcionesConsolaS2.equals("2")){
                   Scanner proyectoACambiar= new Scanner(System.in);
                   System.out.println("Por favor ingrese el nombre del proyecto que desea modificar: ");
                   String nombreProy=proyectoACambiar.nextLine();
                   proyecto pCambio= new proyecto("","", "","", null);
                   for (int i2=0;i2<proyectosS.size();i2++){
                       if (proyectosS.get(i2).getNombre().equals(nombreProy)){
                           pCambio=proyectosS.get(i2);
                       }
                   }
                   if (usuarioActual.equals(pCambio.getParticipanteJefe().getUserName())){
                       agregarParticipantes(pCambio, usuarios);
                   }else{
                       System.out.println("Solo el/la participante lider puede agregar participantes");
                   }
               }else if (opcionesConsolaS2.equals("3")){
                   Scanner proyectoACambiar= new Scanner(System.in);
                   System.out.println("Por favor ingrese el nombre del proyecto al que desea agregarle una actividad: ");
                   String nombreProy=proyectoACambiar.nextLine();
                   proyecto pCambio= new proyecto("","", "","", null);
                   for (int i2=0;i2<proyectosS.size();i2++){
                       if (proyectosS.get(i2).getNombre().equals(nombreProy)){
                           pCambio=proyectosS.get(i2);
                       }
                   }
                   menuActividad(pCambio, usuarioActual, usuarios);
               }else if(opcionesConsolaS2.equals("4")){
                   
                  Scanner proyectoACambiar= new Scanner(System.in);
                  System.out.println("Por favor ingrese el nombre del proyecto al cual pertence el usuario del que desea conocer el reporte: ");
                  String nombreProy=proyectoACambiar.nextLine();
                  proyecto pCambio= new proyecto("","", "","", null);
                  for (int i2=0;i2<proyectosS.size();i2++){
                          if (proyectosS.get(i2).getNombre().equals(nombreProy)){
                              pCambio=proyectosS.get(i2);
                          }
                      }
                  reporteParticipante(pCambio);
                  }
               }
	           }
	           }
	           public void creacionProyecto(ArrayList<Participante> usuarios, String usuarioActual,ArrayList<proyecto> proyectosS) throws ParseException, IOException{
	               String currentDirectory = new File("").getAbsolutePath();
	               String nombreProyecto="";
	               boolean directorioComparar=false;
	               while (directorioComparar==false){
	                   Scanner myObj = new Scanner(System.in); 
	                   System.out.println("Por favor Ingrese el nombre del proyecto a crear: ");
	                   String proy=myObj.nextLine();
	                   File dir=new File(currentDirectory+"//src//"+proy);
	                   if(dir.exists()){
	                       System.out.println("Ya existe un proyecto con el nombre ingresado");
	                   }else{
	                       dir.mkdir();
	                       nombreProyecto=proy;
	                       directorioComparar=true;
	              }
	               }
	               String nombre="";
	               String contrasena="";
	               String correo="";
	               for (int i=0;i<usuarios.size();i++){
	                   if (usuarios.get(i).getUserName().equals(usuarioActual)){
	                       nombre=usuarios.get(i).getNombre();
	                       contrasena=usuarios.get(i).getContraseña();
	                       correo=usuarios.get(i).getCorreo();
	                   }
	               }
	               Scanner myObj = new Scanner(System.in); 
	               System.out.println("Descripción del proyecto: ");
	               String descripcion=myObj.nextLine();
	               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	               LocalDateTime now = LocalDateTime.now(); 
	               Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(dtf.format(now));
	               String fechaInicio=dtf.format(now);
	               String fechaFinalizacion="";
	               Scanner myObj1 = new Scanner(System.in); 
	               System.out.println("Para la fecha de finalización");
	               System.out.println("Marque 1 si tiene un estimado, de lo contrario, marque 2");
	               String opcion=myObj1.nextLine();
	               if (opcion.equals("1")){
	                   Scanner myObj2 = new Scanner(System.in);
	                   System.out.println("Escriba la fecha de finalización estimada en formato dia-mes-año");
	                   fechaFinalizacion=myObj2.nextLine();
	               }else{
	                   fechaFinalizacion="00-00-0000";
	               }
	               proyectosS.add(new proyecto(nombreProyecto, descripcion, fechaInicio, fechaFinalizacion,new Participante(usuarioActual, correo, nombre, contrasena)));
	               FileWriter csvWriter;
	               csvWriter = new FileWriter(currentDirectory +"//src//datosProyectos.csv//");
	               for (proyecto rowData : proyectosS) {
	                               csvWriter.append(String.join(",", rowData.getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getFechaInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getFechaFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getUserName()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Nuevo proyecto creado con exito"); 
	               csvWriter = new FileWriter(currentDirectory +"//src////"+nombreProyecto+"//Participantes.csv//");
	               csvWriter.append(String.join(",",usuarioActual+","));
	               csvWriter.append(String.join(",",correo+","));
	               csvWriter.append(String.join(",",contrasena+","));
	               csvWriter.append(String.join(",",nombre));
	               csvWriter.append("\n");
	               csvWriter.flush();
	               csvWriter.close();
	               csvWriter = new FileWriter(currentDirectory +"//src////"+nombreProyecto+"//Actividades.csv//");
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0,"));
	               csvWriter.append(String.join(",","0"));
	               csvWriter.append("\n");
	               csvWriter.flush();
	               csvWriter.close();
	           }
	           public void modificarDatosProyecto(proyecto pCambio, ArrayList<proyecto> proyectosS, ArrayList<Participante> usuarios) throws IOException{
	               int indice=0;
	               for (int i=0;i<proyectosS.size();i++){
	                   if (proyectosS.get(i).getNombre().equals(pCambio.getNombre())){
	                       indice=i;
	                   }
	               }
	               boolean opcionesBoolean=false;
	               while (opcionesBoolean==false){
	                   Scanner opcionesScanner= new Scanner(System.in);
	                   System.out.println("----Modificar Datos Del Proyecto----");
	                   System.out.println("1.Modificar la descripción");
	                   System.out.println("2.Modificar la Fecha de inicio");
	                   System.out.println("3.Modificar la Fecha de finalización");
	                   System.out.println("4.Modificar la participante líder");
	                   System.out.println("5.Salir");
	                   System.out.println("Ingrese la opción que desee: ");
	                   String opciones=opcionesScanner.nextLine();
	                   if (opciones.equals("1")){
	                       Scanner nuevaDescripcion=new Scanner(System.in);
	                       System.out.println("Ingrese nueva descripción, por favor evite usar comas: ");
	                       String newDescription=nuevaDescripcion.nextLine();
	                       proyectosS.get(indice).setDescripcion(newDescription);
	                   }else if (opciones.equals("2")){
	                       Scanner newFechaInicio=new Scanner(System.in);
	                       System.out.println("Escriba la nueva fecha de inicio con formato dia-mes-año: ");
	                       String nuevaFechaInicio=newFechaInicio.nextLine();
	                       proyectosS.get(indice).setFechaInicio(nuevaFechaInicio);
	                   }else if (opciones.equals("3")){
	                       Scanner newFechaFinal=new Scanner(System.in);
	                       System.out.println("Escriba la nueva fecha de finalización con formato dia-mes-año: ");
	                       String nuevaFechaFinal=newFechaFinal.nextLine();
	                       proyectosS.get(indice).setFechaFin(nuevaFechaFinal);
	                   }else if (opciones.equals("5")){
	                       opcionesBoolean=true;
	                   }
	                   else{
	                       ArrayList<String> usuariosTotales=new ArrayList<>();
	                       for (int i=0;i<usuarios.size();i++){
	                           usuariosTotales.add(usuarios.get(i).getUserName());
	                       }
	                       Scanner nombreUsuarioRegistro= new Scanner(System.in);
	                       System.out.println("Ingrese el nombre de usuario deseado: ");
	                       String usuarioCompararRegistro= nombreUsuarioRegistro.nextLine();
	                       if (usuariosTotales.contains(usuarioCompararRegistro)){
	                           int indice2=0;
	                           for (int i=0;i<usuariosTotales.size();i++){
	                               if (usuariosTotales.get(i).equals(usuarioCompararRegistro)){
	                                   indice2=i;
	                               }
	                           }
	                           proyectosS.get(indice).setParticipanteJefe(new Participante( usuarios.get(indice2).getCorreo(),usuarios.get(indice2).getContraseña(),usuarios.get(indice2).getNombre(),usuarioCompararRegistro));
	                       }else{
	                           System.out.println("El usuario no existe, por favor intente de nuevo");
	                       }
	                   }
	               }
	               String currentDirectory = new File("").getAbsolutePath();
	               FileWriter csvWriter;
	               csvWriter = new FileWriter(currentDirectory +"//src//datosProyectos.csv//");
	               for (proyecto rowData : proyectosS) {
	                               csvWriter.append(String.join(",", rowData.getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getFechaInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getFechaFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipanteJefe().getUserName()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Modificaciones Realizadas con exito"); 
	           }
	           public void agregarParticipantes(proyecto pCambio, ArrayList<Participante> usuarios) throws FileNotFoundException, IOException{
	               ArrayList<Participante> participantesProyecto=new ArrayList<>();
	               boolean opcionesBoolean=false;
	               while (opcionesBoolean==false){
	                   Scanner opcionesScanner= new Scanner(System.in);
	                   System.out.println("----Agregar participante----");
	                   System.out.println("1.Agregar participante");
	                   System.out.println("2.Salir");
	                   System.out.println("Ingrese la opción que desee: ");
	                   String opciones=opcionesScanner.nextLine();
	                   if (opciones.equals("1")){
	                       ArrayList<String> usuariosTotales=new ArrayList<>();
	                       for (int i=0;i<usuarios.size();i++){
	                           usuariosTotales.add(usuarios.get(i).getUserName());
	                       }
	                       Scanner nombreUsuarioRegistro= new Scanner(System.in);
	                       System.out.println("Ingrese el nombre de usuario deseado: ");
	                       String usuarioCompararRegistro= nombreUsuarioRegistro.nextLine();
	                       if (usuariosTotales.contains(usuarioCompararRegistro)){
	                           int indice2=0;
	                           for (int i=0;i<usuariosTotales.size();i++){
	                               if (usuariosTotales.get(i).equals(usuarioCompararRegistro)){
	                                   indice2=i;
	                               }
	                           }
	                           participantesProyecto.add(new Participante(usuarios.get(indice2).getCorreo(),usuarios.get(indice2).getContraseña(),usuarios.get(indice2).getNombre(),usuarioCompararRegistro));
	                   }else{
	                           System.out.println("Usuario erróneo");
	                       }
	                   
	               }else{
	                       opcionesBoolean=true;
	                   }
	               }
	               String currentDirectory = new File("").getAbsolutePath();
	               try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//Participantes.csv//"))) {
	               String line;
	               while ((line = br.readLine()) != null) {
	                   String[] values = line.split(",");
	                   participantesProyecto.add(new Participante(values[0], values[1], values[3],values[2]));
	               }
	               }
	               FileWriter csvWriter;
	               csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Participantes.csv//");
	                           for (Participante rowData : participantesProyecto) {
	                               csvWriter.append(String.join(",", rowData.getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getNombre()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Participantes agregados");    
	           }
	           public void menuActividad(proyecto pCambio,String usuarioActual,ArrayList<Participante> usuarios) throws IOException{
	               boolean opcionesBoolean=false;
	               while (opcionesBoolean==false){
	                   Scanner opcionesScanner= new Scanner(System.in);
	                   System.out.println("----MENÚ DE ACTIVIDAD----");
	                   System.out.println("1.Agregar Actividad");
	                   System.out.println("2.Modificar Actividad");
	                   System.out.println("3.Salir");
	                   System.out.println("Digite la opción a realizar: ");
	                   String opciones=opcionesScanner.nextLine();
	                   if (opciones.equals("1")){
	                       agregarActividad(pCambio, usuarioActual,usuarios);
	                       
	                   }else if (opciones.equals("3")){
	                       opcionesBoolean=true;
	                   }else{
	                        if (pCambio.getParticipanteJefe().getUserName().equals(usuarioActual)){
	                            modificarDatosActividad(usuarioActual, pCambio, usuarios);
	                        }else{
	                            System.out.println("Solo el líder del proyecto puede hacer los cambios");
	                        }
	                   }
	               }
	           }
	           public void agregarActividad(proyecto pCambio,String usuarioActual,ArrayList<Participante> usuarios) throws FileNotFoundException, IOException{
	               ArrayList<RegistroActividad> listaActividades=new ArrayList<>();
	               ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	               String currentDirectory = new File("").getAbsolutePath();
	               try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//"))) {
	               String line;
	               while ((line = br.readLine()) != null) {
	                   String[] values = line.split(",");
	                   int id=Integer.parseInt(values[1]);
	                   listaActividades.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line));
	               }
	           }
	               String correoU="";
	               String contrasena="";
	               String nombreU="";
	               for (int i=0;i<usuarios.size();i++){
	                   if (usuarioActual.equals(usuarios.get(i).getUserName())){
	                       correoU=usuarios.get(i).getCorreo();
	                       contrasena=usuarios.get(i).getContraseña();
	                       nombreU=usuarios.get(i).getNombre();
	                   }
	               }
	               Tiempo ch = new Tiempo();
	               double tiempoContado=0;
	               boolean tiempoActividad=false;
	               String horaInicio=String.valueOf(LocalDateTime.now().getHour());
	               String minutosInicio=String.valueOf(LocalDateTime.now().getMinute());
	               if (Integer.valueOf(minutosInicio)<10){
	                   minutosInicio="0"+minutosInicio;
	               }
	               String titulo="";
	               String descripcion="";
	               String tipo="";
	               String fechaRealizacion="";
	               while (tiempoActividad==false){
	                   ch.start();
	                   Scanner opcionesScanner= new Scanner(System.in);
	                   Scanner newTitle= new Scanner(System.in);
	                   System.out.println("Escriba el título de la actividad: ");
	                   titulo=newTitle.nextLine();
	                   System.out.println("Escriba pausa para que el cronómetro se detenga y continue para que se resuma (SOLO SI ESTA DETENIDO) y si no se encuentra en ninguno de estos casos solo presione enter: ");
	                   String tiempo2=opcionesScanner.nextLine();
	                   if (tiempo2.equals("pausa")){
	                       ch.stop();
	                       tiempoContado=tiempoContado+ch.getTime();
	                   }else if (tiempo2.equals("continue")){
	                       ch.start();
	                   }
	                   Scanner newDescription= new Scanner(System.in);
	                   System.out.println("Escriba la descripción de la actividad sin comas: ");
	                   descripcion=newDescription.nextLine();
	                   System.out.println("Escriba pausa para que el cronómetro se detenga y continue para que se resuma (SOLO SI ESTA DETENIDO) y si no se encuentra en ninguno de estos casos solo presione enter: ");
	                   String tiempo3=opcionesScanner.nextLine();
	                   if (tiempo3.equals("pausa")){
	                       ch.stop();
	                       tiempoContado=tiempoContado+ch.getTime();
	                   }else if (tiempo3.equals("continue")){
	                       ch.start();
	                   }
	                   Scanner newTipe= new Scanner(System.in);
	                   System.out.println("Escriba el tipo de actividad: ");
	                   tipo=newTipe.nextLine();
	                   System.out.println("Escriba pausa para que el cronómetro se detenga y continue para que se resuma (SOLO SI ESTA DETENIDO) y si no se encuentra en ninguno de estos casos solo presione enter: ");
	                   String tiempo4=opcionesScanner.nextLine();
	                   if (tiempo4.equals("pausa")){
	                       ch.stop();
	                       tiempoContado=tiempoContado+ch.getTime();
	                   }else if (tiempo4.equals("continue")){
	                       ch.start();
	                   }
	                   Scanner newFechaR= new Scanner(System.in);
	                   System.out.println("Escriba la fecha de realización de la actividad con formato dd-MM-yyyy: ");
	                   fechaRealizacion=newFechaR.nextLine();
	                   System.out.println("Escriba pausa para que el cronómetro se detenga y continue para que se resuma (SOLO SI ESTA DETENIDO) y si no se encuentra en ninguno de estos casos solo presione enter: ");
	                   String tiempo5=opcionesScanner.nextLine();
	                   if (tiempo5.equals("pausa")){
	                       ch.stop();
	                       tiempoContado=tiempoContado+ch.getTime();
	                   }else if (tiempo5.equals("continue")){
	                       ch.start();
	                   }
	                   tiempoContado = Math.abs(tiempoContado+ch.getTime());
	                   tiempoActividad=true;
	               }
	               String tiempoContadoRevision=String.valueOf(tiempoContado);
	               String tiempoTotal="";
	               if (tiempoContadoRevision.contains("E")){
	                   String[] valor = tiempoContadoRevision.split("E");
	                   tiempoTotal=valor[0];
	               }else{
	                   tiempoTotal=tiempoContadoRevision;
	               }
	               String horaFinal=String.valueOf(LocalDateTime.now().getHour());
	               String minutoFinal=String.valueOf(LocalDateTime.now().getMinute());
	               if (Integer.valueOf(minutoFinal)<10){
	                   minutoFinal="0"+minutoFinal;
	               }
	               int min=0;
	               int max=1000000;
	               int id = (int)(Math.random()*(max-min+1)+min);  
	               listaActividades.add(new RegistroActividad(id, titulo, descripcion,tipo,fechaRealizacion,horaInicio+":"+minutosInicio,horaFinal+":"+minutoFinal,new Participante(usuarioActual,correoU,contrasena,nombreU), minutoFinal));
	               FileWriter csvWriter;
	               csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad realizada con éxito.");
	               try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+usuarioActual+".csv//"))) {
	               String line;
	               while ((line = br.readLine()) != null) {
	                   String[] values = line.split(",");
	                   int id2=Integer.parseInt(values[1]);
	                   listaActividadesUsuario.add(new RegistroActividad(id2, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line));
	               }
	               }catch(IOException ex){
	                   try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src////base_usuarios_actividades.csv//"))) {
	                   String line;
	               while ((line = br.readLine()) != null) {
	                   String[] values = line.split(",");
	                   int id2=Integer.parseInt(values[1]);
	                   listaActividadesUsuario.add(new RegistroActividad(id2, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line));
	               }
	               }
	               
	           }
	           listaActividadesUsuario.add(new RegistroActividad(id, titulo, descripcion,tipo,fechaRealizacion,horaInicio+":"+minutosInicio,horaFinal+":"+minutoFinal,new Participante(usuarioActual,correoU,contrasena,nombreU), minutoFinal));
	           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+usuarioActual+".csv//");
	               for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close(); 
	       }
	           public void modificarDatosActividad(String usuarioActual,proyecto pCambio, ArrayList<Participante> usuarios) throws FileNotFoundException, IOException{
	               ArrayList<RegistroActividad> listaActividades=new ArrayList<>();
	               String currentDirectory = new File("").getAbsolutePath();
	               try (BufferedReader br = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//"))) {
	               String line;
	               while ((line = br.readLine()) != null) {
	                   String[] values = line.split(",");
	                   int id=Integer.parseInt(values[1]);
	                   listaActividades.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line));
	               }
	               ArrayList<Participante> participantesProyecto=new ArrayList<>();
	               try (BufferedReader br1 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//Participantes.csv//"))) {
	               String line1;
	               while ((line1 = br1.readLine()) != null) {
	                   String[] values = line1.split(",");
	                   participantesProyecto.add(new Participante(values[0], values[1],values[2], values[3]));
	               }
	               boolean opcionesBoolean=false;
	               while (opcionesBoolean==false){
	                   Scanner opcionesScanner= new Scanner(System.in);
	                   System.out.println("----MODIFICAR ACTIVIDAD----");
	                   System.out.println("1.Modificar fecha realizacion");
	                   System.out.println("2.Modificar Titulo");
	                   System.out.println("3.Modificar Descripción");
	                   System.out.println("4.Hora de inicio");
	                   System.out.println("5.Hora de finalización");
	                   System.out.println("6.Participante que la realizó");
	                   System.out.println("7.Salir");
	                   System.out.println("Digite la opción a realizar: ");
	                   String opciones=opcionesScanner.nextLine();
	                   if (opciones.equals("1")){
	                       Scanner idActividad= new Scanner(System.in);
	                       System.out.println("Escriba el id de la actividad a modificar, si no lo sabe puede colocar el título pero considere que puede haber dos actividades con el mismo nombre: ");
	                       String idA=idActividad.nextLine();
	                       int indiceActividad=0;
	                       try {  
	                               int idBuscar=Integer.parseInt(idA);
	                                for (int i=0;i<listaActividades.size();i++){
	                                   if (idBuscar==listaActividades.get(i).getId()){
	                                       indiceActividad=i;
	                               }
	                               }
	                        }catch(NumberFormatException e){  
	                            String busqueda=idA;
	                            for (int i=0;i<listaActividades.size();i++){
	                                if (busqueda.equals(listaActividades.get(i).getTitulo())){
	                                indiceActividad=i;
	                                }
	                       }
	                       }
	                       Scanner newFecha= new Scanner(System.in);
	                       System.out.println("Escriba la nueva fecha de realización con formato dd-MM-yyyy: ");
	                       String nuevaFecha=newFecha.nextLine();
	                       listaActividades.get(indiceActividad).setFecha(nuevaFecha);
	                       String nombreUsuario=listaActividades.get(indiceActividad).getParticipante().getUserName();
	                       int idActividadUsuario=listaActividades.get(indiceActividad).getId();
	                       ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	                       try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line3));
	                       }
	                       }
	                       for (int i=0;i<listaActividadesUsuario.size();i++){
	                           if (String.valueOf(idActividadUsuario).equals(String.valueOf(listaActividadesUsuario.get(i).getId()))){
	                               listaActividadesUsuario.get(i).setFecha(nuevaFecha);
	                           }
	                       }
	                       
	                       FileWriter csvWriter;
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad modificada con éxito.");
	                       }else if (opciones.equals("2")){
	                       Scanner idActividad= new Scanner(System.in);
	                       System.out.println("Escriba el id de la actividad a modificar, si no lo sabe puede colocar el título pero considere que puede haber dos actividades con el mismo nombre: ");
	                       String idA=idActividad.nextLine();
	                       int indiceActividad=0;
	                       try {  
	                               int idBuscar=Integer.parseInt(idA);
	                                for (int i=0;i<listaActividades.size();i++){
	                                   if (idBuscar==listaActividades.get(i).getId()){
	                                       indiceActividad=i;
	                               }
	                               }
	                        }catch(NumberFormatException e){  
	                            String busqueda=idA;
	                            for (int i=0;i<listaActividades.size();i++){
	                                if (busqueda.equals(listaActividades.get(i).getTitulo())){
	                                    indiceActividad=i;
	                                }
	                       }
	                       }
	                       Scanner newTitle= new Scanner(System.in);
	                       System.out.println("Escriba el nuevo título: ");
	                       String nuevoTitulo=newTitle.nextLine();
	                       listaActividades.get(indiceActividad).setTitulo(nuevoTitulo);
	                       String nombreUsuario=listaActividades.get(indiceActividad).getParticipante().getUserName();
	                       int idActividadUsuario=listaActividades.get(indiceActividad).getId();
	                       ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	                       try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line3));
	                       }
	                       }
	                       for (int i=0;i<listaActividadesUsuario.size();i++){
	                           if (String.valueOf(idActividadUsuario).equals(String.valueOf(listaActividadesUsuario.get(i).getId()))){
	                               listaActividadesUsuario.get(i).setTitulo(nuevoTitulo);
	                           }
	                       }
	                       FileWriter csvWriter;
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad modificada con éxito.");
	                       }else if (opciones.equals("7")){
	                           opcionesBoolean=true;
	                       }else if (opciones.equals("3")){
	                           Scanner idActividad= new Scanner(System.in);
	                       System.out.println("Escriba el id de la actividad a modificar, si no lo sabe puede colocar el título pero considere que puede haber dos actividades con el mismo nombre: ");
	                       String idA=idActividad.nextLine();
	                       int indiceActividad=0;
	                       try {  
	                               int idBuscar=Integer.parseInt(idA);
	                                for (int i=0;i<listaActividades.size();i++){
	                                   if (idBuscar==listaActividades.get(i).getId()){
	                                       indiceActividad=i;
	                               }
	                               }
	                        }catch(NumberFormatException e){  
	                            String busqueda=idA;
	                            for (int i=0;i<listaActividades.size();i++){
	                                if (busqueda.equals(listaActividades.get(i).getTitulo())){
	                                    indiceActividad=i;
	                                }
	                       }
	                       }
	                       Scanner newDescription= new Scanner(System.in);
	                       System.out.println("Escriba una nueva descripcion: ");
	                       String nuevaDescripcion=newDescription.nextLine();
	                       listaActividades.get(indiceActividad).setDescripcion(nuevaDescripcion);
	                       String nombreUsuario=listaActividades.get(indiceActividad).getParticipante().getUserName();
	                       int idActividadUsuario=listaActividades.get(indiceActividad).getId();
	                       ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	                       try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line3));
	                       }
	                       }
	                       for (int i=0;i<listaActividadesUsuario.size();i++){
	                           if (String.valueOf(idActividadUsuario).equals(String.valueOf(listaActividadesUsuario.get(i).getId()))){
	                               listaActividadesUsuario.get(i).setDescripcion(nuevaDescripcion);
	                           }
	                       }
	                       FileWriter csvWriter;
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad modificada con éxito.");
	                           
	                       }else if(opciones.equals("4")){
	                           Scanner idActividad= new Scanner(System.in);
	                       System.out.println("Escriba el id de la actividad a modificar, si no lo sabe puede colocar el título pero considere que puede haber dos actividades con el mismo nombre: ");
	                       String idA=idActividad.nextLine();
	                       int indiceActividad=0;
	                       try {  
	                               int idBuscar=Integer.parseInt(idA);
	                                for (int i=0;i<listaActividades.size();i++){
	                                   if (idBuscar==listaActividades.get(i).getId()){
	                                       indiceActividad=i;
	                               }
	                               }
	                        }catch(NumberFormatException e){  
	                            String busqueda=idA;
	                            for (int i=0;i<listaActividades.size();i++){
	                                if (busqueda.equals(listaActividades.get(i).getTitulo())){
	                                    indiceActividad=i;
	                                }
	                       }
	                       }
	                       Scanner newHoraI= new Scanner(System.in);
	                       System.out.println("Escriba la nueva hora de inicio con formato HH:mm y 24 horas: ");
	                       String nuevaHoraInicio=newHoraI.nextLine();
	                       listaActividades.get(indiceActividad).setHoraInicio(nuevaHoraInicio);
	                       String nombreUsuario=listaActividades.get(indiceActividad).getParticipante().getUserName();
	                       int idActividadUsuario=listaActividades.get(indiceActividad).getId();
	                       ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	                       try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line3));
	                       }
	                       }
	                       for (int i=0;i<listaActividadesUsuario.size();i++){
	                           if (String.valueOf(idActividadUsuario).equals(String.valueOf(listaActividadesUsuario.get(i).getId()))){
	                               listaActividadesUsuario.get(i).setHoraInicio(nuevaHoraInicio);
	                           }
	                       }
	                       FileWriter csvWriter;
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad modificada con éxito.");
	                       }else if (opciones.equals("5")){
	                       Scanner idActividad= new Scanner(System.in);
	                       System.out.println("Escriba el id de la actividad a modificar, si no lo sabe puede colocar el título pero considere que puede haber dos actividades con el mismo nombre: ");
	                       String idA=idActividad.nextLine();
	                       int indiceActividad=0;
	                       try {  
	                               int idBuscar=Integer.parseInt(idA);
	                                for (int i=0;i<listaActividades.size();i++){
	                                   if (idBuscar==listaActividades.get(i).getId()){
	                                       indiceActividad=i;
	                               }
	                               }
	                        }catch(NumberFormatException e){  
	                            String busqueda=idA;
	                            for (int i=0;i<listaActividades.size();i++){
	                                if (busqueda.equals(listaActividades.get(i).getTitulo())){
	                                    indiceActividad=i;
	                                }
	                       }
	                       }
	                       Scanner newHoraF= new Scanner(System.in);
	                       System.out.println("Escriba la nueva hora de finalización con formato HH:mm y 24 horas: ");
	                       String nuevaHoraFinal=newHoraF.nextLine();
	                       listaActividades.get(indiceActividad).setHoraFin(nuevaHoraFinal);
	                       String nombreUsuario=listaActividades.get(indiceActividad).getParticipante().getUserName();
	                       int idActividadUsuario=listaActividades.get(indiceActividad).getId();
	                       ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	                       try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line3));
	                       }
	                       }
	                       for (int i=0;i<listaActividadesUsuario.size();i++){
	                           if (String.valueOf(idActividadUsuario).equals(String.valueOf(listaActividadesUsuario.get(i).getId()))){
	                               listaActividadesUsuario.get(i).setHoraFin(nuevaHoraFinal);
	                           }
	                       }
	                       FileWriter csvWriter;
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+nombreUsuario+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad modificada con éxito.");
	                       }else{
	                       Scanner idActividad= new Scanner(System.in);
	                       System.out.println("Escriba el id de la actividad a modificar, si no lo sabe puede colocar el título pero considere que puede haber dos actividades con el mismo nombre: ");
	                       String idA=idActividad.nextLine();
	                       int indiceActividad=0;
	                       try {  
	                               int idBuscar=Integer.parseInt(idA);
	                                for (int i=0;i<listaActividades.size();i++){
	                                   if (idBuscar==listaActividades.get(i).getId()){
	                                       indiceActividad=i;
	                               }
	                               }
	                        }catch(NumberFormatException e){  
	                            String busqueda=idA;
	                            for (int i=0;i<listaActividades.size();i++){
	                                if (busqueda.equals(listaActividades.get(i).getTitulo())){
	                                    indiceActividad=i;
	                                }
	                       }
	                       }
	                       Scanner newUser= new Scanner(System.in);
	                       System.out.println("Escriba el nombre de usuario de la persona al que desea atribuirle la actividad: ");
	                       String nuevoNombreUsuario=newUser.nextLine();
	                       Participante usuarioCambiar= new Participante(nuevoNombreUsuario, nuevoNombreUsuario, nuevoNombreUsuario, nuevoNombreUsuario);
	                       ArrayList<String> usuariosProyecto=new ArrayList<>();
	                       for (int i=0;i<participantesProyecto.size();i++){
	                           usuariosProyecto.add(participantesProyecto.get(i).getUserName());
	                       }
	                       if (usuariosProyecto.contains(nuevoNombreUsuario)){
	                           for (int i=0;i<participantesProyecto.size();i++){
	                               if (nuevoNombreUsuario.equals(participantesProyecto.get(i).getUserName())){
	                                   usuarioCambiar=participantesProyecto.get(i);
	                               }
	                           }
	                           String usuarioAnterior=listaActividades.get(indiceActividad).getParticipante().getUserName();
	                           listaActividades.get(indiceActividad).setParticipante(new Participante(usuarioCambiar.getUserName(),usuarioCambiar.getCorreo(),usuarioCambiar.getNombre(),usuarioCambiar.getContraseña()));
	                           int idActividadUsuario=listaActividades.get(indiceActividad).getId();
	                           ArrayList<RegistroActividad> listaActividadesUsuario=new ArrayList<>();
	                       try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+usuarioCambiar.getNombre()+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line3));
	                       }
	                       }
	                       listaActividadesUsuario.add(listaActividades.get(indiceActividad));
	                       FileWriter csvWriter;
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+usuarioCambiar.getUserName()+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close(); 
	                       ArrayList<RegistroActividad> listaActividadesUsuario2=new ArrayList<>();
	                       try (BufferedReader br4 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+usuarioAnterior+".csv//"))) {
	                       String line4;
	                       while ((line4 = br4.readLine()) != null) {
	                           String[] values = line4.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario2.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), line4));
	                       }
	                       }
	                       for (int i=0;i<listaActividadesUsuario2.size();i++){
	                           if (String.valueOf(idActividadUsuario).equals(String.valueOf(listaActividadesUsuario2.get(i).getId()))){
	                               listaActividadesUsuario2.remove(i);
	                           }
	                       }
	                       csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//"+usuarioAnterior+".csv//");
	                       for (RegistroActividad rowData : listaActividadesUsuario2) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();   
	                           csvWriter = new FileWriter(currentDirectory +"//src////"+pCambio.getNombre()+"//Actividades.csv//");
	               for (RegistroActividad rowData : listaActividades) {
	                               csvWriter.append(String.join(",", rowData.getTitulo()+","));
	                               csvWriter.append(String.join(",", rowData.getId()+","));
	                               csvWriter.append(String.join(",", rowData.getDescripcion()+","));
	                               csvWriter.append(String.join(",", rowData.getTipo()+","));
	                               csvWriter.append(String.join(",", rowData.getFecha()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraInicio()+","));
	                               csvWriter.append(String.join(",", rowData.getHoraFin()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getNombre()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getCorreo()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getContraseña()+","));
	                               csvWriter.append(String.join(",", rowData.getParticipante().getUserName()+","));
	                               csvWriter.append(String.join(",", rowData.getTiempoC()));
	                           csvWriter.append("\n");
	                           }
	                           csvWriter.flush();
	                           csvWriter.close();
	                           System.out.println("Actividad modificada con éxito.");
	                           
	                       }else{
	                           System.out.println("El participante no hace parte del proyecto, agreguelo");
	                       }
	                   
	                       }
	               }
	               }
	               }
	               
	           }
	           public void reporteParticipante(proyecto pCambio) throws FileNotFoundException, IOException{
	               Scanner usuarioBuscar= new Scanner(System.in);
	               System.out.println("Digite el nombre del usuario del que desea conocer el reporte: ");
	               String username=usuarioBuscar.nextLine();
	               System.out.println(pCambio.getNombre());
	               String currentDirectory = new File("").getAbsolutePath();
	               ArrayList<Participante> participantesProyecto=new ArrayList<>();
	               try (BufferedReader br1 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//Participantes.csv//"))) {
	               String line1;
	               while ((line1 = br1.readLine()) != null) {
	                   String[] values = line1.split(",");
	                   participantesProyecto.add(new Participante(values[0], values[1],values[2], values[3]));
	               }
	               
	           }
	           ArrayList<String> usuariosProyecto=new ArrayList<>();
	           for (int i=0;i<participantesProyecto.size();i++){
	               usuariosProyecto.add(participantesProyecto.get(i).getUserName());
	               }
	               if (usuariosProyecto.contains(username)){
	                   ArrayList<RegistroActividad> listaActividadesUsuario = new ArrayList<>();
	                   try (BufferedReader br3 = new BufferedReader(new FileReader(currentDirectory +"//src////"+pCambio.getNombre()+"//"+username+".csv//"))) {
	                       String line3;
	                       while ((line3 = br3.readLine()) != null) {
	                           String[] values = line3.split(",");
	                           int id=Integer.parseInt(values[1]);
	                           listaActividadesUsuario.add(new RegistroActividad(id, values[0], values[2], values[3], values[4], values[5],values[6], new Participante(values[7],values[8], values[9],values[10]), values[11]));
	                       }
	                       }
	                   HashMap<String,ArrayList<Double>> tiempoPromedioActividad = new HashMap<>();
	                   for (int i=0;i<listaActividadesUsuario.size();i++){
	                       tiempoPromedioActividad.put(listaActividadesUsuario.get(i).getTipo(),new ArrayList<>());
	                   }
	                   for (int i=0;i<listaActividadesUsuario.size();i++){
	                       double d1=Double.parseDouble(listaActividadesUsuario.get(i).getTiempoC());
	                       tiempoPromedioActividad.get(listaActividadesUsuario.get(i).getTipo()).add(d1);
	                   }
	                   ArrayList<String> llaves=new ArrayList();
	                   for (String key: tiempoPromedioActividad.keySet()){
	                       llaves.add(key);
	                   }
	                   Tiempo ch=new Tiempo();
	                   HashMap<String, Double> tiempoActividad= new HashMap<>();
	                   for (int i=0;i<llaves.size();i++){
	                       double sum = tiempoPromedioActividad.get(llaves.get(i)).stream().mapToDouble(Double::intValue).sum();
	                       double valor=sum/tiempoPromedioActividad.get(llaves.get(i)).size();
	                       tiempoActividad.put(llaves.get(i),ch.getMinutes(valor));
	                       
	                   }
	                   for (int i=0;i<llaves.size();i++){
	                       if (llaves.get(i).equals("0")){ 
	                       }else{
	                           System.out.println("----TIEMPO PROMEDIO POR TIPO DE ACTIVIDAD----");
	                           System.out.println("TIPO: "+llaves.get(i));
	                           System.out.println("TIEMPO PROMEDIO EN MINUTOS: "+tiempoActividad.get(llaves.get(i)));
	                       }
	                   }
	                   HashMap<String,ArrayList<Double>> diasListasValores= new HashMap<>();
	                   diasListasValores.put("MONDAY",new ArrayList<>());
	                   diasListasValores.put("TUESDAY",new ArrayList<>());
	                   diasListasValores.put("WEDNESDAY",new ArrayList<>());
	                   diasListasValores.put("THURSDAY",new ArrayList<>());
	                   diasListasValores.put("FRIDAY",new ArrayList<>());
	                   diasListasValores.put("SATURDAY",new ArrayList<>());
	                   diasListasValores.put("SUNDAY",new ArrayList<>());
	                   for (int i=0;i<listaActividadesUsuario.size();i++){
	                       if (listaActividadesUsuario.get(i).getFecha().equals("0")){
	                           
	                       }else{
	                       String values[]=listaActividadesUsuario.get(i).getFecha().split("-");
	                       LocalDate localDate = LocalDate.of(Integer.parseInt(values[2]), Integer.parseInt(values[1]), Integer.parseInt(values[0]));
	                       java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
	                       String dia=dayOfWeek.toString();
	                       diasListasValores.get(dia).add(Double.parseDouble(listaActividadesUsuario.get(i).getTiempoC()));
	                           
	                       }
	                       
	                   }
	                   ArrayList<String> llavesDias=new ArrayList();
	                   for (String key: diasListasValores.keySet()){
	                       llavesDias.add(key);
	                   }
	                   HashMap<String, Double> tiempoDias= new HashMap<>();
	                   for (int i=0;i<llavesDias.size();i++){
	                       double sum = diasListasValores.get(llavesDias.get(i)).stream().mapToDouble(Double::intValue).sum();
	                       double valor=sum/diasListasValores.get(llavesDias.get(i)).size();
	                       tiempoDias.put(llavesDias.get(i),ch.getMinutes(valor)); 
	                   }
	                   for (int i=0;i<llavesDias.size();i++){
	                           System.out.println("----TIEMPO PROMEDIO POR DIA----");
	                           System.out.println("DIA: "+llavesDias.get(i));
	                           System.out.println("TIEMPO PROMEDIO EN MINUTOS: "+tiempoDias.get(llavesDias.get(i)));
	                   }
	                   ArrayList<Double> tiempoTotalA=new ArrayList<>();
	                   for (int i=0;i<listaActividadesUsuario.size();i++){
	                       tiempoTotalA.add(Double.valueOf(listaActividadesUsuario.get(i).getTiempoC()));
	                   }
	                   double tiempoInvertido=tiempoTotalA.stream().mapToDouble(Double::intValue).sum();
	                   double minutosTotalesInvertidos=ch.getMinutes(tiempoInvertido);
	                   System.out.println("----TIEMPO TOTAL INVERTIDO----");
	                   System.out.println("TIEMPO TOTAL INVERTIDO EN MINUTOS: "+minutosTotalesInvertidos);
	                   System.out.println("----CANTIDAD DE ACTIVIDADES REALIZADAS----");
	                   System.out.println("CANTIDAD: "+String.valueOf(listaActividadesUsuario.size()-1));
	                   
	           }else{
	                System.out.println("El participante no pertence al proyecto.");
	               }
	           }
 }
	           
