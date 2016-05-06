// PROBLEMA : De n ELEMENTOS ENTEROS POSITIVOS ORDENADOS (>0), ESCOGER
// k ELEMENTOS QUE  SUMEN UNA CANTIDAD c
// DESARROLLO DE ARBOL POR BACKTRACKING (EN PROFUNDIDAD)
// SIN NINGÚN TIPO DE PODA

public class HayQueMejorarEsto1
{

static int n;
static int[]v;     
static int k;
static int c;       
static boolean[]marca; // si se elige o no un elemento
static int s;          // suma acumulada hasta un estado 
static int escogidos;  // número elementos escoger
static boolean solucionEncontrada;

public static void main (String arg[])
{
n=Integer.parseInt(arg[0]);
k=Integer.parseInt(arg[1]);
c=Integer.parseInt(arg[2]); 
v = new int [n];

marca= new boolean [n];
for (int i=0;i<n;i++) v[i]=i+1;
for (int i=0;i<n;i++) marca[i]=false;
escogidos=0;
s=0;
solucionEncontrada=false;

long t1= System.currentTimeMillis(); 
backtracking (0);
long t2= System.currentTimeMillis();
System.out.println ("TIEMPO MILISEGUNDOS="+(t2-t1));
}


static void backtracking (int nivel)
{
if (nivel==n)  //hay ya un conjunto que analizar 
 { 
  if (escogidos==k && s==c)
  {
  solucionEncontrada=true; 
  System.out.println();
  System.out.println(k+" ELEMENTOS ESCOGIDOS QUE SUMAN="+c); 
  for (int i=0;i<n;i++)
     if (marca[i])  System.out.print(v[i]+"/");
  System.out.println();
  }
 }          
    
else
  for (int j=0;j<=1;j++)
    if (! solucionEncontrada)
     {   
      if (j==1)
       {
        escogidos++; 
        s=s+v[nivel];
        marca[nivel]=true;
       }    
      backtracking (nivel+1);
      if (j==1)
       {
        escogidos--;
        s=s-v[nivel];
        marca[nivel]=false;
       }
     }  
}
} 
