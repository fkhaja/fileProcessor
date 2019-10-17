# Getting Started

	This program reads in a list of employee records from an ascii input file and writes it out sorted list to an ASCII output file.
	The format of the input file could be either one of the two formats specified below. The input file will contain a file format code (1 or 2) on the first line and a sequence of records, with one record per line. 
	
	

###Input File Format 1
    In this format each record is in Byte format and 80 chars wide. Each record has the following elements
    
| Element Name	| Type/Format	| Max Length	| Optional	| Default	| Sample	|
| ------------- | ------------- | ------------- | --------- | --------- | --------- |
|First name		|Alpha			|10			|No			|			|Jon		|
|Last name		|Alpha			|17			|No			|			|Abner		|
|Start date 	|YYYYMMDD		|8			|No			|			|20031208	|
|Address 1		|AlphaNumeric	|10			|Yes		|None		|1 Jay St	|
|Address 2 		|AlphaNumeric	|10			|Yes		|None		|Apt 498	|
|City			|AlphaNumeric	|10			|Yes		|None		|Dublin		|
|State			|Alpha			|2			|Yes		|CA			|CA			|
|Country		|Alpha			|3			|Yes		|USA		|USA		|
|Zip			|Numeric		|10			|Yes		|None		|49567		|

	All Elements are left justified, and space filled. Optional elements are space filled if absent.
E.g. for file 1 (country is absent)

1

Jon       Abner            200312081 Jay St  Apt 498   Dublin    CA   49567

Will      Abner            200312081 Jay St  Apt 498   Dublin    CA   49567


###Input File Format 2
	In this format each element is comma separated. The characteristics of the elements are as mentioned above for format 1. No space filling is done in this case, however commas will be present as place holders for absent elements.
	
	E.g  for file format 2 

2 

Jon,Abner,20031208,1 Jay St,Apt 498,Dublin,CA,,49567 

Will,Abner,20031208,1 Jay St,Apt 498,Dublin,CA,USA,49567
 


###Output file format
	The output should be sorted by the first name, last name or start date depending on an argument passed in to the application at the time of invocation.
	The output should be written to an output file in the following format. Dates should be in human readable form (e.g. mm/dd/yyyy)

<Index Number>
  <First Name> <Last Name>, (<start date>),
  <Address 1>, <Address 2>,
  <City>,<State>,
<Country>,<Zip>

E.g 
1
   Jon Abner, (December 11, 2003)
   1 Jay St, Apt 498,
   Dublin,CA,
   USA,49567
2
   Will Abner, (December 11, 2003)
   1 Jay St, Apt 498,
   Dublin,CA,
   USA,49567

###Building the Project
	The project can be built using Maven. To build, run the Maven command:
```console
mvn clean package
```

###Running the Application
	The application is packaged in a jar file. Java 8 is needed in order to run this application. Check your java version by running 

```console
java -version
```
	
	The application takes in the following command line parameters:
	- inputFile (Required)
		- Full qualified path of the file containing Employee records in above file formats
	- sortBy (Optional)
		- The results can be sorted by 'firstName', 'lastName' or 'startDate'. Any other sort order is not recognized and the output will be saved in the order it was provided in the input file
		
	To run the application:
	
```console
java -jar fileProcessor.jar --inputFile=I:\test\input_file.csv --sortOrder=firstName
```

	An output file will be generated and saved in the same directory as the input file.



