<h1>Tecnológico Nacional de México</h1>
<h6> Instituto Tecnológico de Tijuana 

Subdirección Académica 
Departamento de Sistemas y Computación 

Semestre: Septiembre - Enero 2020-2021

Materia:
Datos Masivos

Profesor: 
Jose Christian Romero Hernandez

Alumno: 
17210526 Alvarez Yanez Jose Alonso


Fecha:
20/10/2020 </h6>




###Practice 1.

1.Calculate the radius of a circle

~~~
val area=98
val radio= area/(2*3.1416)
~~~

2.Define if a number is even
 ~~~
def numero_primo(n :Int) : Boolean = 
{
    if (n <= 1)
    false
    else (n==2)
    true
   !(2 to (n-1)).exists(x=> n % x==0)
}
~~~

3.Using the variable bird = "tweet", use string interpolation to print "I'm writing a tweet"
~~~
var bird= "tweet"
println ("Estoy escribiendo un" + bird)
~~~

4. Using the variable message = "Hi Luke, I'm your father!" use slice to extract the sequence "Luke"

~~~
var mensaje = "Hola Luke soy  tu padre!"
mensaje.slice(5,9)
~~~

5. What is the difference between value and a variable in scala?
A value is immutable, instead the variable can change its value

6. Using the tuple (2,4,5,1,2,3,3.1416,23) returns the number 3.1416

~~~
val tupla = (2,4,5,1,2,3,3.1416,23)
println (tupla._7)
~~~




