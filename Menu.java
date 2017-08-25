/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_snake;

/**
 *
 * @author Juan RigobertoZuñiga
 */
import java.util.Scanner;
public class Menu {
    Scanner in=new Scanner(System.in);  
    int opcion,tama,tama1,table,cuerpo[][]=new int[300][2],n=1,x,y,mitad,tct,puntos=0;
    int cont=1,a=0,b=0;
    String nombre;
    String movimiento;
    String tablero[][]; 
    String historia[]=new String[5];
    String jugadores[]=new String[5];
    String cualquiera;
    public int arriba=3;  
    public void menu(){
        borrar();
        Inicio();
        switch(opcion){
            case 1: 
                iniciojuego();
                guardarposicion();
                comida();
                borrar();
                //movimientos
                while(tct!=5){ 
                   borrar();
                   juegotabla();
                   System.out.println("");
                   teclas(); 
                   guardarposicion();
                  try{
                       juegotabla();
                       
                   }
                   catch(ArrayIndexOutOfBoundsException e){
                       
                       gameover();
                       menu();
                   }
                           
                }
                if(cont==6){
                    cont=1;
                }else{historial();cont++;}
                //finmovimientos
                tct=1;
                 menu();
                break;
            case 2:
                animacion();
                System.out.println("\033[32m ingrese r para regresar al menu");
                cualquiera=in.next();
                if (("r".equals(cualquiera))||("R".equals(cualquiera))){
                menu();
                }
                break;
            case 3:
                historial();
                System.out.println("\033[32m ingrese r para regresar al menu");
                cualquiera=in.next();
                if (("r".equals(cualquiera))||("R".equals(cualquiera))){
                menu();
                }
                break;
            case 4:
                
                break;
                
        }    
    }
    public void juegotabla(){
        System.out.println("Nombre: "+nombre+"    Tama;o: "+tama);
        System.out.println("Puntaje: "+puntos);
        MostrarTablero();
        
        System.out.println("");   
    }
    public  void MostrarTablero(){
        System.out.print("  \t");
        for(int a=0; a<tablero.length; a++){
            if (a<10){
                if (a==9){
                System.out.print(" "+(a+1)+" ");
                } else {
                System.out.print(" "+(a+1)+"  ");
                }
            } else {
                System.out.print((a+1)+"  ");
            }
        }
        System.out.println();
        for (int x=0; x<tablero.length; x++){
            System.out.print((x+1)+" \t");
            for (int y=0; y<tablero.length; y++){
                if(tablero[x][y]!=null){                    
                }else{tablero[x][y]=" ";}
       
               
                if (x==cuerpo[n][1] && y==cuerpo[n][0]){
                    tablero[(cuerpo[n][1])][(cuerpo[n][0])]="?";
                    tablero[(cuerpo[n+1][1])][(cuerpo[n+1][0])]="?";
                    tablero[(cuerpo[n-1][1])][(cuerpo[n-1][0])]="?";
                    tablero[(cuerpo[n+2][1])][(cuerpo[n+2][0])]="?";
                    
                }else{tablero[(cuerpo[n][1])][(cuerpo[n][0])]=" ";}
                if(a==cuerpo[n][1] && b==cuerpo[n][0]){
                tama++;
                tablero[a][b]=" ";
                puntos++;
                comida();
                }
                
                System.out.print(tablero[x][y]);
                System.out.print("["+tablero[x][y]+"] ");
                
            }
            System.out.println();
            
        }
    }
    public void animacion(){
        System.out.println("============================================================");
        System.out.println("|  -----------|                                            |");
        System.out.println("|  |   =  =   |  NOMBRE:                                   |");
        System.out.println("|  |   O  O   |       Pedro Humberto Méndez Veláquez       |");
        System.out.println("|  |     >    |  UNIDAD ACADEMICA:                         |");
        System.out.println("|  |  &&&&&&  |       Ingenieria                           |");
        System.out.println("|  |   ----   |  CARRERA:                                  |");
        System.out.println("|  |          |       Ingenieria en Ciencias y Sistemas    |");
        System.out.println("|  ------------                                            |");
        System.out.println("|              UA: 8    EXT: 0  CARR:  9                   |");
        System.out.println("|                                                          |");
        System.out.println("|               CARNÉ:  201602946                          |");
        System.out.println("|    1111 11111111 111 111111 111111 1111 11111 1111111    |");
        System.out.println("|    1111 11111111 111 111111 111111 1111 11111 1111111    |");
        System.out.println("|    1111 11111111 111 111111 111111 1111 11111 1111111    |");
        System.out.println("|    1111 11111111 111 111111 111111 1111 11111 1111111    |");
        System.out.println("============================================================");
        
        
        
    }
    public void historial(){
        for (int i=1; i<=historia.length;i++){
        System.out.println(i+".  "+historia[i-1]);
        }
    }
    public void borrar(){
        for(int i=0;i<=60;i++){
            System.out.println("");
    }
    }
    public void iniciojuego(){
        n=1;
        x=0;
        y=0;
        mitad=0;
        tct=1;
        puntos=0;
        System.out.println("Ingrese nombre de usuario");
        nombre=in.next();        
        System.out.println("ingrese tama;o del tablero mayor a 10");
        table=in.nextInt();
        tablero=new String[(table+1)][(table+1)];
        mitad=table/2;
        x=mitad;
        y=mitad;
        //condicion tama;o de tablero mayor a 10
        while(table<10){
            System.out.println("ingrese tama;o de de tablero mayor a 10");
            table=in.nextInt();
            mitad=table/2;
            tablero=new String[(table+1)][(table+1)];
            x=mitad;
            y=mitad;
            }
            //fin condicion tama;o de mayor a 10
        System.out.println("Ingrese el tama;o de Snake deseado");
        tama1=in.nextInt();
        tama=tama1;
    }
    public void guardarposicion(){
        cuerpo[n][0]=x;
        cuerpo[n][1]=y;
        n++;
        if(n==(tama+1)) n=1;
    }
    public void comida(){
        a=(int)(Math.random()*table);
        b=(int)(Math.random()*table);
        tablero[a][b]="C";
    }
    public void teclas(){
        System.out.println("Ingrese su movimiento, W = Arriba, A = Izquierda, S = Abajo, D = Derecha, E = Salir ");
            movimiento=in.next();
            System.out.println(movimiento);
                   if ("w".equals(movimiento) || "W".equals(movimiento)){
                       tct=1;
                   }
                   if ("S".equals(movimiento) || "s".equals(movimiento)){
                       tct=2;
                   }
                   if ("A".equals(movimiento) || "a".equals(movimiento)){
                       tct=3;   
                   }
                   if ("d".equals(movimiento) || "D".equals(movimiento)){
                      tct=4;
                   }
                   if("e".equals(movimiento) || "E".equals(movimiento)){
                       for(int i=0;i<historia.length;i++){
            if(historia[i]!=null){
                
            }else {
                 historia[i]="JUGADOR: "+nombre+" PUNTEO: "+puntos+" TAMANIO TABLERO: "+table+" SNAKE INICIAL: "+tama;
                 i=historia.length;
            }
        }
                       tct=5;
                   }
                   if(tct==1){
                       if(tct!=2)y--;
                   }
                   if(tct==2){
                       if(tct!=1)y++;
                   }
                   if(tct==3){
                       if(tct!=4)x--;
                   }
                   if(tct==4){
                       if(tct!=3)x++;
                   }
                   //teclas        
    }
    public void Inicio(){
        System.out.println("\033[32m##################################");
        System.out.println("\033[32m###################################");
        System.out.println("###            Menu            ");
        System.out.println("\033[32m#####################################");
        System.out.println("###  1) Inicio del juego       ");
        System.out.println("\033[32m#######################################");
        System.out.println("###  2) Datos Estudiante       ");
        System.out.println("\033[32m#########################################");
        System.out.println("###  3) Historial de partidas  ");
        System.out.println("\033[32m###########################################");
        System.out.println("###  4) Salir                  ");
        System.out.println("\033[32m#############################################");
        System.out.println("\033[32m##############################################");
        System.out.println("# Seleccione el numero de la opcion deseada ");
        System.out.println("\033[32m################################################");
        opcion=in.nextInt();
        borrar();
    }
    /*public void imphisto(){
     for(int i=0;i<6;i++){   
            System.out.println(" ");
            for(int j=0;j<4;j++){
                 if(historia[i][j]!=null){                    
                }else{historia[i][j]=" ";}
                System.out.print(historia[i][j]);
            } 
        }
    }*/
    public void gameover(){
        borrar();
        for(int i=0;i<historia.length;i++){
            if(historia[i]!=null){
                
            }else {
                 historia[i]="JUGADOR: "+nombre+" PUNTEO: "+puntos+" TAMANIO TABLERO: "+table+" SNAKE INICIAL: "+tama1;
                 i=historia.length;
            }
        }
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@         GAME OVER :(         @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@                              @@");
        System.out.println("\033[33m@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("");
        System.out.println("ingese r para regresar al menu");
        cualquiera=in.next();
        System.out.println("\033[32m ingrese r para regresar al menu");
                cualquiera=in.next();
                if (("r".equals(cualquiera))||("R".equals(cualquiera))){
                menu();
                }
    }
}
