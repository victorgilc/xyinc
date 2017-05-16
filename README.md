# XY INC
Projeto fictício XY Inc
<br/>
Servidor WEB utilizado: <b>WildFly 10.x</b>
<br/>
Banco de Dados Utilizado : <b>MySQL</b>

<i>
CREATE DATABASE xyinc;
<br/><br/>
CREATE TABLE poi
<br/>
(
<br/>
    id int AUTO_INCREMENT primary key,
    <br/>
    nome varchar(100) not null,
    <br/>
    coordenada_x int not null,
    <br/>
    coordenada_y int not null,
    <br/>
    data_inclusao timestamp not null
    <br/>
);
</i>
<br/><br/>
Exemplo de URL para acesso a aplicação: <b>http://localhost:8080/poiEndpoint/<METODO_ACESSO></b>
<br/><br/>
Métodos de Acesso:
<br/>
<ul>
<li>listarPois</li>
<br/>
<li>llistarPoisProximidade</li>
<br/>
<li>cadastrar</li>
</ul>

