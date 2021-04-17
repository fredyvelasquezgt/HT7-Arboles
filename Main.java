//Cuidado con el packaet

//Importo lo que voy a usar



//Fredy Velasquez
//201011
//16-04-2021



import java.util.Scanner;
import java.io.File;
//Clase que maneja todo
public class Main {
	
	
	
    
    
	        Scanner entrada = new Scanner(System.in); //Creo mi scanner
			
			try { //aqui leo mi archivo
            File myObj = new File("diccionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] temp = data.split(",");
                Datos dt = new Datos(temp); //manejo las assiacionts
                ComparableAssociation ingl = new ComparableAssociation(temp[0],dt);
                ComparableAssociation espa = new ComparableAssociation(temp[1],dt);
                ComparableAssociation fran = new ComparableAssociation(temp[2],dt);
				
				
				
				//Manejo de idiomas
                bstig.add(ingl); //ingles
                bstes.add(espa);  //espaol
                bstfr.add(fran); //frances
            }
            myReader.close();
        }catch (Exception e) { //sino encuentro el archivo
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
			

	
	//Me ayudan a manejar los menus
    static int opcion1;
    static int opcion2;
	
	//Creo los arboles
	static BinarySearchTree bstfr = new BinarySearchTree(); //frances
    static BinarySearchTree bstig = new BinarySearchTree(); //ingles
	static BinarySearchTree bstes = new BinarySearchTree(); //espanol
	
    public static void main(String[] args) {



        
		
		//Imprimo lo que corresponda - formato
        System.out.println("Print traducciones");
        System.out.println("-----------------------------------");
        bstig.iterator(); //mi iterador de antes
        System.out.println("-----------------------------------");


		//menu para los idiomas - 
        System.out.println("Ingrese que Idioma es el Texto");
        System.out.println("1. Ingles");
        System.out.println("2. Espanol"); //opciones
        System.out.println("3. Frances");
        opcion1 = entrada.nextInt();
		
		///Aquui manejo la entrada de las opciones
    public static void translate(String oracion){
        String[] No_traducido = oracion.split(" ");
        StringBuilder res = new StringBuilder();
        if(opcion1 == 1){ //opcion 1
            manejoP(No_traducido, res, bstig);
        }else if (opcion1 == 2){ //opcion 2
            manejoP(No_traducido, res, bstes);
        }
        else if (opcion1 == 3){ //opcion 3
            manejoP(No_traducido, res, bstfr);
        }
        System.out.println(res);
    }
		
		//Voy manejando todos los casos segun el usuario decida
		
        if(opcion1 == 1){  //Caso de seleccion
            System.out.println("Ingrese que Idioma desea de salida");
            System.out.println("2. Espanol");
            System.out.println("3. Frances");
            opcion2 = entrada.nextInt(); //guardo
        }
        else if(opcion1 == 2){  //Caso de seleccion
            System.out.println("Ingrese que Idioma desea de salida");
            System.out.println("1. Ingles");
            System.out.println("3. Frances");
            opcion2 = entrada.nextInt(); //guardo
        } else if(opcion1 == 3){  //Caso de seleccion
            System.out.println("Ingrese que Idioma desea de salida");
            System.out.println("1. Ingles");
            System.out.println("2. Espanol");
            opcion2 = entrada.nextInt();  //guardo
        }

        try { //manejo el texto del ejemplo de la hoja
            File myObj = new File("texto.txt");
            Scanner myReader = new Scanner(myObj); 
            while (myReader.hasNextLine()) { //verifico
                String data = myReader.nextLine();
                String[] temp = data.split("\\."); //separo qui
                for (String s : temp) {
                    translate(s);
                }
            }
            myReader.close(); //cierto
        }catch (Exception e) {
			
			
			//en caso de no encontrar
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }

    }


	
	
	
	
	//le paso lo necesario
    private static void manejoP(String[] no_traducido, StringBuilder res, BinarySearchTree bstfr) {
        for (String s : no_traducido) { //for avanzado
		
			//crear
            ComparableAssociation top = new ComparableAssociation(s.toLowerCase()); //Creo nuevo obj
            if (bstfr.contains(top)) {
				//guardo
                BinaryTree dato = bstfr.locate(bstfr.root,top);
                ComparableAssociation temp = (ComparableAssociation) dato.getValor(); //Traigo associantion
                Datos dt =(Datos) temp.getValor();
                res.append(dt.getD(opcion2));
                res.append(" ");//doy formato
            }else{  //en caso de que no
                res.append("*").append(s).append("*"); //Voy dando formato
                res.append(" ");
            }
        }
    }
} //cierro