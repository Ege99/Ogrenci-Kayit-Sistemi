# Ogrenci-Kayit-Sistemi
Öğrenci Kayıt Sistemi

Geliştirilmesi istenilen uygulamanın arayüzü olmayacak sadece aşağıdaki gereksinimleri REST API ile karşılayacaktır.

- Uygulama Spring boot 2.* ile geliştirilecektir ve kaynak kodları bir versiyon kontrol yönetim sistemi üzerinden paylaşılacaktır (tercihen github veya bitbucket).

- Geliştirilen API'lerin unit testleri de proje ile paylaşılacaktır.

- Uygulamada oluşturulan veriler inmemory veritabanında tutulacaktır.

- Veri erişimi için JPA kullanılması beklenmektedir.

Uygulama üniversitelerin kullandığı öğrenci kayıt sistemlerinin basit bir versiyonu olacaktır. REST API üzerinden aşağıdaki işlemlerin yapılabilmesi beklenmektedir.

- Sistemde açılan derslerin listelenmesi, yeni bir ders tanımlanması ve var olan derslerin güncellenmesi

- Sistemde tanımlı öğrencilerin listelenmesi, yeni bir öğrenci tanımlanması ve var olan öğrencinin güncellenmesi

- Bir öğrencinin aldığı derslerin listelenmesi, bir dersi bırakması, bir derse kaydolması

- Öğrencilerin dersi alırken o ders tanımında belirlenmiş olan maksimum öğrenci sayısından (kontenjan) fazla öğrencinin kaydolmasının engellenmesi ve bu durumda hata alınması.

- Sistemde tanımlı olan derslere kaydolan öğrencilerin listelenmesi.
