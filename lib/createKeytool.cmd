"%JAVA_HOME%\bin\keytool" -genkeypair -alias jetty -keyalg RSA -keysize 2048 -dname "CN=127.0.0.1, OU=VMware Inc, O=Ecosystem Services, L=Palo Alto, ST=CA, C=US" -keypass changeit    -validity 365 -storetype PKCS12 -keystore keystore.pkcs12 -storepass changeit
"%JAVA_HOME%\bin\keytool" -genkeypair -alias user -keyalg RSA -keysize 2048 -dname "CN=client, OU=VMware Inc, O=Ecosystem Services, L=Palo Alto, ST=CA, C=US" -keypass changeit    -validity 365 -storetype PKCS12 -keystore keystore.pkcs12 -storepass changeit