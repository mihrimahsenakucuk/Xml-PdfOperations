# XmlPdfOperations

Bu proje XML dosyalarını işleyen, doğrulayan ve belirli kriterlere göre ayrıştıran bir Spring Boot uygulamasıdır.  
Yüklenen XML dosyalarını analizini yapar ve belirtilen invoiceID değeri ile eşleşen Xml dosyasını otomatik olarak hedef klasöre kopyalar. Ayrıca XML içeriklerini PDF formatına dönüşümünü sunar.
Proje aynı zamanda kullanıcı yönetimi, kimlik doğrulama ve yetkilendirme süreçlerini destekleyen güvenli bir mimari içerir.

## Kullanılan Teknolojiler
-Spring Boot
-Hibernate / JPA
-XML DOM Parser
-Spring Security
-JWT
-PostgreSQL

<img width="1917" height="757" alt="1Ekran Alıntısı" src="https://github.com/user-attachments/assets/4e3798db-eff6-4109-928c-6010af4eba8d" />
<img width="1891" height="340" alt="2Ekran Alıntısı" src="https://github.com/user-attachments/assets/9053bb98-7d49-4a34-87c0-0dc9ece08b07" />
<img width="1908" height="550" alt="3Ekran Alıntısı" src="https://github.com/user-attachments/assets/728c30ca-3403-4f25-91fe-6f872399890a" />
<img width="1903" height="560" alt="4Ekran Alıntısı" src="https://github.com/user-attachments/assets/335fe3fd-4fdd-47cb-9e00-d91d76e01699" />
<img width="1909" height="663" alt="5Ekran Alıntısı" src="https://github.com/user-attachments/assets/8bc03066-21c3-4ed6-bee6-3d3bdf5e8ac1" />
<img width="1878" height="831" alt="6Ekran Alıntısı" src="https://github.com/user-attachments/assets/c6553a86-4692-404d-91ef-08d1f7e3d65b" />


## API Endpoint'leri  
-POST /xml/upload  → XML dosyasını yükle ve invoiceID eşleşmesini kontrol et. JWT token ile doğrulanmış kullanıcılar erişebilir.
<img width="879" height="385" alt="7Ekran Alıntısı" src="https://github.com/user-attachments/assets/0c98df7b-b3ee-45f0-8443-5bcfdcef907e" />

-POST /pdf/  → XML’i PDF’e dönüştür. JWT token ile doğrulanmış kullanıcılar erişebilir.

-POST /users/createUser  → Yeni kullanıcı oluştur. Herkese  açıktır. 
```json
{
    "name":"mihrimah",
    "userName":"mihrimah17",
    "password":"123",
    "authorities":["ROLE_ADMIN"]
}
```

-POST auth/generateToken
```json
{
    "userName":"mihrimah17",
    "password":"123"
}
```

-GET  /users/users → Tüm kullanıcıları listele. JWT token ile doğrulanmış kullanıcılar erişebilir.

-DELETE /users/deleteUser/{id} → Belirtilen kullanıcıyı sil. JWT token ile sadece admin(ROLE_ADMIN) rolüne sahip kullanıcılar tarafından erişilebilir.











