# Set custom keystore in server
 1. Create your keystore and certificate:
keytool -genkeypair -keystore <keystore name> -storetype PKCS12 -alias <certificate name> -keyalg RSA -keysize 2048 -validity 360
 2. OPTIONAL: Add more certificates to keystore
keytool -genkey -alias <certificate name> -keystore <path to keystore> -storetype PKCS12 -keyalg RSA -storepass <keystore password> -validity 730 -keysize 2048
 3. Add your keystore file to the spring project's /resource folder
 4. Link the keystore to the server's SSL settings by appending its name to the classpath in server.ssl.key-store
 5. Set server.ssl.key-store-type to match your keystore file's format. PKCS12 is the recommended industry standard.
 6. Set server.ssl.key-store-password to your key-store password
 7. Set server.ssl.key-alias to the name of the desired certificate in your key-store

### NB: ARXaaS runs in http by default.
To enable https in ARXaaS, please apply one of the following procedures
The values following the '='s are for guidance,
please change them to match user specific settings

### Option 1: Uncomment SSL settings from spring server application.properties, they should look like the following, change values after '='s to match user specific settings
server.ssl.key-store=classpath:<keystore name>
server.ssl.key-store-type=PKCS12
server.ssl.key-store-password=<keystore password>
server.ssl.key-alias=<certificate name>

### Option 2: run server and enable https from spring project folder
mvn spring-boot:run -Dserver.ssl.key-store-type=PKCS12 -Dserver.ssl.key-store=classpath:arxaas-keystore.p12 -Dserver.ssl.key-store-password=password -Dserver.ssl.key-alias=arxaas-https

### Option 3: run server and enable https from jar
java -jar aaas-0.1.1-RELEASE.jar --server.ssl.key-store-type=PKCS12 --server.ssl.key-store=classpath:arxaas-keystore.p12 --server.ssl.key-store-password=password --server.ssl.key-alias=arxaas-https

### Option 4: run server and enable https from docker image
docker run -p 8080:8080 -d arxaas/aaas --server.ssl.key-store-type=PKCS12 --server.ssl.key-store=classpath:arxaas-keystore.p12 --server.ssl.key-store-password=password --server.ssl.key-alias=arxaas-https