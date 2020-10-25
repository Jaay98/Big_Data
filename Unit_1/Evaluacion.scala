//Authors: Alonso Alvarez, Yim Quiroz
//Instituto Tecnologico de Tijuana
//Materia: Datos Masivos
//Evaluacion Unidad 1

//1-Comienza una simple sesión Spark
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

//2-.Cargue el archivo Netflix CSV,haga que Spark infiera los tipos de datos
val df = spark.read.option("header","true").option("inferSchema","true").csv("/Users/alons/OneDrive/Escritorio/Universidad/Datos Masivos/Big_Data/Unit_1/*.csv")


//3-.Cuáles son los nombres de las columnas
df.columns

//4-.Cómo es el esquema
df.printSchema()

//5-.Imprime las primeras 5 columnas
df.head(5)

//6-.Usa describe() para aprender sobre el DataFrame
df.describe().show()

/*7-.Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la  relación entre el precio 
de la columna “High” frente a la columna “Volume” de  acciones negociadas por un día. 
(Hint: Es una operación de columnas)*/
val df_hv = df.withColumn("HV Ratio",df("High")/df("Volume"))
df_hv.columns

// 8. ¿Qué día tuvo el pico mas alto en la columna “Close”? 
df.orderBy($"High".desc).show(1)

/*9. Escribe con tus propias palabras en un comentario de tu codigo. ¿Cuál es el  significado de la columna
 Cerrar “Close”?*/
df.select(mean("Close")).show()

// 10. ¿Cuál es el máximo y mínimo de la columna “Volume”?
df.select(max("Volume")).show()
df.select(min("Volume")).show()

//11.

//Sintaxis Scala/Spark
import spark.implicits._

// a. ¿Cuántos días fue la columna “Close” inferior a $ 600? 
df.filter($"Close"<600).count()


//b. ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?
(df.filter($"High" > 500).count() * 1.0/ df.count())*100

// c. ¿Cuál es la correlación de Pearson entre columna “High” y la columna “Volumen”?
df.select(corr("High","Volume")).show()

//  d. ¿Cuál es el máximo de la columna “High” por año? 
val yeardf = df.withColumn("Year",year(df("Date")))
val yearmaxs = yeardf.select($"Year",$"High").groupBy("Year").max()
val res = yearmaxs.select($"Year",$"max(High)")
res.orderBy("Year").show()

// e. ¿Cuál es el promedio de columna “Close” para cada mes del calendario? 
val monthdf = df.withColumn("Month",month(df("Date")))
val monthavgs = monthdf.select($"Month",$"Close").groupBy("Month").mean()
monthavgs.select($"Month",$"avg(Close)").orderBy("Month").show()