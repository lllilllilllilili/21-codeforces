select i.animal_id, i.name from animal_ins i where i.name like '%el%' and i.animal_type = 'Dog' order by i.name
#이름에 el 이 들어가니까 어느 위치인지 알 수 없으므로 % % 사이에 쓰고, 일반적으로 equal 관계는 = 를 쓴다. 