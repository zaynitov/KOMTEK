# KOMTEK
Сервис «Исследования
!!!!Порт для использования 8010!!!

Были использованы:
Spring Boot
MySQL
Hibernate
JAVA 8

Для использования сервиса для начала создайте две таблицы
patient-таблица с пациентами
completebloodcount-таблица с общими анализами крови.

CREATE TABLE patient (SNILS int NOT NULL, surname VARCHAR(20), 
name VARCHAR(20), patronymic CHAR(20), birth DATE, 
PRIMARY KEY (SNILS) ); 

CREATE TABLE completebloodcount ( 
id int AUTO_INCREMENT NOT NULL, 
idpatientsnils int not null , 
measuredate DATE, 
hemoglobin double, 
redbloodcell double, 
avgrbc double, 
HGB double, 
PRIMARY KEY (id), 
FOREIGN KEY (idpatientsnils) 
REFERENCES patient (SNILS) 
ON DELETE CASCADE 
ON UPDATE CASCADE 
);
Функционал задания реализован полностью(для его использования удобнее пользоваться UI:
1. Добавление пациента - http://localhost:8010/addPatient
2. Получение списка пациентов -http://localhost:8010/getAllPatients
3. Редактирование пациента -http://localhost:8010/updatePatient/{id} id-снилс пациента
4. Удаление пациента - http://localhost:8010/deletePatient/{id}    id-снилс пациента
5. Добавление исследования - http://localhost:8010/addBloodForPatient/{id}   id-снилс пациента  
6. Получение списка исследований по пациенту http://localhost:8010/getAllBloodsForPatient/{id}  id-снилс пациента
7. Редактирование исследования - http://localhost:8010/getAllBloodsForPatient/{snils}/updateBlood/{id} id-id анализа
8. Удаление исследования - http://localhost:8010/getAllBloodsForPatient/{snils}/deleteBlood/{id}  id-id анализа


