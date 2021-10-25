/*

hdfs Directories

/
wordCount
  | |
  | |
  | input_data
  |   |
  |   |
  |   input.txt
  |
  output_data
      |
      |
      output.txt

*/


// open spark-shell and run these lines 

val data = sc.textFile("/wordCount/input_data/input.txt")

val splitData = data.flatMap(line => line.split(" "))

val mapData = splitData.map(word => (word, 1))

val reduceData = mapData.reduceByKey(_+_)

reduceData.saveAsTextFile("/wordCount/output_data/output.txt)

