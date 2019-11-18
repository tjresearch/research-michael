import java.io.*;
import java.util.*;
public class Syslab{
   public static void main(String[] args) throws IOException
   {
      int[] test = new int[]{-2,-1,0,0,1,2};
      ArrayList<Vector> basis = generate(test);
      Collections.sort(basis);
      System.out.println(basis);
      int[][] adj = new int[basis.size()][basis.size()];
      int count = 0;
      for(int i = 0; i< basis.size();i++){
         for(int j = i; j< basis.size();j++){
            if(basis.get(i).ortho(basis.get(j))){
               adj[i][j] = 1;
               adj[j][i] = 1;
               count++;
            }
         }
      }
      System.out.println(count);
      int size = (basis.size() * (basis.size()-1))/2;
      System.out.println(size);
      File out = new File("output.txt");
      FileWriter fWriter = new FileWriter (out);
      PrintWriter pWriter = new PrintWriter (fWriter);
      pWriter.print("g = AdjacencyGraph[{{");
      for(int i = 0; i<adj.length; i++){
         if(i != 0) {
            pWriter.println(",");
            pWriter.print("{");
         }
         pWriter.print(adj[i][0]);
         for(int j = 1; j<adj.length;j++){
            pWriter.print(",");
            pWriter.print(adj[i][j]);
         
         }
         pWriter.print("}");
      }  
      pWriter.println("}]");
      pWriter.println("FindIndependentVertexSet[g]");
      pWriter.close();
   
   
      
   
   
   
   }
   public static ArrayList<Vector> generate(int[] nums){// generates it symmetrically in three dimensions;
      ArrayList<Vector> al = new ArrayList<Vector>();
      for(int i: nums){
         for(int j: nums){
            for(int k: nums){
               if(i != 0 || j != 0 || k!= 0){
                  al.add(new Vector(new int[]{i,j,k}));
               }
            }
         }
      }
      return al;
   }
}
class Vector implements Comparable<Vector>{
   public final static int size = 3; 
   int[] pos;
   Vector(int[] a){
      pos = a;
      if (a.length != size){
         System.out.println("Error");
      }
   }
   public int dotP (Vector other){
      int ret = 0;
      for(int i = 0; i< size; i++){
         ret+=pos[i]*other.pos[i];
      }
      return ret;
   }
   public boolean ortho(Vector other){
      return (this.dotP(other) == 0);
   }
   public String toString(){
      return Arrays.toString(pos);
   }
   public int compareTo(Vector other){
      if(pos[0]<other.pos[0])
         return -1;
      if(pos[0]>other.pos[0]) 
         return 1;
      if(pos[1]<other.pos[1])
         return -1;
      if(pos[1]>other.pos[1]) 
         return 1;
      if(pos[2]<other.pos[2])
         return -1;
      if(pos[2]>other.pos[2]) 
         return 1;
         return 0;
   }  
}