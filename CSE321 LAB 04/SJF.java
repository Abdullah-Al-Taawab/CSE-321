import java.util.*;
 
public class SJF {
 public static void main (String args[])
 {
  Scanner sc=new Scanner(System.in);
  System.out.println ("enter no of process:");
  int n= sc.nextInt();
  int processnum[] = new int[n]; 
  int arrivaltime[] = new int[n]; 
  int bursttime[] = new int[n]; 
  int completetime[] = new int[n];
  int turnaroundtime[] = new int[n];
  int waitingtime[] = new int[n];  
  int flag[] = new int[n];  
  int k[]= new int[n];   
     int i, st=0, tot=0;
     float avgwt=0, avgta=0;
 
     for (i=0;i<n;i++)
     {
      processnum[i]= i+1;
      System.out.println ("enter process " +(i+1)+ " arrival time:");
      arrivaltime[i]= sc.nextInt();
      System.out.println("enter process " +(i+1)+ " burst time:");
      bursttime[i]= sc.nextInt();
      k[i]= bursttime[i];
      flag[i]= 0;
     }
     
     while(true){
      int min=99,c=n;
      if (tot==n)
       break;
      
      for ( i=0;i<n;i++)
      {
       if ((arrivaltime[i]<=st) && (flag[i]==0) && (bursttime[i]<min))
       { 
        min=bursttime[i];
        c=i;
       }
      }
      
      if (c==n)
       st++;
      else
      {
       bursttime[c]--;
       st++;
       if (bursttime[c]==0)
       {
        completetime[c]= st;
        flag[c]=1;
        tot++;
       }
      }
     }
     
     for(i=0;i<n;i++)
     {
      turnaroundtime[i] = completetime[i] - arrivaltime[i];
      waitingtime[i] = turnaroundtime[i] - k[i];
      avgwt+= waitingtime[i];
      avgta+= turnaroundtime[i];
     }
     
     System.out.println("process  arrival  burst  complete turn waiting");
     for(i=0;i<n;i++)
     {
      System.out.println(processnum[i] +"\t"+ arrivaltime[i]+"\t"+ k[i] +"\t"+ completetime[i] +"\t"+ turnaroundtime[i] +"\t"+ waitingtime[i]);
     }
     
     System.out.println("\naverage turnaroundtime is "+ (float)(avgta/n));
     System.out.println("average waitingtime is "+ (float)(avgwt/n));
     sc.close();
 }
}