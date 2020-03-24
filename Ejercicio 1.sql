-- Ejercicio 1
-- Obtener el total del inventario de los ingredientes de tipo bowl.
use restaurant;
select sum(inventory) from ingredients where unit = 'bowl' 