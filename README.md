 #JavaSteganoLibrary
##En_US
Java library that implements the steganographic algorithm F5

Usage
Coming soon.
##Pt_BR
Biblioteca Java que implementa o algorítimo esteganográfico F5

Utilizando:
Faça o download da biblioteca [aqui](https://github.com/ricardoborgesjr/JavaSteganoLibrary/blob/master/dist/JavaSteganoLibrary.jar), ou faça uma cópia desse repositório e compile a biblioteca.

###Incorporando um arquivo em uma imagem

```java
import stegano.f5.Embed;

.
.
.

File imagem_cobertura = new File(“/Caminho/para/a/imagem.jpg”); //Também suporta o formato BMP
File arquivo = new File(“/Caminho/para/o/arquivo.file”); // qualquer formato de arquivo
File imagem_estenografada = new File(“/Caminho/para/onde/sera/criada/a/imagem.jpg”) ;

String senha = “s3nh4_5up3secReT4”;

int qualidade = 80; //entre 80 e 70 onde se tem melhores resultados

Embed.embed(imagem, arquivo, imagem_estenografada, senha, qualidade);
.
.
.

```
###Extraindo um arquivo de uma imagem esteganografada.

```java
import stegano.f5.Extract;

.
.
.

File imagem_estenografada = new File(“/Caminho/da/imagem.jpg”) ;
File arquivo = new File(“/Caminho/onde/sera/criado/o/arquivo.file”);
String senha = “s3nh4_5up3secReT4”; //Deve ser a mesma senha utilizada para imcorporação

Extract.extract(imagem_estenografada, arquivo, senha);

.
.
.

```
