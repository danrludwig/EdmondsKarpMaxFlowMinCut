This program reads in 5 different graphs and uses Edmonds Karp's max-flow solution and shows the min-cut.
The results of the max flow and min cut are shown in the output. Main is found in MaxFlow. Program runs all the demands.

OUTPUT:
demands1.txt

MAX FLOW:
Found flow 2: [0, 1, 3, 5]
Found flow 2: [0, 2, 4, 5]
Found flow 1: [0, 1, 3, 4, 5]
Found flow 1: [0, 2, 3, 4, 5]
Produced 6

Edge (0,2) transports 3 cases
Edge (0,1) transports 3 cases
Edge (1,3) transports 3 cases
Edge (1,2) transports 0 cases
Edge (2,4) transports 2 cases
Edge (2,3) transports 1 cases
Edge (3,5) transports 2 cases
Edge (3,4) transports 2 cases
Edge (4,5) transports 4 cases

MIN CUT:
Edge (0,2) transports 3 cases
Edge (0,1) transports 3 cases
-------------------------------

OUTPUT:
demands2.txt

MAX FLOW:
Found flow 4: [0, 1, 3, 6, 8]
Found flow 1: [0, 2, 5, 6, 8]
Found flow 1: [0, 1, 4, 5, 6, 8]
Found flow 1: [0, 1, 4, 5, 7, 8]
Produced 7

Edge (0,2) transports 1 cases
Edge (0,1) transports 6 cases
Edge (1,4) transports 2 cases
Edge (1,3) transports 4 cases
Edge (2,5) transports 1 cases
Edge (2,4) transports 0 cases
Edge (3,6) transports 4 cases
Edge (3,4) transports 0 cases
Edge (4,5) transports 2 cases
Edge (5,7) transports 1 cases
Edge (5,6) transports 2 cases
Edge (6,8) transports 6 cases
Edge (6,7) transports 0 cases
Edge (6,4) transports 0 cases
Edge (7,8) transports 1 cases

MIN CUT:
Edge (2,5) transports 1 cases
Edge (3,6) transports 4 cases
Edge (5,7) transports 1 cases
Edge (5,6) transports 2 cases
-------------------------------

OUTPUT:
demands3.txt

MAX FLOW:
Found flow 4: [0, 1, 3, 6, 8]
Found flow 2: [0, 2, 5, 6, 8]
Found flow 4: [0, 1, 4, 5, 7, 8]
Produced 10

Edge (0,2) transports 2 cases
Edge (0,1) transports 8 cases
Edge (1,4) transports 4 cases
Edge (1,3) transports 4 cases
Edge (2,5) transports 2 cases
Edge (2,4) transports 0 cases
Edge (3,6) transports 4 cases
Edge (3,4) transports 0 cases
Edge (4,5) transports 4 cases
Edge (5,7) transports 4 cases
Edge (5,6) transports 2 cases
Edge (6,8) transports 6 cases
Edge (6,7) transports 0 cases
Edge (6,4) transports 0 cases
Edge (7,8) transports 4 cases

MIN CUT:
Edge (0,2) transports 2 cases
Edge (0,1) transports 8 cases
-------------------------------

OUTPUT:
demands4.txt

MAX FLOW:
Found flow 10: [0, 2, 4, 3, 7]
Found flow 10: [0, 1, 2, 4, 7]
Found flow 10: [0, 1, 5, 4, 7]
Found flow 5: [0, 1, 3, 7]
Produced 35

Edge (0,2) transports 10 cases
Edge (0,1) transports 25 cases
Edge (1,5) transports 10 cases
Edge (1,3) transports 5 cases
Edge (1,2) transports 10 cases
Edge (2,4) transports 20 cases
Edge (3,6) transports 0 cases
Edge (3,7) transports 15 cases
Edge (4,7) transports 20 cases
Edge (4,3) transports 10 cases
Edge (5,4) transports 10 cases
Edge (6,2) transports 0 cases

MIN CUT:
Edge (0,2) transports 10 cases
Edge (0,1) transports 25 cases
-------------------------------

OUTPUT:
demands5.txt

MAX FLOW:
Found flow 1: [0, 2, 5, 8]
Found flow 3: [0, 1, 4, 7, 8]
Found flow 3: [0, 1, 4, 3, 6, 7, 8]
Produced 7

Edge (0,2) transports 1 cases
Edge (0,1) transports 6 cases
Edge (1,4) transports 6 cases
Edge (1,2) transports 0 cases
Edge (2,5) transports 1 cases
Edge (3,6) transports 3 cases
Edge (4,5) transports 0 cases
Edge (4,7) transports 3 cases
Edge (4,3) transports 3 cases
Edge (5,8) transports 1 cases
Edge (6,7) transports 3 cases
Edge (7,8) transports 6 cases

MIN CUT:
Edge (5,8) transports 1 cases
Edge (4,7) transports 3 cases
Edge (4,3) transports 3 cases
-------------------------------
