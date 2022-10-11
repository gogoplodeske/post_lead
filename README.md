# post_lead
Definition of post-lkead: In a single-entry, single-exit control flow
graph (CFG), a node u post-lead v if every path from v to the
exit includes u.
this repo is java  http server implemntaion with REST API that gets as an
input(G, e1, e2, h) while:
G: is a string in dot format that represent a control flow
graph.
e1: an entry node in the graph
e2: an exit node in the graph
h: a node in the graph
The server outputs all the nodes that post-lead h in the
graph.

For example:
$ curl -X POST http://localhost:10000/server -H
"contenttype:application/json" -d '{"e1": "1","e2": "7","h":
"2","graph": " digraph graphname{\n1->2\n2->3\n2->5\n5->2\n3->5\n5->7}"}'
The server should return {5,7}
