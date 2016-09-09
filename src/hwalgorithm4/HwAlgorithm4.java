package hwalgorithm4;

import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class HwAlgorithm4 {
    
    static public class adjlist 
    {
        ArrayList<node> nodelist;
        ArrayList<edge> edgelist;
        public ArrayList getnodelist(){
            
            return this.nodelist;
        }
        public ArrayList getedgelist(){
            
            return this.edgelist;
        }
        public void show(int nodenum,int edgenum ){
           for(int i=0;i<nodenum;i++){
           
                System.out.printf("%d ->",nodelist.get(i).id);
                for(int j=0;j<edgenum;j++){
                    if(edgelist.get(j).pre == nodelist.get(i).id)
                        //System.out.printf("%d ",edgelist.get(i).pre);
                        System.out.printf("%d ",edgelist.get(j).next);
                }
                System.out.printf(" \n");
            }
        }
        public void rand(int nodenum,int edgenum )
        {
            Random rand = new Random();
            //int nodenum;
            //int edgenum;
            int i , j = 0;
            nodelist = new ArrayList<node>();
            edgelist = new ArrayList<edge>();
            //nodenum = rand.nextInt(10)+2;
            //edgenum = rand.nextInt(10)+1;
            ///System.out.printf("%d\n",nodenum);
            for(i = 0 ; i < nodenum ; i++)
            {
                node n = new node();
                n.id = i+1;
                n.data = rand.nextInt(nodenum+100)+1;
                nodelist.add(n);
            }
            for( j = 0 ; j < edgenum; j++)
            {
                edge e = new edge();
                //e.id = i + j+1;
                e.next = rand.nextInt(nodenum)+1;
                e.pre = rand.nextInt(nodenum)+1;
                e.id =e.pre;
                if(!edgelist.isEmpty() && j>1){
                    int test=0;
                    while(test<edgelist.size()){
                        for(int t=0;t<edgelist.size();t++){
                            for(int k=t+1;k<edgelist.size();k++){
                                if(edgelist.get(t).pre == edgelist.get(k).pre && edgelist.get(t).next == edgelist.get(k).next){
                                    for(; e.next == e.pre  ||edgelist.get(t).pre == edgelist.get(k).pre;)
                                    {
                                        edgelist.get(k).pre = rand.nextInt(nodenum)+1;
                                        edgelist.get(k).next = rand.nextInt(nodenum)+1;
                                        test--;
                                    }
                                }
                                else test++;
                            }
                        }
                    }
                }
                if(e.next == e.pre)
                {
                     for(; e.next == e.pre ;)
                     {
                         e.next = rand.nextInt(nodenum)+1;
                         e.pre = rand.nextInt(nodenum)+1;
                     }
                } 
                //System.out.printf("e.next%d\n",e.next);
                //System.out.printf("e.pre%d\n",e.pre);
                int t=0,d=0;
                //if(!edgelist.isEmpty() && edgelist.size()>1){
                    //for(int d=0;d<edgelist.size();d++){
              // if(j==2) edgelist.add(j, e);
                       /* if(edgelist.get(d).next>e.next){
                            //edgelist.add(e);
                            edgelist.add(d, e);
                            //edgelist.
                            t=1;
                        }*/
                    //}
                   // if(t==0) edgelist.add(e);
                //}
               // else 
              edgelist.add(e);
                
            }
      
        }
    }
    static public class node
    {
        int id;
        int data;
    }
    static public class edge
    {
        int id;
        int data;
        int pre;
        int next;
    }
   
   
    public static void main(String[] args) {
       
       ArrayList<node> nodelist = new ArrayList<node>();
       ArrayList<edge> edgelist = new ArrayList<edge>();
       
       //int nodenum=5,edgenum=3;
       
       System.out.println("Enter nodenum:");
       Scanner sc = new Scanner(System.in);
       int nodenum = sc.nextInt();
       System.out.println("Enter edgenum:");
       Scanner sc2 = new Scanner(System.in);
       int edgenum = sc2.nextInt();
       
       adjlist adj = new adjlist();
       adj.rand(nodenum,edgenum);
       
       nodelist = adj.getnodelist();
       edgelist =adj.getedgelist();
       
       adj.show(nodenum, edgenum);
      
       
       while(true){
           
           System.out.println("insert edge(1) or del node(2) or del edge(3)");
           Scanner sc6 = new Scanner(System.in);
           int iod = sc6.nextInt();
           if(iod==1){
            
               System.out.println("Enter insert edge (pre) :");
               Scanner sc3 = new Scanner(System.in);
               int insertedgepre = sc3.nextInt();

               System.out.println("Enter insert edge (next) :");
               Scanner sc4 = new Scanner(System.in);
               int insertedgenext = sc4.nextInt();
               Random rand = new Random();
               int con=0;
               for(int i=0;i<edgelist.size();i++){
                   if(edgelist.get(i).pre==insertedgepre && edgelist.get(i).next==insertedgenext){
                       con=1;
                       System.out.println("FALUSE");
                       break;
                   }
               }
               if(con==0){
                   edge e = new edge();
                   e.id = edgelist.size()+1;
                   e.next = insertedgenext;
                   e.pre = insertedgepre;
                   edgelist.add(e);
                   adj.show(nodenum, edgelist.size());
               }
           }
           else if(iod==2){
               System.out.println("Enter del node num:");
               Scanner sc7 = new Scanner(System.in);
               int delnum = sc7.nextInt();
               int nume =edgelist.size();
               for(int i=nume-1;i>=0;i--){
                   if(edgelist.get(i).pre==delnum){                       
                       edgelist.remove(i);
                   }  
               }
               int numn =nodelist.size();
               for(int i=numn-1;i>=0;i--){                   
                   if(nodelist.get(i).id==delnum){
                       nodelist.remove(i);
                       break;
                   }     
               }
               adj.show(nodelist.size(), edgelist.size());
           }
           else if(iod==3){
               System.out.println("Enter del edge pre:");
               Scanner sc8 = new Scanner(System.in);
               int deledgpre = sc8.nextInt();
               System.out.println("Enter del edge next:");
               Scanner sc9 = new Scanner(System.in);
               int deledgnext = sc9.nextInt();
               int nume =edgelist.size();
               for(int i=nume-1;i>=0;i--){
                   if(edgelist.get(i).pre==deledgpre && edgelist.get(i).next==deledgnext){                       
                       edgelist.remove(i);
                   }  
               }
               adj.show(nodelist.size(), edgelist.size());
           }
           
           System.out.println("continue(1) or stop(2):");
           Scanner sc5 = new Scanner(System.in);
           int chose = sc5.nextInt();
            
           if(chose==2)break;
       }
       
       //int a = nodelist.size();
       //int b = edgelist.size();
       //System.out.printf("%d\n",a);
       //System.out.printf("size%d\n",b);
       
       
       //Queue<node> q = new LinkedList<node>() ;
       //Queue<node> qnew = new LinkedList<node>() ;
       // int[] visit = new int[a];
       //for (int i=0; i<a; i++)
       //    visit[i] = 0;
       //for (int k=0; k<nodelist.size(); k++){
          // if (visit[0]==0)
          // {
             
           //    q.add(nodelist.get(0));
            //   qnew.add(nodelist.get(0));
           //    visit[0] = 1;
              // int b;
           //    b =edgelist.get(0).pre;
            //   System.out.printf("%d\n",b);
             //  while (!q.isEmpty())
             //  {
                  
              //     int i = q.poll().id;
                     /*
                   
                   for (int j=0; j<edgelist.size(); j++){
                       
                       if ( i==edgelist.get(j).next )
                       {
                          if(visit[edgelist.get(j).pre]==0)
                          {
                              q.add(nodelist.get(edgelist.get(j).pre));
                              qnew.add(nodelist.get(edgelist.get(j).pre));
                              visit[edgelist.get(j).pre]=1;
                              break;
                          }
                       }
                       else if ( i==edgelist.get(j).pre )
                       {
                           if(visit[edgelist.get(j).next]==0)
                          {
                              q.add(nodelist.get(edgelist.get(j).next));
                              qnew.add(nodelist.get(edgelist.get(j).next));
                              visit[edgelist.get(j).next]=1;
                              break;
                          }
                       }
                   }*/
              //  }
          //  } 
       // }
          // System.out.printf(qnew.toString());
      
    }
 
}