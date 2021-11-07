import java.io.*;
class round{
 public static void main(String args[])throws IOException{
  DataInputStream in=new DataInputStream(System.in);
  int i,j,k,q,sum=0;
  System.out.println("Enter number of process:");
  int n=Integer.parseInt(in.readLine());
  int bursttime[]=new int[n];
  int waitingtime[]=new int[n];
  int turnaroundtime[]=new int[n];
  int a[]=new int[n];
  System.out.println("Enter brust Time:");
  for(i=0;i<n;i++){
   System.out.println("Enter brust Time for "+(i+1));
   bursttime[i]=Integer.parseInt(in.readLine());
  }
  System.out.println("Enter Time quantum:");
  q=Integer.parseInt(in.readLine());
  for(i=0;i<n;i++)
   a[i]=bursttime[i];
  for(i=0;i<n;i++)
   waitingtime[i]=0;
  do{
  for(i=0;i<n;i++){
   if(bursttime[i]>q){
    bursttime[i]-=q;
    for(j=0;j<n;j++){
     if((j!=i)&&(bursttime[j]!=0))
     waitingtime[j]+=q;
    }
   }
   else{
    for(j=0;j<n;j++){
     if((j!=i)&&(bursttime[j]!=0))
     waitingtime[j]+=bursttime[i];
    }
    bursttime[i]=0;
   }
  }
  sum=0;
  for(k=0;k<n;k++)
   sum=sum+bursttime[k];
  }
  while(sum!=0);
  for(i=0;i<n;i++)
   turnaroundtime[i]=waitingtime[i]+a[i];
  System.out.println("process\t\tbursttime\t waitingtime\t turnaroundtime ");
  for(i=0;i<n;i++){
   System.out.println("process "+(i+1)+"\t "+a[i]+"\t "+waitingtime[i]+"\t "+turnaroundtime[i]);
  }
  float avg_wt=0;
  float avg_tat=0;
  for(j=0;j<n;j++){
   avg_wt+=waitingtime[j];
  }
  for(j=0;j<n;j++){
   avg_tat+=turnaroundtime[j];
  }
  System.out.println("average waiting time "+(avg_wt/n)+"\n Average turn around time"+(avg_tat/n));
 }
}