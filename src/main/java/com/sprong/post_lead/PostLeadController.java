package com.sprong.post_lead;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostLeadController {

    Logger logger = LoggerFactory.getLogger(PostLeadController.class);
    @PostMapping( "/server")
    public List<String> get_postlead(@RequestBody Input input){
        // reading the graph and parse to graph object
        logger.info("Start parsing the graph");
        // exsit_hand exsit_e2 is for later validations
        Boolean exsit_h = false;
        Boolean exsit_e2 = false;
        Graph g = new Graph();
        try {
            String g_donet = input.graph;
            g_donet = g_donet.substring(g_donet.indexOf("{") + 1);
            g_donet = g_donet.substring(0, g_donet.indexOf("}"));
            String[] edges = g_donet.split("\n");

            for (String s : edges) {
                if (s != "") {
                    String[] edge = s.split("->");
                    g.addEdge(edge[0], edge[1]);
                    if (edge[0].equals(input.h) || edge[1].equals(input.h)) {
                        exsit_h = true;
                    }
                    if (edge[0].equals(input.e2) || edge[1].equals(input.e2)) {
                        exsit_e2 = true;
                    }

                }
            }
        }
        catch(Exception e){
            logger.error("some problem in the parsing => " + e.getMessage());
            ArrayList<String> error = new ArrayList<>();
            error.add("some error in reading and parsing the graph");
            return error;
        }
        // validate if h and e2 in  the graph
        logger.info("validating the inputs");
        ArrayList<String> errormsg = new ArrayList<>();
        errormsg.add("some invalid input");
        if(exsit_h==false){
            logger.error(String.format("There are no h=%s vertex in the graph=%s, please check out your inputs", input.h, input.graph));
        }
        if(exsit_e2==false){
            logger.error(String.format("There are no e2=%s vertex in the graph=%s, please check out your inputs", input.e2, input.graph));
        }
        if(exsit_e2==false ||  exsit_h==false){
            return errormsg;
        }

        logger.info("Finding all the nodes that post-lead h");
        try {
            return g.getPostLeads(input.h, input.e2);
        }
        catch(Exception e){
            logger.error("make sure you there are at least one path between h to e2 or check this error=>" + e.getMessage());
            return errormsg;
        }

    }
}
