
call mvn archetype:generate -DarchetypeVersion=1.2.3-SNAPSHOT -DinteractiveMode=false -DarchetypeGroupId=br.com.gumga  -DarchetypeArtifactId=projeto-archetype  -DgroupId=br.com.academiagumga  -DartifactId=junitspring -Dversion=1.0-SNAPSHOT
 cd junitspring 
call mvn clean install

 cd junitspring-domain 
 call mvn br.com.gumga:gumgag:entidade -Dentidade=br.com.academiagumga.junitspring.domain.model.ContaCorrente    -Datributos="titular:String:false,numero:String:false,limite:double:false,encerrada:GumgaBoolean:false"
call mvn br.com.gumga:gumgag:entidade -Dentidade=br.com.academiagumga.junitspring.domain.model.Transacao    -Datributos="data:Date:false,valor:double:false,descricao:String:false,transacaoConta:ContaCorrente:@ManyToOne"
call mvn clean install
cd ..

cd junitspring-application 
 call mvn br.com.gumga:gumgag:aplicacao -Dentidade=br.com.academiagumga.junitspring.domain.model.ContaCorrente
call mvn br.com.gumga:gumgag:aplicacao -Dentidade=br.com.academiagumga.junitspring.domain.model.Transacao
call mvn clean install
cd ..

cd junitspring-api 
 call mvn br.com.gumga:gumgag:api -Dentidade=br.com.academiagumga.junitspring.domain.model.ContaCorrente
call mvn br.com.gumga:gumgag:api -Dentidade=br.com.academiagumga.junitspring.domain.model.Transacao
call mvn clean install
cd ..

cd junitspring-presentation 
 call mvn br.com.gumga:gumgag:apresentacao -Dentidade=br.com.academiagumga.junitspring.domain.model.ContaCorrente
call mvn br.com.gumga:gumgag:apresentacao -Dentidade=br.com.academiagumga.junitspring.domain.model.Transacao
call mvn clean install
cd ..

call mvn clean install
