//Evaluacion
//Author Alvarez Yanez Jose Alonso
//17210526

import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header","true").option("inferSchema","true").csv("/Users/alons/OneDrive/Escritorio/Universidad/Datos Masivos/Big_Data/Unit_1/*.csv")
