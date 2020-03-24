-- Ejercicio 2
-- Obtner el nombre del item del ingrediente mas caro. 
select items.name from madewith
inner join items on madewith.itemid = items.itemid
inner join ingredients on madewith.ingredientid = ingredients.ingredientid && ingredients.unitprice = (select max(unitprice) from ingredients);
-- No se puede seleccionar el nombre ya que esta como "name" en ambas tablas y sale como name como una columna ambigua
-- Por eso el "select items.name" y no "select * "


