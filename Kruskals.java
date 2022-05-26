import java.util.*;
class Edge
{
int v1,v2,wt;
}

class Kruskals
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int nv,ne,i,j,mincost=0;
System.out.println("Enter number of vertices:");
nv=sc.nextInt();
System.out.println("Enter number of edges:");
ne=sc.nextInt();
Edge ed[]=new Edge[ne+1];
for(i=1;i<=ne;i++)
{
ed[i]=new Edge();
System.out.println("Enter the vertices and the weight of the edge "+(i)+ ":");
ed[i].v1=sc.nextInt();
ed[i].v2=sc.nextInt();
ed[i].wt=sc.nextInt();
}
for(i=1;i<=ne;i++)
{
for(j=1;j<=ne-i;j++)
{
if(ed[j].wt>ed[j+1].wt)
{
Edge t=new Edge();
t=ed[j];
ed[j]=ed[j+1];
ed[j+1]=t;
}
}
}
Graph g=new Graph(nv);
System.out.println("MINIMUM SPANNING TREE:");
for(i=1;i<=ne;i++)
{
g.addEdge(ed[i].v1,ed[i].v2);
if(g.isCycle()==false)
{
System.out.println(ed[i].v1+ "-"+ ed[i].v2);
mincost+=ed[i].wt;
}
else
g.removeEdge(ed[i].v1,ed[i].v2);
}
System.out.println("MINIMUM COST = " +mincost);
}
}

class Graph
{
    private int nv;  
    private LinkedList<Integer> adj[];
 
    Graph(int n)
    {
        nv = n;
        adj = new LinkedList[n+1];
        for(int i=1; i<=n; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int u,int v)
    {
        adj[u].add(v);
        adj[v].add(u);
    }
   
    void removeEdge(int u,int v)
    {    
    for (int i = 0; i < adj[u].size(); i++)
    {
    if (adj[u].get(i) == v)
    {
    adj[u].remove(i);
    break;
    }
    }
      for (int i = 0; i < adj[v].size(); i++)
      {
      if (adj[v].get(i) == u)
      {
      adj[v].remove(i);
      break;
      }
      }
    }
 
    Boolean cycleCheck(int node,int parent,Boolean visited[])
    {
        visited[node] = true;
        Integer i;
        Iterator<Integer> it = adj[node].iterator();
        while(it.hasNext())
        {
            i = it.next();
            if (visited[i]==false)
            {
                if (cycleCheck(i,node,visited)==true)
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    Boolean isCycle()
    {
        Boolean visited[] = new Boolean[nv+1];
        for (int i = 1; i <= nv; i++)
            visited[i] = false;
        for (int u = 1; u <= nv; u++)
        {
            if (visited[u]==false)
                if (cycleCheck(u,-1,visited))
                    return true;
        }
        return false;
    }
}
