# OOP_EX2-Ex4
Written  by : Ariel Bar, Moshe Elhadad.

In the project we started developing an infrastructure in order to represent a geographic information in a graphic tools. 
In particular the following package were written :
1)Geom:  a package of geometric information including points , paths ,lines ,circles , squares.
2)Coords: a basic coordinate system converter, using the foloowing class:
      *Mycoords: including the following operation:
          1. The 3D vector between two lat,lon, alt points 
          2. Adding a 3D vector in meters to a global point.
          3. convert a 3D vector from meters to polar coordinates
3)Gis: in the package there are several classes:
       *gis element: creating a single  element which holds a single information of  
          Geometric representation and meta data such as: name, color ,timing…
       *gis layer: creating a layer which holds a multiple gis element objects.
       *gis project: creating a project which holds a multiple gis layer objects.
       *meta data : holds the information of geometric representation   such as: name, color ,timing .
4)File Format:  a package which allows keeping the geographic information.
in the package there are several classes:
       *csv Reader- reading the csv file and saving the information.
       *csv Data- holds the information accepting from the csv Reader
       *data to layer- creating a gis layer by using csv Data class.
       *to kml – converting the information to kml file in order to represent the information in a graphic tools.
       *multi-  searching  in folders csv files (recursively).after done searching ,keeping the files in a project and creating a kml page           ,using "to kml" class.


