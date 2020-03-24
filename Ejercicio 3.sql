-- Ejercicio 3
-- Mostrar alfabeticamente los nombres de los ingredientes si el nombre del vendedor termina con y.

select name from ingredients 
inner join vendors on ingredients.vendorid = vendors.vendorid && vendors.repfname like '%y' order by name asc;



