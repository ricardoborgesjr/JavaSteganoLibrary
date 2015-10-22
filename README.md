# JavaSteganoLibrary
## En_US
Java library that implements the steganographic algorithm F5

Usage:
Get the library in [here](https://github.com/ricardoborgesjr/JavaSteganoLibrary/blob/master/dist/JavaSteganoLibrary.jar), or make a clone this repository and compile the source code.

### Embeding a file in image

```java
import stegano.f5.Embed;

(...)

File coverImage = new File("/Path/to/image.jpg"); /* supports BMP */
File file = new File("/Path/to/file.foo");  /* any file format */
File steganoImage = newFile("/Path/to/create/image.jpg");

String password = "Sup3r_5ecR3T_P4sSw0rd";

int quality = 80; /* get better quality beteween 70 and 80 */

Embed e = new Embed();

e.setImage(coverImage);
e.setFile(file);
e.setStegImage(steganoImage);
e.setPassword(password);

e.embed();

(...)
```
### Extract file from image

```java
import stegano.f5.Extract;

(...)

File steganoImage new File("/Path/to/stegano/image.jpg");
File file new File("/Path/to/create/file.foo");

String password = "Sup3r_5ecR3T_P4sSw0rd";

Extract e = new Extract();

e.setStegImage(steganoImage);
e.setFile(file);
e.setPassword(password);

e.extract();

(...)
```

## Pt_BR
Biblioteca Java que implementa o algorítimo esteganográfico F5

Utilizando:
Faça o download da biblioteca [aqui](https://github.com/ricardoborgesjr/JavaSteganoLibrary/blob/master/dist/JavaSteganoLibrary.jar), ou faça uma cópia desse repositório e compile a biblioteca.

### Incorporando um arquivo em uma imagem

```java
import stegano.f5.Embed;

(...)

File imagem_cobertura = new File("/Caminho/para/a/imagem.jpg"); //Também suporta o formato BMP
File arquivo = new File("/Caminho/para/o/arquivo.file"); // qualquer formato de arquivo
File imagem_estenografada = new File("/Caminho/para/onde/sera/criada/a/imagem.jpg") ;

String senha = "s3nh4_5up3secReT4";

int qualidade = 80; //entre 80 e 70 onde se tem melhores resultados

Embed e = new Embed();

e.setImage(imagem_cobertura);
e.setFile(arquivo);
e.setStegImage(imagem_estenografada);
e.setPassword(senha);

e.embed();

(...)
```
### Extraindo um arquivo de uma imagem esteganografada.

```java
import stegano.f5.Extract;

(...)

File imagem_estenografada = new File("/Caminho/da/imagem.jpg") ;
File arquivo = new File("/Caminho/onde/sera/criado/o/arquivo.file");
String senha = "s3nh4_5up3secReT4"; //Deve ser a mesma senha utilizada para imcorporação

Extract e = new Extract();

e.setImage(imagem_estenografada);
e.setFile(arquivo);
e.setPassword(password);

e.extract();

(...)
```
