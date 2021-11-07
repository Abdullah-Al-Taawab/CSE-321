import java.util.Scanner;

public class priority{
  
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    
    int x,n;
    int process[],processpriority[],bursttime[],waittime[],turnaroundtime[];
    int averagewaitingtime,averageturnaroundtime,i;
    
    process = new int[10];
    processpriority = new int[10];
    bursttime = new int[10];
    waittime = new int[10];
    turnaroundtime = new int[10];
    
    System.out.print("Enter the number of process : ");
    n = s.nextInt();
    System.out.print("\n\t Enter burst time : time priorities \n");
    
    for(i=0;i<n;i++)
    {
      System.out.print("\nProcess["+(i+1)+"]:");
      bursttime[i] = s.nextInt();
      processpriority[i] = s.nextInt();
      process[i]=i+1;
    }
    

    for(i=0;i<n-1;i++)
    {
      for(int j=i+1;j<n;j++)
      {
        if(processpriority[i]>processpriority[j])
        {
          x=processpriority[i];
          processpriority[i]=processpriority[j];
          processpriority[j]=x;
          x=bursttime[i];
          bursttime[i]=bursttime[j];
          bursttime[j]=x;
          x=process[i];
          process[i]=process[j];
          process[j]=x;
        }
      }
    }
    waittime[0]=0;
    averagewaitingtime=0;
    turnaroundtime[0]=bursttime[0];
    averageturnaroundtime=turnaroundtime[0];
    for(i=1;i<n;i++)
    {
      waittime[i]=turnaroundtime[i-1];
      averagewaitingtime+=waittime[i];
      turnaroundtime[i]=waittime[i]+bursttime[i];
      averageturnaroundtime+=turnaroundtime[i];
    }
    
    
    System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
    for(i=0;i<n;i++)
      System.out.print("\n   "+process[i]+"\t\t   "+bursttime[i]+"\t\t     "+waittime[i]+"\t\t     "+turnaroundtime[i]+"\t\t     "+processpriority[i]+"\n");
    averagewaitingtime/=n;
    averageturnaroundtime/=n;
    System.out.print("\n Average Wait Time : "+averagewaitingtime);
    System.out.print("\n Average Turn Around Time : "+averageturnaroundtime);
    
  }
}