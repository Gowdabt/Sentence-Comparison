# Sentence-Comparison
groups together similar sentences (sentences where only a single word differ between them) and extracts the changes

## Prerequisites
place inputs in sentences.txt in folder where this programme is executing

## How to Run

###Compile

```
javac SentenceComparison.java
```

###run
```
javac SentenceComparison.java
```

##Output

output will be added to file named output.txt


###Sampleinput
01-01-2012 19:45:00 Naomi is getting into the car
01-01-2012 20:12:39 Naomi is eating at a restaurant
02-01-2012 09:13:15 George is getting into the car
02-01-2012 10:14:00 George is eating at a diner
03-01-2012 10:15:00 Naomi is eating at a diner
03-01-2012 11:22:40 Mike is getting into the car
03-01-2012 12:52:23 Mike is getting into the office
04-01-2012 21:55:05 Naomi is running into the car



###SampleOutput
01-01-2012 19:45:00 Naomi is getting into the car
04-01-2012 21:55:05 Naomi is running into the car
The changing word was:[getting, running]

02-01-2012 10:14:00 George is eating at a diner
03-01-2012 10:15:00 Naomi is eating at a diner
The changing word was:[George, Naomi]

01-01-2012 19:45:00 Naomi is getting into the car
02-01-2012 09:13:15 George is getting into the car
03-01-2012 11:22:40 Mike is getting into the car
The changing word was:[Naomi, George, Mike]

03-01-2012 11:22:40 Mike is getting into the car
03-01-2012 12:52:23 Mike is getting into the office
The changing word was:[car, office]

01-01-2012 20:12:39 Naomi is eating at a restaurant
03-01-2012 10:15:00 Naomi is eating at a diner
The changing word was:[restaurant, diner]
