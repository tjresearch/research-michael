# Michael Huang's Research on Witsenhausen's problem

This github repo will be showing my work on Witsenhausen's problem, which looks to find the maximum area of the largest non-orthogonal set on a unit sphere. For my project, I will be working specifically on the 3-dimensional case. My methodology uses a probablistic method. I essentially rotate a set of vectors around and calculate the largest maximum independent vertex set among this set of vectors. 

To run my code, you will need to be able to run Java code as well as the capability to run Wolfram Mathematica.
For information on installing java: https://www.java.com/en/download/help/download_options.xml
For information on getting Woflram Mathematica: https://www.wolframalpha.com/downloads.html

To run my java code, simply enter what you wish the basis set to be when I initialize the basis set. It will output the adjacency matrix created by the ensuing vector set into a text file called output.txt. This text file has been formatted to be compatible with Mathematica. Simply copy and paste this into mathematica, which, when run, will give you a graph g on which you can calculate the Maximum Independent Vertex Set.
