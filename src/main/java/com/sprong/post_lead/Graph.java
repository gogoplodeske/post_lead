package com.sprong.post_lead;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;

public class Graph {

    // adjacency list
    private Map<String, List<String> > adjList = new HashMap<>();



    // add edge from u to v
    public void addEdge(String u, String v)
    {
        //encase if u doesn't exit already in ajList
        if(!adjList.containsKey(u)) {
            adjList.put(u,new LinkedList<String>());
        }
        // Add v to u's list.
        adjList.get(u).add(v);

    }

    // get all h post lead
    public List<String> getPostLeads(String h, String e2)
    {
        // visited to save the visited nodes in the path

        HashSet<String> visited=new HashSet();
        ArrayList<String> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(h);
        // frequencies to save for each node the number of paths pass through it from h to e2
        Hashtable<String, Integer> frequencies= new Hashtable<String, Integer>();
        // Call recursive utility
        getPostLeadsUtil(h, e2, visited, pathList,frequencies);
        // post_lead_edges is to contain the nodes with their frequency equal to the exit
        List<String> post_lead_edges = new ArrayList<String>();
        post_lead_edges.add(e2);
        // iterating each node and get all the nodes frequency equal to the exit
        Enumeration<String> e = frequencies.keys();
        while(e.hasMoreElements()){
            String key = e.nextElement();
            // important that we don't check for e2(because already added) and h.
            if(!key.equals(h) && !key.equals(e2)){
                if(frequencies.get(key)==frequencies.get(h)){
                    post_lead_edges.add(key);
                }
            }
        }
        return post_lead_edges;
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // Visited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // and once found a path the frequencies get updated
    // vertices in the current path
    private void getPostLeadsUtil(String u, String d,
                                  HashSet<String> visited,
                                   List<String> localPathList, Hashtable<String, Integer> frequencies) {

        if (u.equals(d)) {
            // if match found then need to increment the y frequency node in the path
            for(String e:localPathList){
                if( frequencies.containsKey(e)){
                    frequencies.put(e, frequencies.get(e)+1);
                }
                else{
                    frequencies.put(e,1);
                }
            }
            // if match found then no need to traverse more till depth
            return;
        }

        // Mark the current node
        visited.add(u);

        // Recur for all the vertices
        // adjacent to current vertex
        for (String i : adjList.get(u)) {
            if (!visited.contains(i)) {
                // store current node
                // in path[]
                localPathList.add(i);
                getPostLeadsUtil(i, d, visited, localPathList, frequencies);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // unMark the current node
        visited.remove(u);
    }
}
