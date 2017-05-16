# XY INC
Projeto fictício XY Inc
<br/>
Servidor WEB utilizado: <b>WildFly 10.x</b>
<br/>
Banco de Dados Utilizado : <b>MySQL</b>

<code>
CREATE TABLE poi
(
	id int AUTO_INCREMENT primary key,
	nome varchar(100) not null,
    coordenada_x int not null,
    coordenada_y int not null,
    data_inclusao timestamp not null
);
</code>

Exemplo de URL para acesso a aplicação: http://localhost:8080/poiEndpoint/<METODO_ACESSO>

Métodos de Acesso:
<br/>
<b>-listarPois</b>
<br/>
<b>-listarPoisProximidade</b>
<br/>
<b>-cadastrar</b>

